package com.application.bluetooth;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.io.BaseEncoding;

public class Sensor {

	Server server= Server.getInstance();
   private String addres ; 
   private String connHandle;
   
   public Sensor(String add, String conn)
   {
	   this.connHandle=conn;
	   this.addres=add;
   }   
   

   public void discoverCharacheristics()
   {
	   String command = "0190FD02"+reverseHexString(connHandle);
	   
	server.WriteToPort(command);

   }
   
  
   private  String reverseHexString(String data)
   {
   	byte[] dataB = BaseEncoding.base16().decode(data);
   	ArrayUtils.reverse(dataB);
   	return BaseEncoding.base16().encode(dataB);
   	
   }
}
