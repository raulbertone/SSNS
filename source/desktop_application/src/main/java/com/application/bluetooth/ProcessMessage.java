package com.application.bluetooth;

import java.io.ByteArrayOutputStream;

import org.apache.commons.lang3.ArrayUtils;

import com.application.mainController;
import com.application.math.Mathems;
import com.application.util.FallNotificationService;
import com.google.common.io.BaseEncoding;

public class ProcessMessage  extends Thread{

	Boolean alive;
	Server server = Server.getInstance();
	private static int dataLength=0;
	private  int countAcc1=0;
	private  int countAcc2=0;
	private mainController controller ;
	private long timestamp=0;
	public ProcessMessage(Boolean value)
	{
		this.alive=value;
		this.setName("Msg_Thread");
		this.start();
	}
	public ProcessMessage(Boolean value,  mainController controller)
	{
		this.controller=controller;
		this.alive=value;
		this.setName("Msg_Thread");
		this.start();
	}
public void run() {
	
	while(alive)
	{
		if(!Server.msg.isEmpty())
		{
			getMsg();
			
			try {
				Thread.sleep(50);
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
						if(data.startsWith("0106"))
						{
							//TODO: show scan results and tell app the scan is done
						
							System.out.println("SCAN RESULTS: ");
							ShowScanResults(data);
							//System.out.println(msg.toString());
						}
						else if(data.startsWith("0506")) //0x0605 Gap_Esablishment Link response
						{
						   CreateConnection(data);
							
						}
						else if(data.startsWith("1B05")) //&&data.length()==26
						{
							if(data.length()<20)
							{
								System.out.println("False Alarm");
								FallNotificationService.notifyFalseAlarm();
								
							}
							else
							{
								addToQueue(data);
							}
							
							
						}
						else if(data.startsWith("1105") || data.startsWith("0505") || data.startsWith("0905"))
						{
							//This is the part that process the message queue for the auotdiscover
							
							System.out.println("SRV: "+msg.toString());
						  if(data.equals("09051A000000")||data.equals("09051A010000"))
						  {
							  this.alive=false;
							 System.out.println("AUTODISCOVERY DONE!!!");
							 Server.STATUS="Conected/Ready";
						     Server.AUTODISCOVERY=true;
						  }
						  else  if(data.equals("05051A000000") || data.equals("11051A000000")|| data.equals("05051A010000")|| data.equals("11051A010000"))
						  {
							  this.alive=false;
							 
						  }
							
						  
							
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
							server.LUNCHPAD_READY=true;
							Server.STATUS="Ready";
							mainController.StatusChanger();
							this.alive=false;
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

	 /**
	  * @author Elis
	  * 
	  * Method  to auto discover services after a sucesful connection of 1 sensor
	  * */
	 private void discoverServices(){
		 
		 
	 }
	 
	 
	 /**
	  * @author Elis
	  * 
	  * Method to create a new instance of Slave here on this part of system 
	  * */
	 public void CreateConnection(String data)
	 {
		if(data.substring(4, 6).equals("00"))
		{
			String slaveAdd = data.substring(8,20);
			String connHandle = data.substring(20,24);
			//here i can define other connection properties but for now this is all I need
			server.addConnection(new Sensor(Utils.reverseHexString(slaveAdd),Utils.reverseHexString(connHandle)));
			Server.STATUS="Connected";
		}
		else
		{
		System.out.println("Connection not succecful");
		}
		this.alive=false;
	 }
 public  void ShowScanResults(String data)
	 {	
	 if(data.substring(4, 6).equals("00"))
	 {
		 int slavesFound= Utils.hex2decimal(data.substring(6,8));
		 
		 int i=0;
		 int beginIndex=8;
		 int endIndex=24;
		 while(endIndex <= data.length()&& slavesFound > 0)
		 {
			 String s= data.substring(beginIndex,endIndex);
			if(s.startsWith("00"))	
			{
				 String devAddres=Utils.reverseHexString( s.substring(4));
				//if the device macaddres starts with 546C0E is a SensorTag and we add it to the list of disc devices
				 if(devAddres.startsWith("546C0E"))
				 {
					 server.addTolist(devAddres);
					 System.out.println(devAddres);
				 }				
			}
			beginIndex+=16;
			endIndex+=16;
		 }
		 server.SCAN_COMPLETE=true;
		 Server.STATUS="Scan Completed";	
		 this.controller.showSensorsFound();
		 this.alive=false;
		
		
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
		
		this.countAcc1++;
		//Server.acc1.add(Utils.reverseHexString(realValues));
		server.addToSensor1(Utils.reverseHexString(realValues));
		
		//
	}
	else if(data.startsWith("1B050001"))
	{
		this.countAcc2++;
		
		//Server.acc2.add(Utils.reverseHexString(realValues));
		server.addToSensor2(Utils.reverseHexString(realValues));	
		//System.out.println("S2: "+realValues);
	}
		
	}



}
