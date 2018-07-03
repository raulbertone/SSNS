package com.application.bluetooth;

import java.util.*;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import com.application.mainController;
import com.google.common.io.BaseEncoding;
import java.io.*;
import jssc.*;

public class Server {

	/**
	 * @author Elis
	 * 
	 *         this sector contains all the static flags for the bluetooth
	 *         (lunchpad)
	 */

	public static Boolean LUNCHPAD_READY = false;
	public static Boolean SCAN_COMPLETE = false;
	public static Boolean AUTODISCOVERY = false;
	public static String STATUS = "Starting...";

	public static Server server;
	public static SerialPort serialPort;
	public static MsgQueue msg = new MsgQueue(5000);
	public static List<String> sensor1 = new ArrayList();
	private static List<String> sensor2 = new ArrayList();

	public static List<String> acc1 = new ArrayList();
	public static List<String> acc2 = new ArrayList();

	public static List<String> devicesFound = new ArrayList();
	private List<Sensor> connectedSlaves = new ArrayList();

	private Server() {
		// writing to port
		serialPort = new SerialPort("COM7");
		try {
			serialPort.openPort();

			serialPort.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);

			serialPort.addEventListener(new PortReader(serialPort), SerialPort.MASK_RXCHAR);

		} catch (Exception x) {
			System.out.println("can not open the port");
		}

	}

	public void addTolist(String dev) {
		devicesFound.add(dev);
	}

	/**
	 * @author Elis
	 * 
	 *         method to add a value to sensor1 Queue
	 * 
	 */

	public void addToSensor1(String data) {
		this.sensor1.add(data);
	}

	/**
	 * @author Elis
	 * 
	 *         This method add a new connection to the Server form here we can
	 *         control slaves
	 * 
	 * @param Sensor sensor
	 *            
	 */
	public void addConnection(Sensor sensor) {
		this.connectedSlaves.add(sensor);
	     sensor.discoverCharacheristics();
	}

	/**
	 * @author Elis
	 * 
	 *         method to add a value to sensor2 Queue
	 * 
	 */

	public void addToSensor2(String data) {
		this.sensor2.add(data);
	}

	/**
	 * @author Elis
	 * 
	 *         method to remove a value from sensor1 Queue
	 * 
	 */

	public String getSensor1Data() {
		// TODO: See what wil you return if ther is no data in the queue
		if(sensor1.size()!=0 && sensor1.get(0)!=null)
		{	
				return sensor1.remove(0);
				
		}
		else
		{
			return "-1";
		}
	
	}

	/**
	 * @author Elis
	 * 
	 *         method to remove a value from sensor1 Queue
	 * 
	 */

	public String getSensor2Data() {
		if(sensor2.size()!=0 && sensor2.get(0)!=null)
		{	
				return sensor2.remove(0);
				
		}
		else
		{
			return "-1";
		}
	
	
	}

	/**
	 * @author Elis
	 * 
	 *         get Singleton Instance
	 */
	public static Server getInstance() {
		if (server == null) {
			synchronized (Server.class) {
				if (server == null) {
					server = new Server();
				}
			}
		}
		return server;
	}

	/**
	 * 
	 * @author Elis
	 * 
	 *         method to write to port from everywhere in application
	 */
	public void WriteToPort(String hexCommand) {
		try {
			serialPort.writeBytes(BaseEncoding.base16().decode(hexCommand));
			System.out.println("Writed: " + hexCommand);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @author Elis
	 * 
	 *         Method to reset and prepare lunchpad
	 */
	public void DevInit(mainController controller) {
		try {
			System.out.println("Writing: " + Commands.BUILD_REVISION.val());
			serialPort.writeBytes(BaseEncoding.base16().decode(Commands.BUILD_REVISION.val()));

			// ProcessMessage.getMsg();
			System.out.println("Writing: " + Commands.RESET.val());
			serialPort.writeBytes(BaseEncoding.base16().decode(Commands.RESET.val()));
			// ProcessMessage.getMsg();
			System.out.println("Writing: " + Commands.GAP_DEVICE_INIT.val());
			serialPort.writeBytes(BaseEncoding.base16().decode(Commands.GAP_DEVICE_INIT.val()));

			new ProcessMessage(true, controller);

		} catch (Exception x) {

		}

	}

	/**
	 * @author Elis
	 * 
	 * @param slaveAdd
	 *            - mac adress of sensor tag
	 */
	public void connectTo(String slaveAdd, mainController controller) {
		String connStr = "0109FE09000000";
		WriteToPort(connStr + slaveAdd);
		Server.STATUS = "Connectiong to: " + slaveAdd;
		new ProcessMessage(true, controller);

	}

	public void Scan(mainController controller) {

		WriteToPort(Commands.SCAN.val());
		new ProcessMessage(true, controller);

	}

	/**
	 * @author Elis
	 * 
	 *         Method to complete the connected slaves with desired characheristics
	 */
	public void AutoDiscover() {
		for (Sensor s : connectedSlaves) {
			s.discoverCharacheristics();
		}

		
	}
	/**
	 * @author Elis
	 * 
	 *   Method to start reading ata from senosr
	 */
	public void readData() {
		for (Sensor s : connectedSlaves) {
			s.readMovementService();
		}

		
	}

}
