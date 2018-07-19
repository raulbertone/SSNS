package com.application.bluetooth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elis
 * This class save the accelerometer data only in database Database is represented by txt files 
 * */
public class DbSave extends Thread {


	
	private int count;
	private int count1;
	private static String file1="C:\\Users\\Elis\\Desktop\\HIS\\SOSE2018\\SSNS\\Project\\Source_Code\\SSNS\\SSNS\\source\\desktop_application\\out\\ACC1.txt";
	private static String file2="C:\\Users\\Elis\\Desktop\\HIS\\SOSE2018\\SSNS\\Project\\Source_Code\\SSNS\\SSNS\\source\\desktop_application\\out\\ACC2.txt";
	
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
			
				
			while(count<=10 && !Server.sensor1DataForDb.isEmpty())
			{
				List<String> data= new ArrayList();
				
				data.add(Server.sensor1DataForDb.remove());
				if(count==10)
				{
					
					saveToFile(data,file1);
					count=0;
					break;
				}	
				
			}
			while(count<=10 && !Server.sensor2DataForDb.isEmpty())
			{
				List<String> data= new ArrayList();
				
				data.add(Server.sensor2DataForDb.remove());
				if(count1==10)
				{
					
					saveToFile(data,file2);
					count1=0;
					break;
				}	
				
			}			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void saveToFile(List<String> data, String filePath)
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
		  
		      
		    
		 }
		 catch(Exception ex)
		 {
			 System.out.println("Error: " + ex.getMessage());
		 }
	}
	public static void WriteData(List<String> data, BufferedWriter writer )
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
