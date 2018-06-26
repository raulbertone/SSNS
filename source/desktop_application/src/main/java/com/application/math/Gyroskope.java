package com.application.math;

import java.util.ArrayList;

import com.application.util.ConfigurationStorage;


public class Gyroskope{

	private ArrayList<Double> buf_x;
	private ArrayList<Double> buf_y;
	private ArrayList<Double> buf_z;
	private Mathems math;
	private int count_sec;
	private double FALL_ANGLE;

	public Gyroskope(Mathems math)  {
		buf_x = new ArrayList<Double>();
		buf_y = new ArrayList<Double>();
		buf_z = new ArrayList<Double>();
		this.math = math;
		this.count_sec = 0;
		this.FALL_ANGLE = 0;
	}

	public void isGyroFall(int fallStart, int fallStop) {

		this.count_sec = ConfigurationStorage.getCOUNT_SEC();
		this.FALL_ANGLE = ConfigurationStorage.getFALL_ANGLE();

		if(fallStart == -1) {
			System.out.println("Error!!! Incorrect FallStart value!!!");
			return;
		}


		double angle = isFall(fallStart, fallStop);

		if(angle <= this.FALL_ANGLE || angle >= this.FALL_ANGLE)
			math.isGyroFall = true;
	}

	private double isFall(int fallStart, int fallStop) {
		double xAngle = 0;
		double yAngle = 0;

		for(int i = fallStart; i < fallStart; i++ ) {
			xAngle += Math.abs(this.buf_x.get(i) * (1000 / count_sec));
			yAngle += Math.abs(this.buf_y.get(i) * (1000 / count_sec));
		}

		return (xAngle + yAngle) % 180 - 90;
	}

	public void add_gyro(double x, double y, double z) {
		if(!this.buf_x.isEmpty()) {
			this.buf_x.remove(0);
			this.buf_y.remove(0);
			this.buf_z.remove(0);
		}

		this.buf_x.add(x);
		this.buf_y.add(y);
		this.buf_z.add(z);

	}

}
