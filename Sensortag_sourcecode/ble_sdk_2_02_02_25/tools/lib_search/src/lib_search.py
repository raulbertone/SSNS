#!/usr/bin/python
'''
/******************************************************************************
 @file  lib_search.py

 @brief This file contains lib search source. The main purpose of this tool
        is to determine which BLE stack libraries should be linked into a
        given stack project.

        All stack configurations are defined in a single file in the stack
        project. That file is provided as input to this script during a stack
        project prebuild step. The configurations are determined and the
        correct pre-built stack libraries are added to a linker command file
        as output. The stack project then links to this output file.

        This script was tested using Python v2.7 32bit for Windows. An
        equivalent Windows executable is provided which was created using
        py2exe. For all other systems this script is provided as a starting
        point and is not guaranteed to work.

 Group: WCS, BTS
 Target Device: CC2650, CC2640

 ******************************************************************************
 
 Copyright (c) 2015-2018, Texas Instruments Incorporated
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 *  Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.

 *  Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.

 *  Neither the name of Texas Instruments Incorporated nor the names of
    its contributors may be used to endorse or promote products derived
    from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 ******************************************************************************
 Release Name: ble_sdk_2_02_02_25
 Release Date: 2018-04-02 18:03:35
 *****************************************************************************/
'''

import argparse
import os
import sys
import shutil
import re
import itertools
import copy
from lxml import etree

__version__ = '1.2.0'

CMD_HEADER = \
"""/*
 * DO NOT MODIFY. This file is automatically generated during the pre-build
 *                step by the lib_search utility
 */

"""


def inputArgExpansion(arg):
    '''
    Verify input argument exists and if so expand to absolute path
    '''
    if not os.path.exists(arg):
        arg = os.path.join(os.getcwd(), arg)
    if not os.path.exists(arg):
        sys.exit("<<< ERROR >>>\nCannot find input file \"" + arg + "\"\n<<< /ERROR >>>")

    arg = os.path.abspath(arg)
    return arg


def parseXML(name, xmlTemplate):
    '''
    This function scans through lib search xml file determine the relative
    path of the 'name' lib on the system, which configs are pertinent for
    that lib, and what paramters are pertinent for each config that must
    be matched. See xml files in this local directory for more explanation.
    '''
    params = []
    relPath = ""
    addconfig = ""

    with open(xmlTemplate, 'r') as f:
        lxml_parser = etree.XMLParser(remove_blank_text=True)
        tree = etree.parse(f, lxml_parser)
        root = tree.getroot()
        libnodes = root.xpath("./library/name[text()=$libname]/..", libname=name)

        if len(libnodes) == 1:
            libnode = libnodes[0]

            if libnode.find('searchpath') is not None:
                relPath = os.path.normpath(libnode.find('searchpath').text)

            if libnode.find('matchconfig') is not None:
                addconfig = libnode.find('matchconfig').text

            # Build Paramater for this Library
            nodes = libnode.xpath("./parameterlist/parameter")
            for node in nodes:
                define = node.find('define').text
                req = node.find('assign/required').text
                args = []
                dcas = []
                argnodes = node.xpath("./assign/arg")
                dcanodes = node.xpath("./assign/dca")
                for argnode in argnodes:
                    args.append(argnode.text)
                for dcanode in dcanodes:
                    dcas.append(dcanode.text)

                params.append([define, req, args, dcas])

    return (relPath, addconfig, params)


def libsToSearch(xmlTemplate):
    '''
    This function scans through lib search xml file to determine all
    of the libs which must be found. See xml files in this local
    directory for more explanation.
    '''
    libs = []

    with open(xmlTemplate, 'r') as f:
        lxml_parser = etree.XMLParser(remove_blank_text=True)
        tree = etree.parse(f, lxml_parser)
        root = tree.getroot()

        nodes = root.xpath("./library")
        for node in nodes:
            libs.append(node.find('name').text)

    return libs


