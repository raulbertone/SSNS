package com.application.math;

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

	public Mathems(Server server) {
		this.isAclrFall = false;
		this.isGyroFall = false;

		this.count_pass_measur = 0;

		this.server = server;

		gyro_1 = new Gyroskope(this);
		aclr_1 = new Accelerometer(this);

		gyro_2 = new Gyroskope(this);
		aclr_2 = new Accelerometer(this);
	}

	public static void main() {//String[] arg) {
		Server server = null;
		Mathems math = new Mathems(server);

		math.add_measurments("210800AE011E008900C6FEB8");

		System.out.println("Hi!! I'm here using WhatsApp!!");

	}

	public void isFall() {
		// function to add new values with changes
		try {
			run();
		}catch(Exception e) {
			System.out.println("Something goes wrong! Thread hasn't started!!!");
		}
	}

	public void run() {

		if(this.count_pass_measur == ConfigurationStorage.getSKIP_MEASURE()) // increasing of count_pass_measur in .add method
			return;

		this.count_pass_measur = 0;

		if(aclr_1.bufSize() < ConfigurationStorage.getCOUNT_SEC()) //if amount of measurments is less than it is need tocover one second
			return;

		add_measurments(""); // was added to check ""

		this.aclr_1.isAclrFall(this.gyro_1);
		this.aclr_2.isAclrFall(this.gyro_2);

		if(this.isAclrFall && this.isGyroFall) {
			FallNotificationService.notifyFall();
		}

	}


	public void add_measurments(String str) { //was added to check String str

		//for the first sensor
		String measure_str = str; //server.getSensor1Data();

		//aclr

		String str_2 = measure_str.substring(14, 15);

		double Az = Integer.parseInt(measure_str.substring(3, 4), 16); // Az  1234 5678 9112 3456 7892 1234
		double Ay = Integer.parseInt(measure_str.substring(6, 8), 16); // Ay  2108 00AE 011E 0089 00C6 FEB8
		double Ax = Integer.parseInt(measure_str.substring(10, 12), 16); // Ax

		//gyro
		double Gz = Integer.parseInt(measure_str.substring(14, 16), 16); // Az
		double Gy = Integer.parseInt(measure_str.substring(18, 20), 16); // Ay
		double Gx = Integer.parseInt(measure_str.substring(22, 24), 16); // Ax

		System.out.println(convertG(Ax) + " " + convertG(Ay) + " " + convertG(Az));
		System.out.println(convertAngSp(Gx) + " " + convertAngSp(Gy) + " " + convertAngSp(Gz));

		this.aclr_1.add_aclr(convertG(Ax), convertG(Ay), convertG(Az));
		this.gyro_1.add_gyro(convertAngSp(Gx), convertAngSp(Gy), convertAngSp(Gz));

		//there we can send data to the Graph!!!!!

		//for the second sensor
		measure_str = str; //server.getSensor2Data();

		//aclr
		Az = Integer.parseInt(measure_str.substring(0, 3), 16); // Az
		Ay = Integer.parseInt(measure_str.substring(4, 7), 16); // Ay
		Ax = Integer.parseInt(measure_str.substring(8, 11), 16); // Ax

		//gyro
		Gz = Integer.parseInt(measure_str.substring(12, 15), 16); // Az
		Gy = Integer.parseInt(measure_str.substring(16, 19), 16); // Ay
		Gx = Integer.parseInt(measure_str.substring(20, 24), 16); // Ax

		this.aclr_2.add_aclr(convertG(Ax), convertG(Ay), convertG(Az));
		this.gyro_2.add_gyro(convertAngSp(Gx), convertAngSp(Gy), convertAngSp(Gz));

		System.out.println(Ax + " " + Ay + " " + Az);
		System.out.println(Gx + " " + Gy + " " + Gz);

		//there we can send data to the Graph!!!!!
	}

	private double convertG(double number) {
		return ((number * 1.0) / (32768/4));
	}

	private double convertAngSp(double number) {
		return ((number * 1.0) / (65536 / 500));
	}

	public Gyroskope getGyro() {
		return gyro_1;
	}

	public Gyroskope getGyro_2() {
		return gyro_2;
	}

}
