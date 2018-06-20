package com.application.bluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.application.util.FallNotificationService;
import com.google.common.io.BaseEncoding;

public class Application {

	
	//public List<Message> messages= new ArrayList<Message>();
	public static void main(String[] args) {
		
		Server sr =Server.getInstance();
		
		 new ProcessMessage();
		
			System.out.println("pretending server started");
			sr.DevInit();			
		
			//FallNotificationService.notifyFall();
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
	        	else if(command.equals("21"))
	        	{
	        		sr.WriteToPort(Commands.CONN1.val());
	        	}
	        	else if(command.equals("3"))
	        	{
	        		sr.WriteToPort(Commands.DISC_SERVICES.val());
	        	}
	        	else if(command.equals("31"))
	        	{
	        		sr.WriteToPort(Commands.DISC_SERVICES1.val());
	        	}
	        	else if(command.equals("4"))
	        	{
	        		sr.WriteToPort(Commands.DiscAllCharDescs.val());
	        	}
	        	else if(command.equals("5"))
	        	{
	        		sr.WriteToPort(Commands.GATT_DiscAllChars.val());
	        	}
	        	else if(command.equals("41"))
	        	{
	        		sr.WriteToPort(Commands.DiscAllCharDescs1.val());
	        	}
	        	else if(command.equals("51"))
	        	{
	        		sr.WriteToPort(Commands.GATT_DiscAllChars1.val());
	        	}
	        	else if(command.equals("6"))
	        	{
	        		sr.WriteToPort(Commands.READ_ACC.val());
	        	}
	        	else if(command.equals("7"))
	        	{
	        		sr.WriteToPort(Commands.READ_ACC11.val());
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
	        	else if(command.startsWith("r"))
	        	{
	        		String cm = "SH"+command.substring(1);
	        		for(Commands c: Commands.values())
	        		{
	        			if(c.name().equals(cm))
	        			{
	        				sr.WriteToPort(c.val());
	        			}
	        		}
	        	}
	        	else if(command.equals("s"))
	        	{
	        		new DbSave();
	        	}
	        }
	        
	}
	
	
}
