package com.application.math;

import java.util.ArrayList;

import com.application.util.ConfigurationStorage;

public class Accelerometer {

	private ArrayList<Double> buf_x;
	private ArrayList<Double> buf_y;
	private ArrayList<Double> buf_z;
	private Mathems math;
	private double IMPACT_POW;
	private int IMPACT_PASS;
	private double LAYING_POW;
	private double FORCE_IMPACT_D;
	private double FORCE_IMPACT_U;

	public Accelerometer(Mathems math)  {
		buf_x = new ArrayList<Double>();
		buf_y = new ArrayList<Double>();
		buf_z = new ArrayList<Double>();
		this.math = math;
		this.IMPACT_PASS = 0;
		this.IMPACT_POW = 0;
		this.LAYING_POW = 0;
		this.FORCE_IMPACT_D = 0;
		this.FORCE_IMPACT_U = 0;
	}

	public void isAclrFall(Gyroskope gyro)  {

		Accelerometer tmp_aclr = this;
		Gyroskope tmp_gyro = gyro;

		this.IMPACT_PASS = ConfigurationStorage.getIMPACT_PASS();
		this.IMPACT_POW = ConfigurationStorage.getIMPACT_POW();
		this.LAYING_POW = ConfigurationStorage.getLAYING_POW();

		for(int i = 0; i < tmp_aclr.buf_x.size(); i++) { //first loop goes through all numbers in array

			double impact = Math.sqrt( sqr(tmp_aclr.buf_x.get(i))
									 + sqr(tmp_aclr.buf_y.get(i))
									 + sqr(tmp_aclr.buf_z.get(i))); // got an impact from fall need to be sure

			if(impact > IMPACT_POW) {
				isLaying(i, tmp_aclr);
				tmp_gyro.isGyroFall(getFallStart(i, tmp_aclr), i);// double check for fall from Gyro
			}
		}
	}

	public int getFallStart(int impact, Accelerometer tmp_aclr) {

		this.FORCE_IMPACT_D = ConfigurationStorage.getFORCE_IMPACT_D();
		this.FORCE_IMPACT_U = ConfigurationStorage.getFORCE_IMPACT_U();

		for(int i = impact; i >= 0; i--) {
			double force_impact = Math.abs(tmp_aclr.buf_z.get(i));
			if(force_impact < FORCE_IMPACT_U && force_impact > FORCE_IMPACT_D) {
				return i;
			}
		}
		return -1;
	}

	public void add_aclr(double x, double y, double z) {
		if(!this.buf_x.isEmpty()) {
			this.buf_x.remove(0);
			this.buf_y.remove(0);
			this.buf_z.remove(0);
		}

		this.buf_x.add(x);
		this.buf_y.add(y);
		this.buf_z.add(z);
	}

	public int bufSize() {
		return this.buf_x.size();
	}

	private void isLaying(int i, Accelerometer tmp_aclr) {

		boolean fall = false;
		for(int j = i + IMPACT_PASS; j < tmp_aclr.buf_x.size(); j++) { // to be sure that there is a fall we pass half of fall time

			double laying = Math.sqrt( sqr(tmp_aclr.buf_x.get(j)) + sqr(tmp_aclr.buf_y.get(j)));

			if(laying > LAYING_POW) {
				math.isAclrFall = true;
			}
		}
	}

	private double sqr(double i) {
		return i*i;
	}
}