def parseOPT(opt, variables):
    '''
    Given the stack project opt file, scan through the file and remove any
    extraneous information or defines. Return a refined set of defines that
    can be used to match against the standard opt file contents used to
    generate the actual libraries
    '''
    optparams = []
    comment = False

    with open(opt) as data:
        defines_found = []

        # Strip all commented items from opt file
        fline = data.readline()
        filestr = ''
        while fline:
            fline = fline.strip() + "\n"
            filestr += fline
            fline = data.readline()
        filestr = re.sub(r"(/\*(.|[\r\n])*?\*/)|(//.*)", "", filestr)
        lines = filestr.split('\n')

        # Match any defines from xml that exist in opt
        for line in lines:
            for define, req, args, dcas in variables:
                if line and "-D"+define in line:
                    defines_found.append(define)
                    line = line.strip()
                    fragments = line.split("=")

                    # No Assignment Required
                    if req == '0':
                        line = fragments[0]
                    # Must check assignments and match those in cfg
                    else:
                        if len(fragments) < 2:
                            print "<<< ERROR >>>"
                            print "Assignment required for " + fragments[0]
                            print "<<< /ERROR >>>"
                            sys.exit(1)

                        # Remove DCAs from Assignment (DCA = Don't Care Argument)
                        assignments = fragments[1].split('+')
                        for dca in dcas:
                            if dca in assignments:
                                assignments.remove(dca)

                        if len(assignments):
                            fragments[1] = '+'.join(assignments)
                            line = '='.join(fragments)

                            if fragments[1] not in args:
                                # Checking possible permutations : aka PING+PARAM_REQ or PARAM_REQ+PING
                                dargs = fragments[1].split("+")
                                permFound = False
                                for perm in itertools.permutations(dargs):
                                    permstr = "+".join(perm)
                                    if permstr in args:
                                        line = fragments[0] + "=" + permstr
                                        permFound = True

                                # No Permutations found so it must be incomplete
                                if not permFound:
                                    print "<<< ERROR >>>"
                                    print "Cannot match given assignment " + fragments[1] + " to any possible value:"
                                    for arg in args:
                                        print "\t" + arg
                                    print "<<< /ERROR >>>"
                                    sys.exit(1)
                            line += '\n'
                        else:
                            # The define was present but was only assigned 'don't care values' so for our purpose it wasn't defined
                            defines_found.remove(define)
                            line = None

                    # Adding newline delimiters back for config match later - determines "//" existance
                    if line:
                        optparams.append("\n"+line)

    # Update list with variables that were left undefined
    for define, req, args, dcas in variables:
        if define not in defines_found:
            optparams.append("\n//-D" + define)

    return optparams


def matchLib(libdir, optparameters, config):
    '''
    Given libdir as the location of all possible libraries to match against,
    this function scans for an opt file in that directory which matches the
    stack projects opt file defines given in optparameters.
    '''
    libpath = ""

    for root, subFolders, filenames in os.walk(libdir):
        for filename in filenames:
            if filename.endswith(".opt"):
                filestr = ""
                data = open(os.path.join(libdir, filename))
                line = data.readline()
                while line:
                    line = line.strip() + "\n"
                    filestr += line
                    line = data.readline()

                alt_opt_parameters = copy.deepcopy(optparameters)

                if 'hci_tl' in str(libdir):
                    dle_opt = False

                    for optparam in alt_opt_parameters:
                        if 'DBLE_V42_FEATURES=EXT_DATA_LEN_CFG' in optparam \
                            and '//' not in optparam:
                            dle_opt = True

                    for optparam in alt_opt_parameters:
                        if dle_opt and 'DBLE_V41_FEATURES' in optparam:
                            alt_opt_parameters.remove(optparam)

                match = True
                for optparam in alt_opt_parameters:
                    if optparam.startswith("\n//"):
                        defoptparam = optparam.replace("//", "")
                        if optparam not in filestr and defoptparam in filestr:
                            match = False

                    elif optparam not in filestr:
                        match = False

                # Get the library name and path given the opt file that was
                # correctly matched
                if match:
                    libname = filename.replace(".opt", ".a")
                    if config != "":
                        libname = libname.replace(".a", "_" + config + ".a")
                    libpath = os.path.join(libdir, libname)

    return libpath


