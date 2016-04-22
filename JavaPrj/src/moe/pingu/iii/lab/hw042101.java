package moe.pingu.iii.lab;

import moe.pingu.iii.shared.shape.triangle;

public class hw042101 {

	// public static void main2(String[] args) {
	// for (int i = 1; i <= 10; i++) {
	// for (int j = 1; j <= i; j++) {
	// System.out.print("*");
	// }
	// System.out.print("\n");
	// }
	// }

	public static void main(String[] args) {
		triangle obj = new triangle();
		obj.high = 10;
		obj.flip_v = false;
		// obj.setAlt(true, true, '.');
		obj.fillAll();
		// System.out.print("end");
	}

}
