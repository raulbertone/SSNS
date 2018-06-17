package com.application.bluetooth;

import java.io.ByteArrayOutputStream;

import com.google.common.io.BaseEncoding;

public class ProcessMessage  extends Thread{

	MsgQueue Q = Server.msg;
	private static int dataLength=0;
	
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
	 
	 public static void getMsg()
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
						System.out.println(msg.toString());
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

	 public static void ShowScanResults()
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
public static void ShowScanRes()
{
	byte[] msss = Server.msg.removeAll();
	System.out.println("Queue after scan: " + BaseEncoding.base16().encode(msss));
}
public static String getData (int length)
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
	 
}
