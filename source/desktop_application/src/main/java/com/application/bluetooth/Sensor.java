package com.application.bluetooth;

import java.util.HashMap;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.io.BaseEncoding;

public class Sensor {

	Server server= Server.getInstance();
   private String addres ; 
   private String connHandle;
   private String WriteCharOpCode ="0192FD06";
   HashMap<String,String> services = new HashMap<String,String>();
   
   public Sensor(String add, String conn)
   {
	   
	   this.connHandle=conn;
	   this.addres=add;
   }     
 
   public void activateButtonService()
   {
	   String cmd = WriteCharOpCode+reverseHexString(connHandle) +"2D000100"; //0192FD06 0000 2D000100
	   //System.out.println(cmd);
	   server.WriteToPort(cmd);
   }
   public void readMovementService()
   {
	   String enableNotif = WriteCharOpCode+ reverseHexString(connHandle)+"3D000100";
	   String configM =WriteCharOpCode+reverseHexString(connHandle)+"3F003F02";
	  
	   new Thread(new Runnable(){
		     
		   @Override
		   public void run()
		   {
			   //new ProcessMessage(true);
			   try {
				   server.WriteToPort(WriteCharOpCode+reverseHexString(connHandle)+"25000100"); 
				Thread.sleep(500);
				 server.WriteToPort(WriteCharOpCode+reverseHexString(connHandle)+"27003802"); 
				 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		   }
	   }).start();
	   //server.WriteToPort(enableNotif);
	   
	   //server.WriteToPort(configM);
   }
   public void discoverCharacheristics()
   {
     new Thread(  new Runnable() {
    	 
		   String dscServices = "0190FD02"+reverseHexString(connHandle);
		   String dscAllChars = "01B2FD06"+ reverseHexString(connHandle) +"01000001";
		   String dscCharDesc = "0184FD06"+ reverseHexString(connHandle) +"01000001";
		@Override
		public void run() {
			
			server.WriteToPort(dscServices);
			
			ProcessMessage pr = new ProcessMessage(true,null);
			ProcessMessage pr1 =null;
		    int counter=0;
		    Server.AUTODISCOVERY=false;
		    Server.STATUS="Autodiscoverig Characheristics...";
		    try {
		    	while(!Server.AUTODISCOVERY)
				{
					if(pr.isAlive())
					{						
							Thread.sleep(100);						
					}
					else
					{
						if(pr1==null)
						{
							server.WriteToPort(dscCharDesc);
							 pr1 = new ProcessMessage(true,null); 
						}						
						else if(pr1.isAlive())
						{
							Thread.sleep(100);	
						}
						else
						{
							 server.WriteToPort(dscAllChars);
							 new ProcessMessage(true,null); 
							 break; 
						}
					}
				
				}
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}}	  
  ).start();
	  	
   }
    
   public void discServriceByUUID(){
	   
	   String command = "command for this";
   }
  
   private  String reverseHexString(String data)
   {
   	byte[] dataB = BaseEncoding.base16().decode(data);
   	ArrayUtils.reverse(dataB);
   	return BaseEncoding.base16().encode(dataB);
   	
   }
}
