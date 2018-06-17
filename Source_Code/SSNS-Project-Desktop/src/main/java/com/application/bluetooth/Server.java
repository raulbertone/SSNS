package com.application.bluetooth;

import java.util.*;

import com.google.common.io.BaseEncoding;
import java.io.*;
import jssc.*;

public class Server {

	public static SerialPort serialPort;
	public static MsgQueue msg = new MsgQueue(250);
	
	public static Boolean resetDone = false;

	public Server()
	{  
		// writing to port
        serialPort = new SerialPort("COM7");
        try
        {
        	serialPort.openPort();
            
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                                 SerialPort.DATABITS_8,
                                 SerialPort.STOPBITS_1,
                                 SerialPort.PARITY_NONE);
            
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | 
                                          SerialPort.FLOWCONTROL_RTSCTS_OUT);
            
           serialPort.addEventListener(new PortReader(serialPort), SerialPort.MASK_RXCHAR);
           	           
           
        }
        catch (Exception x)
        {
        	
        }
		
	}

	
	
	/**
	 * @author Elis
	 * 
	 * Listener for reading events
	 * */

	
	
	//helping functions
	 public static int hex2decimal(String s) {
	        String digits = "0123456789ABCDEF";
	        s = s.toUpperCase();
	        int val = 0;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            int d = digits.indexOf(c);
	            val = 16*val + d;
	        }
	        return val;
	    }
	 
	 /**
	  * 
	  * @author Elis
	  * 
	  * method to write to port from everywhere in application
	  * */
	 public  void WriteToPort(String hexCommand)
	 {
		 try {
			 serialPort.writeBytes(BaseEncoding.base16().decode(hexCommand));
			 System.out.println("Writed: "+ hexCommand);
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 
	 }
	 public static void DeviceInitialization()
	    {
	    	try
	    	{   		
	    		serialPort.writeBytes(BaseEncoding.base16().decode(Commands.BUILD_REVISION.val()));	 
	    		
	    		
	    		System.out.println("Writing: " +Commands.BUILD_REVISION.val());
	    		    		
	    	}
	    	catch (Exception x)
	    	{
	    		
	    	}
	    	
	    	
	    }
	 public void DevInit()
	    {
	    	try
	    	{   
	    		System.out.println("Writing: " +Commands.BUILD_REVISION.val());
	    		serialPort.writeBytes(BaseEncoding.base16().decode(Commands.BUILD_REVISION.val()));	 	    			    		
	    		
	    		
	    		//ProcessMessage.getMsg(); 
	    		System.out.println("Writing: " +Commands.RESET.val());
	    		serialPort.writeBytes(BaseEncoding.base16().decode(Commands.RESET.val()));
	    		//ProcessMessage.getMsg();
	    		System.out.println("Writing: " +Commands.GAP_DEVICE_INIT.val());
	    		serialPort.writeBytes(BaseEncoding.base16().decode(Commands.GAP_DEVICE_INIT.val()));
	    		if(resetDone)
	    		{	    	
	    			
	    			
	    			
	    			System.out.println("Device Initialization Complete");
	    			
	    		}
	    		
	    	}
	    	catch (Exception x)
	    	{
	    		
	    	}
	    	
	    	
	    }
	
}
