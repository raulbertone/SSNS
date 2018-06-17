package com.application;

import java.util.ArrayList;
import java.lang.Math;

public class Mathems extends Thread {

	// 25 measurments per second, after each 50 ms
	// As a fall in 500 ms => 10 measurments
	private static int SKIP_MEASUR = 10;
	private static int IMPACT_POW = 2;
	private static int IMPACT_PASS = (int) 450 / 100; // 225 - half od the fall time, 100 - difference between measurements
	private static double LAYING_POW = 0.5;
	private double FALL_ANGLE = 35;

	private int count_sec; // measurments per second
	private int count_pass_measur; // counter to skip 10 measurments to do not overload CPU

	boolean isAclrFall;
	boolean isGyroFall;

	private Gyroskope gyro;
	private Accelerometer aclr;

	public Mathems(int count_sec) {
		this.count_sec = count_sec;
		this.isAclrFall = false;
		this.isGyroFall = false;
		this.count_pass_measur = 0;

		gyro = new Gyroskope(this, this.count_sec, FALL_ANGLE);
		aclr = new Accelerometer(this, IMPACT_POW, IMPACT_PASS, LAYING_POW);
	}

	public void isFall(double x, double y, double z) { // int16_t is short
		// function to add new values with changes
		aclr.add_aclr(x, y, z);
		gyro.add_gyro(x, y, z);

		if(this.count_pass_measur == SKIP_MEASUR) // increasing of count_pass_measur in .add method
			return;

		this.count_pass_measur = 0;

		if(aclr.bufSize() < count_sec) //if amount of measurments is less than it is need tocover one second
			return;

		try {
			run(aclr, gyro);
		}catch(Exception e) {
			System.out.println("Something goes wrong! Thread hasn't started!!!");
		}
	}

	public void run(Accelerometer aclr, Gyroskope gyro) {
		Accelerometer tmp_aclr = aclr;
		Gyroskope tmp_gyro = gyro;

		tmp_aclr.isAclrFall(tmp_gyro);

	}


	public Gyroskope getGyro() {
		return gyro;
	}

}