def generateCmd(cmd_file, libs):
    '''
    Construct linker command file contents
    '''
    new_cmd = CMD_HEADER
    for lib in libs:
        new_cmd += '\"' + lib + '\"\n'

    # Read current cmd file if it exists
    if os.path.exists(cmd_file):
        f = open(cmd_file)
        old_cmd = f.read()
        f.close()

        if old_cmd == new_cmd:
            return False

    f = open(cmd_file, 'w')
    f.write(new_cmd)
    f.close()
    return True


def lib_search(opt, xml, libdir, config, verbose=True):
    '''
    Top level function. Using xml definition file, scan for all
    necessary libraries for the stack project which called this
    script as a prebuild action
    '''
    # Create empty list of final libraries needed for linking
    final_libs = []

    # Parse XML strictly for libraries to search for, returns their names
    lib_names = libsToSearch(xml)

    for lib_name in lib_names:
        # Parse template file to determine config parameters to match against
        (relPath, addConfig, params) = parseXML(lib_name, xml)
        path = os.path.join(libdir, relPath)
        config = ""
        if addConfig and addConfig != "0":
            config += config

        # Parse given opt file to determine state of parameters given in XML
        optparams = parseOPT(opt, params)

        # Search through all possible libraries to find lib that matches parameters in opt
        matched_lib = matchLib(path, optparams, config)

        # Add matched_lib to final libs list
        if verbose:
            if matched_lib and os.path.exists(matched_lib):
                print "<<< Using Library: " + os.path.basename(matched_lib) + " >>>"
                final_libs.append(matched_lib)
            elif matched_lib and not os.path.exists(matched_lib):
                print "<<< ERROR >>>"
                print "\tMatched the project .opt file to a library .opt file."
                print "\tHowever, unable to find corresponding library file \n\t" + matched_lib
                print "<<< /ERROR >>>"
                return None
            else:
                print "<<< ERROR >>>"
                print "Cannot match " + opt + " to any library .opt file in " + path
                print "\tSearched against the following defines in " + opt + ": "
                for optparam in optparams:
                    print "\t\t\"" + optparam.strip() + "\""
                print "<<< /ERROR >>>"
                return None
        elif matched_lib:
            final_libs.append(matched_lib)

    return final_libs


def main():
    parser = argparse.ArgumentParser(prog='LibSearch', description='Used in conjunction with BLE Stack Releases as a prebuild step. Parses provided .opt file and creates linker file with necessary libs to be linked into project.')
    parser.add_argument('-v', '--version', action='version', version='%(prog)s ' + __version__)
    parser.add_argument("opt", help="Project local configuration file for Stack Project")
    parser.add_argument("xml", help="Generic template file that describes defines to match against in opt")
    parser.add_argument("libdir", help="Directory containing library files")
    parser.add_argument("cmd", help="Linker command file that will be written to")
    parser.add_argument("config", nargs='?', default="", help='File name suffix to search on (e.x FlashOnly, FlashROM). Defaults to no suffix')
    args = parser.parse_args()

    # Check input file existence and expand to absolute path
    args.opt = inputArgExpansion(args.opt)
    args.xml = inputArgExpansion(args.xml)
    args.libdir = inputArgExpansion(args.libdir)

    if not os.path.isabs(args.cmd):
        args.cmd = os.path.join(os.getcwd(), args.cmd)

    # Search for all necessary libraries
    final_libs = list(lib_search(args.opt, args.xml, args.libdir, args.config))

    # If valid libraries were found generate linker cmd file
    if final_libs:
        if generateCmd(args.cmd, final_libs):
            print "<<< Modifying " + os.path.basename(args.cmd) + ". Stack configurations have changed. >>>"
        else:
            print "<<< Not Modifying " + os.path.basename(args.cmd) + ". Stack configurations have not changed. >>>"

    return


if __name__ == '__main__':
    main()