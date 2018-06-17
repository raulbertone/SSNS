package com.application.bluetooth;

import com.google.common.io.BaseEncoding;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public  class PortReader  implements SerialPortEventListener  {

	SerialPort serialPort;
	public PortReader(SerialPort sr)
	{
		this.serialPort=sr;
	}
	
	
    @Override
    public void serialEvent(SerialPortEvent event) {
    	
        if(event.isRXCHAR() && event.getEventValue() > 0 ) {
            try {
               
                byte[] receivedData = serialPort.readBytes(event.getEventValue());	                    
                //System.out.println(BaseEncoding.base16().encode(receivedData));
                Server.msg.add(receivedData);
               
                
            }
            catch (SerialPortException ex) {
                System.out.println("Error in receiving response from port: " + ex);
            } 
            catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
  
}
