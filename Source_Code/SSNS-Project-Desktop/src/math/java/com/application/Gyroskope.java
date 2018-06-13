package com.application;

import java.util.ArrayList;

import org.apache.commons.math3.analysis.function.Abs;

public class Gyroskope extends Thread{

	private ArrayList<Double> buf_x;
	private ArrayList<Double> buf_y;
	private ArrayList<Double> buf_z;
	private Mathems math;
	private int count_sec;
	private double FALL_ANGLE;

	public Gyroskope(Mathems math, int count_sec, double FALL_ANGLE)  {
		buf_x = new ArrayList<Double>();
		buf_y = new ArrayList<Double>();
		buf_z = new ArrayList<Double>();
		this.math = math;
		this.count_sec = count_sec;
		this.FALL_ANGLE = FALL_ANGLE;
	}

	public void run(int fallStart,
					int fallStop,
					ArrayList<Double> tmp_buf_x,
					ArrayList<Double> tmp_buf_y,
					ArrayList<Double> tmp_buf_z) {


		double angle = isGyroFall(fallStart, fallStop, tmp_buf_x, tmp_buf_y, tmp_buf_z);

		if(angle <= this.FALL_ANGLE || angle >= this.FALL_ANGLE)
			math.isGyroFall = true;
	}

	private double isGyroFall(int fallStart,
							  int fallStop,
							  ArrayList<Double> tmp_buf_x,
							  ArrayList<Double> tmp_buf_y,
							  ArrayList<Double> tmp_buf_z) {
		double xAngle = 0;
		double yAngle = 0;

		for(int i = fallStart; i < fallStart; i++ ) {
			xAngle += Math.abs(tmp_buf_x.get(i) * (1000 / count_sec));
			yAngle += Math.abs(tmp_buf_y.get(i) * (1000 / count_sec));
		}

		return (xAngle + yAngle) % 180 - 90;
	}

	public void add_gyro(double x, double y, double z) {
		this.buf_x.remove(0);
		this.buf_y.remove(0);
		this.buf_z.remove(0);

		//x = ((x * 1.0) / (65536 / 500)); // convert to g-scale
		//y = ((y * 1.0) / (65536 / 500));
		//z = ((z * 1.0) / (65536 / 500));

		this.buf_x.add(x);
		this.buf_y.add(y);
		this.buf_z.add(z);

	}

}
