package com.application.bluetooth;


import java.util.*;
import java.io.*;
import jssc.*;
public class portListning {

	public static void main(String[] args) throws InterruptedException,
	IOException,SerialPortException 
	{
		
		
		System.out.println("Serial Ports:");
		String[] portNames = SerialPortList.getPortNames();
		for(int i = 0; i < portNames.length; i++){
			System.out.println(portNames[i]);
		}
		
		SerialPort serialPort = new SerialPort("COM7");
		
		serialPort.openPort();
		serialPort.setParams(115200, 8, 1, 0);
		
		//byte[] bytes = serialPort.readBytes();
		while(true)
		{
			String s = serialPort.readString();
			if(s!=null)
			{
				  System.out.println(s);
			}
			Thread.sleep(10);
			
		}
		
	  
	
		
		
		
	}
}
