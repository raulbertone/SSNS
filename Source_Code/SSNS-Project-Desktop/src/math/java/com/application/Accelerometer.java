package com.application;

import java.util.ArrayList;

public class Accelerometer extends Thread {

	private ArrayList<Double> buf_x;
	private ArrayList<Double> buf_y;
	private ArrayList<Double> buf_z;
	private Mathems math;
	private int IMPACT_POW;
	private int IMPACT_PASS;
	private double LAYING_POW;

	public Accelerometer(Mathems math, int IMPACT_POW, int IMPACT_PASS, double LAYING_POW)  {
		buf_x = new ArrayList<Double>();
		buf_y = new ArrayList<Double>();
		buf_z = new ArrayList<Double>();
		this.math = math;
		this.IMPACT_PASS = IMPACT_PASS;
		this.IMPACT_POW = IMPACT_POW;
		this.LAYING_POW = LAYING_POW;
	}

	@SuppressWarnings("deprecation")
	public void run()  {

		ArrayList<Double> tmp_buf_x = this.buf_x;
		ArrayList<Double> tmp_buf_y = this.buf_y;
		ArrayList<Double> tmp_buf_z = this.buf_z;

		for(int i = 0; i < tmp_buf_x.size(); i++) { //first loop goes through all numbers in array

			double impact = Math.sqrt( sqr(tmp_buf_x.get(i))
									 + sqr(tmp_buf_y.get(i))
									 + sqr(tmp_buf_z.get(i))); // got an impact from fall need to be sure

			if(impact > IMPACT_POW) {
				math.getGyro().run(); // double check for fall from Gyro

				isLaying(i, tmp_buf_x, tmp_buf_y, tmp_buf_z);
			}
		}
		this.stop();
	}

	public void add_aclr(double x, double y, double z) {
		this.buf_x.remove(0);
		this.buf_y.remove(0);
		this.buf_z.remove(0);

		//x = ((x * 1.0) / (32768/4)); // convert to g-scale
		//y = ((y * 1.0) / (32768/4));
		//z = ((z * 1.0) / (32768/4));

		this.buf_x.add(x);
		this.buf_y.add(y);
		this.buf_z.add(z);
	}

	public int bufSize() {
		return this.buf_x.size();
	}

	private void isLaying(int i, ArrayList<Double> tmp_buf_x,
								 ArrayList<Double> tmp_buf_y,
								 ArrayList<Double> tmp_buf_z) {

		boolean fall = false;
		for(int j = i + IMPACT_PASS; j < tmp_buf_x.size(); j++) { // to be sure that there is a fall we pass half of fall time

			double laying = Math.sqrt( sqr(tmp_buf_x.get(j)) + sqr(tmp_buf_y.get(j)));

			if(laying > LAYING_POW) {
				fall = true;
			}
		}
		math.isAclrFall = fall;
	}

	private double sqr(double i) {
		return i*i;
	}
}
