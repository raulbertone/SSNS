package Math;

import java.util.ArrayList;
import java.lang.Math;

public class Mathems {

	private static int impact_pow = 2;
	private static int impact_pass = (int) 450 / 100; // 225 - half od the fall time, 100 - difference between measurements
	private static double laying_pow = 0.5;


	ArrayList<Double> buf_x;
	ArrayList<Double> buf_y;
	ArrayList<Double> buf_z;
	int count_sec;



	public Mathems(ArrayList<Double> buf_x, ArrayList<Double> buf_y, ArrayList<Double> buf_z, int count_sec) {
		this.buf_x = buf_x;
		this.buf_y = buf_y;
		this.buf_z = buf_z;
		this.count_sec = count_sec;
	}

	public boolean isFall(double x, double y, double z) { // int16_t is short

		// function to add new values with changes
		this.add(x, y, z);

		if(buf_x.size() < count_sec) //if numbers are less that in one second
			return false;

		for(int i = 0; i < buf_x.size(); i++) { //first loop goes through all numbers in array

			double impact = Math.sqrt( sqr(buf_x.get(i)) + sqr(buf_y.get(i)) + sqr(buf_z.get(i))); // got an impact from fall need to be sure

			if(impact > impact_pow) {
				boolean fall = false;
				for(int j = i + impact_pass; j < buf_x.size(); j++) { // to be sure that there is a fall we pass half of fall time

					double laying = Math.sqrt( sqr(buf_x.get(j)) + sqr(buf_y.get(j)));

					if(laying > laying_pow) {
						fall = true;
					}
				}

				return fall;
			}
		}
		return false;
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

	}

}
