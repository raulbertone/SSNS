package com.application.bluetooth;

/**
 * @author Elis Haruni 
 * 
 * This class was to only read from a serial prot using multirole applicatin we are not using this anymore
 * 
 * */
import java.util.*;


import com.google.common.io.BaseEncoding;

import java.io.*;
import jssc.*;
public class portListning {
	
	private static SerialPort serialPort;
    

	public static void main(String[] args) throws InterruptedException,
	IOException,SerialPortException 
	{
		
		
		System.out.println("Serial Ports:");
		String[] portNames = SerialPortList.getPortNames();
		for(int i = 0; i < portNames.length; i++){
			System.out.println(portNames[i]);
		}
		
	     serialPort = new SerialPort("COM7");		
		serialPort.openPort();
		serialPort.setParams(115200, 8, 1, 0);
		//byte[] bytes = serialPort.readBytes();
		 serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
				
		
		
  }
	   private static class PortReader implements SerialPortEventListener {

	        @Override
	        public void serialEvent(SerialPortEvent event) {
	        	
	            if(event.isRXCHAR() && event.getEventValue() > 0 ) {
	                try {
	                   
	                    byte[] receivedData = serialPort.readBytes(event.getEventValue());
	                    System.out.println("Received msg: " +  BaseEncoding.base16().encode(receivedData) + " ||String: " + BaseEncoding.base64().encode(receivedData));
	                }
	                catch (SerialPortException ex) {
	                    System.out.println("Error in receiving response from port: " + ex);
	                }
	            }
	        }
	    }
}
