package com.application.bluetooth;

import java.util.*;

import com.google.common.io.BaseEncoding;
import java.io.*;
import jssc.*;

public class Server {

	public static Server server;
	public static SerialPort serialPort;
	public static MsgQueue msg = new MsgQueue(500);
	private static List<String> sensor1 = new ArrayList();
	private static List<String> sensor2 = new ArrayList();
	
	public static List<String> acc1 = new ArrayList();
	public static List<String> acc2 = new ArrayList();
	
	public static Boolean resetDone = false;

	private Server()
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
        	System.out.println("can not open the port");
        }
		
	}

	/**
	 * @author Elis
	 * 
	 * method to add a value to sensor1 Queue 
	 * 
	 * */
	
	public void addToSensor1(String data)
	{
		this.sensor1.add(data);
	}
	/**
	 * @author Elis
	 * 
	 * method to add a value to sensor2 Queue 
	 * 
	 * */
	
	public void addToSensor2(String data)
	{
		this.sensor2.add(data);
	}
	/**
	 * @author Elis
	 * 
	 * method to remove a value from sensor1 Queue 
	 * 
	 * */
	
	public String getSensor1Data()
	{
		String s= sensor1.get(0);
		sensor1.remove(0);
		return s;
	}
	/**
	 * @author Elis
	 * 
	 * method to remove a value from sensor1 Queue 
	 * 
	 * */
	
	public String getSensor2Data()
	{
		String s= sensor2.get(0);
		sensor2.remove(0);
		return s;
	}
	/**
	 * @author Elis
	 * 
	 * get Singleton Instance
	 * */
	public static Server getInstance()
	{
		if(server==null)
		{
			synchronized(Server.class)
			{
				if(server==null)
				{
					server=new Server();
				}
			}
		}
		return server;
	}
	/**
	 * @author Elis
	 * 
	 * method to convert a hex string to integer
	 * */
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
	 public void WriteToPort(String hexCommand)
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
	 public  void DeviceInitialization()
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
