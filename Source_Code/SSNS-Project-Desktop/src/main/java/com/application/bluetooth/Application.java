package com.application.bluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.io.BaseEncoding;

public class Application {

	
	public List<Message> messages= new ArrayList<Message>();
	public static void main(String[] args) {
		
		Server sr = new Server();
		
		 new ProcessMessage();
		
			System.out.println("pretending server started");
			sr.DevInit();			
		
		
		System.out.println("Give me a command human");
		  Scanner in = new Scanner(System.in);
	        
	        while(in.hasNext())	        	
	        {
	        	String command = in.next();
	        	if(command.equals("1"))
		        {
		        	sr.WriteToPort(Commands.SCAN.val());
		        		        		        	
		        }
	        	else if(command.equals("2"))
	        	{
	        		sr.WriteToPort(Commands.CONN.val());
	        	}
	        	else if(command.equals("3"))
	        	{
	        		sr.WriteToPort(Commands.DISC_SERVICES.val());
	        	}
	        	else if(command.equals("4"))
	        	{
	        		sr.WriteToPort(Commands.DiscAllCharDescs.val());
	        	}
	        	else if(command.equals("5"))
	        	{
	        		sr.WriteToPort(Commands.GATT_DiscAllChars.val());
	        	}
	        	else if(command.equals("6"))
	        	{
	        		sr.WriteToPort(Commands.READ_ACC.val());
	        	}
	        	else if(command.equals("7"))
	        	{
	        		sr.WriteToPort(Commands.READ_ACC1.val());
	        	}
	        	else if(command.equals("c"))
	        	{
	        		sr.WriteToPort(Commands.STOP_SCAN.val());
	        	}
	        	else if(command.startsWith("w"))
	        	{
	        		String cm = "CH"+command.substring(1);
	        		for(Commands c: Commands.values())
	        		{
	        			if(c.name().equals(cm))
	        			{
	        				sr.WriteToPort(c.val());
	        			}
	        		}
	        	}
	        	else if(command.equals("r"))
	        	{
	        		sr.WriteToPort(Commands.CH.val());
	        		sr.WriteToPort(Commands.CH1.val());
	        		sr.WriteToPort(Commands.CH2.val());
	        		sr.WriteToPort(Commands.CH3.val());
	        		sr.WriteToPort(Commands.CH4.val());
	        		sr.WriteToPort(Commands.CH5.val());
	        		sr.WriteToPort(Commands.CH6.val());
	        		sr.WriteToPort(Commands.CH7.val());
	        		sr.WriteToPort(Commands.CH8.val());
	        		sr.WriteToPort(Commands.CH9.val());
	        		sr.WriteToPort(Commands.CH10.val());
	        		sr.WriteToPort(Commands.CH11.val());
	        	}
	        }
	        
	}
	
	
}
