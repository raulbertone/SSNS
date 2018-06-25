package com.application.bluetooth;

import java.io.ByteArrayOutputStream;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.io.BaseEncoding;

public class ProcessMessage  extends Thread{

	
	Server server = Server.getInstance();
	private static int dataLength=0;
	private static int countAcc1=0;
	private static int countAcc2=0;
	public ProcessMessage()
	{
		this.start();
	}
public void run() {
	
	while(true)
	{
		if(!Server.msg.isEmpty())
		{
			getMsg();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	 
	 public  void getMsg()
		{
			try {
				
				String type= String.format("%02X", Server.msg.remove());
				
				
				//check if it  is an event 
				if(type.equals("04"))
				{
					String opCode = String.format("%02X", Server.msg.remove());
					// this is always with an event not yet what this is 
					//TODO: maybe we need to define other opcodes 
					if(opCode.equals("FF"))
					{
						dataLength= Server.msg.remove();
						String data = getData(dataLength);
						Message msg = new Message(type,opCode,String.format("%02X", dataLength) ,data);
						if(data.startsWith("01060004"))
						{
							//TODO: show scan results and tell app the scan is done
							System.out.println("SCAN RESULTS: ");
							System.out.println(msg.toString());
						}
						else if(data.startsWith("1B05"))
						{
							addToQueue(data);
						}						
						else {
							
							
							System.out.println(msg.toString());
						}
						
						
					}
					else if(opCode.equals("0E"))
					{
						dataLength=Server.msg.remove();
						String data = getData(dataLength);
						
						if(data.equals(Commands.RESET.val())) {
							System.out.println(new Message(type,opCode,String.format("%02X", dataLength) ,data).toString());
							System.out.println("Reset complete!!");
							Server.resetDone=true;
						}
					}
				}
				else if(type=="01")
				{
					
					//this means is a command not events
				}
								
			}
			catch(Exception x)
			{
				System.out.println(x.getMessage());
			}
		}

 public  void ShowScanResults()
	 {
		 try {
			String type= String.format("%02X", Server.msg.remove());
			String opCode = String.format("%02X", Server.msg.remove());
			dataLength = Server.msg.remove();
			String data = getData(dataLength);
			Message msg = new Message(type,opCode,String.format("%02X", dataLength) ,data);
			System.out.println(msg.toString());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

public  String getData (int length)
{
	ByteArrayOutputStream message = new ByteArrayOutputStream();
	while (length>0)
	{
		
		try {
			
			message.write(Server.msg.remove());
			
		}
		catch(Exception x)
		{
			System.out.println(x.getStackTrace());
		}
	length--;
	}
	
	return BaseEncoding.base16().encode(message.toByteArray());
	}
	
public  void addToQueue(String data)
{
	Mathems.getInstance(server);
	String realValues = data.substring(16, 40);
	if(data.startsWith("1B050000"))
	{		
		server.addToSensor1(reverseHexString(realValues));
		//System.out.println(reverseHexString(realValues));
		//System.out.println(realValues);
	}
	else if(data.startsWith("1B050001"))
	{
		server.addToSensor2(reverseHexString(realValues));		
	}
			
	}
/**
 * @author Elis
 * 
 * method to reverse the hexadecimal string because we get the low parity bit first
 * */
public  String reverseHexString(String data)
{
	byte[] dataB = BaseEncoding.base16().decode(data);
	ArrayUtils.reverse(dataB);
	return BaseEncoding.base16().encode(dataB);
	
}

}
