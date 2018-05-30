package com.application;

import java.util.ArrayList;
import java.lang.Math;

public class Mathems extends Thread { // start thread every 3 new measurments

	// 25 measurments per second, after each 50 ms
	// As a fall in 500 ms => 10 measurments
	private static int IMPACT_POW = 2;
	private static int IMPACT_PASS = (int) 450 / 100; // 225 - half od the fall time, 100 - difference between measurements
	private static double LAYING_POW = 0.5;
	private static int SKIP_MEASUR = 10;


	ArrayList<Double> buf_x;
	ArrayList<Double> buf_y;
	ArrayList<Double> buf_z;
	int count_sec;
	int count_pass_measur; // counter to skip 10 measurments to do not overload CPU
	boolean isFall;



	public Mathems(ArrayList<Double> buf_x, ArrayList<Double> buf_y, ArrayList<Double> buf_z, int count_sec) {
		this.buf_x = buf_x;
		this.buf_y = buf_y;
		this.buf_z = buf_z;
		this.count_sec = count_sec; // measurments per second
		this.isFall = false;
		this.count_pass_measur = 0;
	}

	public void isFall(double x, double y, double z) { // int16_t is short

		// function to add new values with changes
		this.add(x, y, z);

		if(this.count_pass_measur == SKIP_MEASUR) // increasing of count_pass_measur in .add method
			return;

		this.count_pass_measur = 0;

		if(buf_x.size() < count_sec) //if amount of measurments is less than it is need tocover one second
			return;

		try {
			this.run();
		}catch(Exception e) {
			System.out.println("Something goes wrong! Thread hasn't started!!!");
		}


	}

	public void run()  {

		for(int i = 0; i < buf_x.size(); i++) { //first loop goes through all numbers in array

			double impact = Math.sqrt( sqr(this.buf_x.get(i))
									 + sqr(this.buf_y.get(i))
									 + sqr(this.buf_z.get(i))); // got an impact from fall need to be sure

			if(impact > IMPACT_POW) {
				boolean fall = false;
				for(int j = i + IMPACT_PASS; j < buf_x.size(); j++) { // to be sure that there is a fall we pass half of fall time

					double laying = Math.sqrt( sqr(buf_x.get(j)) + sqr(buf_y.get(j)));

					if(laying > LAYING_POW) {
						fall = true;
					}
				}

				this.isFall = fall;
			}
		}

		this.stop();
	}



	private double sqr(double i) {
		return i*i;
	}



	private void add(double x, double y, double z) {

		this.buf_x.remove(0);
		this.buf_y.remove(0);
		this.buf_z.remove(0);

		//x = ((x * 1.0) / (32768/4)); // convert to g-scale
		//y = ((y * 1.0) / (32768/4));
		//z = ((z * 1.0) / (32768/4));

		this.buf_x.add(x);
		this.buf_y.add(y);
		this.buf_z.add(z);

		this.count_pass_measur++;

	}

}
