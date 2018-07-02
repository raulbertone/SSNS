package com.application.math;

import java.rmi.server.ServerCloneException;
import java.text.DecimalFormat;

import com.application.bluetooth.Server;
import com.application.util.ConfigurationStorage;
import com.application.util.FallNotificationService;

public class Mathems extends Thread {


	private int count_pass_measur; // counter to skip 10 measurments to do not overload CPU

	boolean isAclrFall;
	boolean isGyroFall;

	private Gyroskope gyro_1;
	private Accelerometer aclr_1;

	private Gyroskope gyro_2;
	private Accelerometer aclr_2;

	private Server server;

	public static Mathems mathems;

	private Mathems(Server server) {
		this.isAclrFall = false;
		this.isGyroFall = false;

		this.count_pass_measur = 0;

		this.server = server;

		gyro_1 = new Gyroskope(this);
		aclr_1 = new Accelerometer(this);

		gyro_2 = new Gyroskope(this);
		aclr_2 = new Accelerometer(this);

		try {
			this.setName("Math_Thread");
			this.start();
		}catch(Exception e) {
			System.out.println("Something goes wrong! Thread hasn't started!!!");
		}

	}

	public static void getInstance(Server server){
		if(mathems==null)
		{
			synchronized(Mathems.class)
			{
				if(mathems == null)
				{
					mathems = new Mathems(server);
				}
			}
		}
	}

	public static void main() {
		//Server server = Server.getInstance();
	//	Mathems math = new Mathems(server);

		//math.add_measurments("F06800A2003FFEC000AD008E");

		//System.out.println("Hi!! I'm here using WhatsApp!!");

	}

	public void isFall() {
		// function to add new values with changes
		try {
			this.setName("Math_Thread");
			this.start();
		}catch(Exception e) {
			System.out.println("Something goes wrong! Thread hasn't started!!!");
		}
	}

	public void run() {
		while(true) {
			if(this.count_pass_measur <= ConfigurationStorage.getSKIP_MEASURE()) { // increasing of count_pass_measur in .add method
				//System.out.print("fkygwyc");
				try {
					add_measurments(); // was added to check ""
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				this.count_pass_measur = 0;

				if(aclr_1.bufSize() < ConfigurationStorage.getCOUNT_SEC()) //if amount of measurments is less than it is need tocover one second
					return;

				
				this.aclr_1.isAclrFall(this.gyro_1);
				this.aclr_2.isAclrFall(this.gyro_2);

				if(this.isAclrFall && this.isGyroFall) {
					FallNotificationService.notifyFall();
				}
			}
		}

	}


	public void add_measurments() { //was added to check String str

		//for the first sensor
		String measure_str = server.getSensor1Data();
		
		double Ax;
		double Ay; 
		double Az;
		
		double Gx;
		double Gy;
		double Gz;
		
		if(!measure_str.isEmpty()) {

		//aclr 
			this.count_pass_measur++;
			
			 Ax = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(0, 4), 16)); // Az  1234 5678 9112 3456 7892 1234
			 Ay = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(4, 8), 16)); // Ay  2108 00AE 011E 0089 00C6 FEB8
			 Az = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(8, 12), 16)); // Ax
	
			//gyro
			 Gx = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(12, 16), 16)); // Az
			 Gy = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(16, 20), 16)); // Ay
			 Gz = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(20, 24), 16)); // Ax
	
			System.out.println("Accelerometer: "+convertG(Ax) + " " + convertG(Ay) + " " + convertG(Az));
			System.out.println("Gyroscope: "+convertAngSp(Gx) + " " + convertAngSp(Gy) + " " + convertAngSp(Gz));
	
			this.aclr_1.add_aclr(convertG(Ax), convertG(Ay), convertG(Az));
			this.gyro_1.add_gyro(convertAngSp(Gx), convertAngSp(Gy), convertAngSp(Gz));
		}

		//there we can send data to the Graph!!!!!

		//for the second sensor
		measure_str ="";
		measure_str = server.getSensor2Data();
		
		if(!measure_str.isEmpty()) {
	
			//aclr
			Ax = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(0, 4), 16)); // Az
			Ay = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(4, 8), 16)); // Ay
			Az = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(8, 12), 16)); // Ax
	
			//gyro
			Gx = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(12, 16), 16)); // Az
			Gy = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(16, 20), 16)); // Ay
			Gz = correctMeasurments(
					Integer.parseInt(
							measure_str.substring(20, 24), 16)); // Ax
	
			this.aclr_2.add_aclr(convertG(Ax), convertG(Ay), convertG(Az));
			this.gyro_2.add_gyro(convertAngSp(Gx), convertAngSp(Gy), convertAngSp(Gz));
		}

		//there we can send data to the Graph!!!!!
	}

	private double correctMeasurments(double tmp) {
		if(tmp > 32768) {
			tmp -= 65536;
		}
		return tmp;
	}

	private double convertG(double number) {
		return (double) Math.round(((number * 100.0) / (32768/ConfigurationStorage.getG_SCALE()))) / 100;
	}

	private double convertAngSp(double number) {
		return (double) Math.round(((number * 100.0) / (65536 / 500))) / 100;
	}

	public Gyroskope getGyro() {
		return gyro_1;
	}

	public Gyroskope getGyro_2() {
		return gyro_2;
	}

}
