package Math;

import java.util.ArrayList;

public class Main {

	public static void main_nope(String args[]) {

		ArrayList<Double> buf_x = new ArrayList();
		ArrayList<Double> buf_y = new ArrayList();
		ArrayList<Double> buf_z = new ArrayList();

		buf_x.add(-0.9);
		buf_x.add(-0.9);
		buf_x.add(-0.9);
		buf_x.add(-0.8);
		buf_x.add(-0.8);
		buf_x.add(-0.8);
		buf_x.add(-0.8);
		buf_x.add(-0.8);
		buf_x.add(-0.9);
		buf_x.add(-0.9);
		buf_x.add(-0.9);
		buf_x.add(-0.8);
		buf_x.add(-0.8);
		buf_x.add(-0.8);
		buf_x.add(-0.7);
		buf_x.add(-0.7);


		buf_y.add(-0.1);
		buf_y.add(-0.1);
		buf_y.add(-0.1);
		buf_y.add(-0.1);
		buf_y.add(-0.1);
		buf_y.add(-0.0);
		buf_y.add(-0.0);
		buf_y.add(-0.0);
		buf_y.add(-0.1);
		buf_y.add(-0.1);
		buf_y.add(-0.2);
		buf_y.add(-0.3);
		buf_y.add(-0.3);
		buf_y.add(-0.4);
		buf_y.add(-0.5);
		buf_y.add(-0.6);


		buf_z.add(-1.0);
		buf_z.add(-1.0);
		buf_z.add(-1.5);
		buf_z.add(-1.0);
		buf_z.add(-0.4);
		buf_z.add(-0.4);
		buf_z.add(-0.4);
		buf_z.add(-0.4);
		buf_z.add(-0.4);
		buf_z.add(-0.4);
		buf_z.add(-0.3);
		buf_z.add(-0.3);
		buf_z.add(-0.2);
		buf_z.add(-0.2);
		buf_z.add(-0.1);
		buf_z.add(-0.1);


		Mathems maths = new Mathems(buf_x, buf_y, buf_z, 16);

		System.out.println(maths.isFall(1.0, 1.0 , 1.0));

	}

}
