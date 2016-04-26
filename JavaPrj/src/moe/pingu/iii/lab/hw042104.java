package moe.pingu.iii.lab;

import moe.pingu.iii.shared.gen.Triangle;

public class hw042104 {

	public static void main(String[] args) {

		int high = 12;
		int repeat_h = 8, repeat_v = 20;
		// int repeat_h = 1, repeat_v = 1;

		Triangle objA = new Triangle(); // left part
		objA.high = high;
		objA.over_h = false;
		objA.setAlt(true, true, '.');

		Triangle objB = new Triangle(); // right part
		objB.high = high;
		objB.over_h = true;
		objB.setAlt(true, false, '.');

		for (int v = 1; v <= repeat_v; v++) {
			for (int l = 1; l < high; l++) {
				for (int h = 1; h <= repeat_h; h++) {
					objA.fill(l);
					objB.fill(l);
				}
				System.out.print("\n");
			}
			for (int l = high; l > 1; l--) {
				for (int h = 1; h <= repeat_h; h++) {
					objA.fill(l);
					objB.fill(l);
				}
				System.out.print("\n");
			}
		}

		// System.out.print("end");
	}

}
