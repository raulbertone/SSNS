package com.application.bluetooth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DbSave extends Thread {

	private int count;
	private int count1;
	private static String file1="C:\\Users\\Elis\\Desktop\\HIS\\SOSE2018\\SSNS\\Project\\Source_Code\\SSNS\\Source_Code\\SSNS-Project-Desktop\\Output\\ACC1.txt";
	private static String file2="C:\\Users\\Elis\\Desktop\\HIS\\SOSE2018\\SSNS\\Project\\Source_Code\\SSNS\\Source_Code\\SSNS-Project-Desktop\\Output\\ACC2.txt";
	public DbSave()
	{
		this.count=0;
		this.count1=0;
		this.start();
	}
	public void run()
	{
		//TODO: here include code to store data in database every second
		while(true)
		{
			if(count<Server.acc1.size())
			{
				List<String> data= new ArrayList();
				for (int i=count; i<Server.acc1.size();i++)
				{				
					data.add(Server.acc1.get(count));
					count++;
				}
				saveToFile(data,file1);
			}
			
			if(count1<Server.acc2.size())
			{
				List<String> data= new ArrayList();
				for (int i=count1; i<Server.acc2.size();i++)
				{
					data.add(Server.acc2.get(count1));
					count1++;
				}
				saveToFile(data,file2);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public void saveToFile(List<String> data, String filePath)
	{
		try{
			 File fileO = new File(filePath);
		      if(fileO.exists()&& !fileO.isDirectory())
		      {
		    	  BufferedWriter writer = new BufferedWriter(new FileWriter(fileO, true));
		    	  WriteData(data, writer);
		      }
		      else
		      {
		    	  fileO.createNewFile();
		    	  BufferedWriter writer = new BufferedWriter(new FileWriter(fileO, true));
		    	  WriteData(data, writer);
		    	  
		    	  
		      }
		      // creates the file
			 
		      
		      // creates a FileWriter Object
		     
		      
		    //  writer.write(sb.toString());
		      
		      // Writes the content to the fil  
		      
		    
		 }
		 catch(Exception ex)
		 {
			 System.out.println("Error: " + ex.getMessage());
		 }
	}
	public void WriteData(List<String> data, BufferedWriter writer )
	{
	
		try {
			
			writer.write(String.valueOf(System.currentTimeMillis()));			
			for(String s : data)
			{
				writer.newLine();
				writer.write(s);
			
			}			
			writer.newLine();
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
