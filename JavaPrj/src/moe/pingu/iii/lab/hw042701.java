package moe.pingu.iii.lab;

import java.math.BigInteger;
import moe.pingu.iii.shared.Calc;

public class hw042701 {

	public static void main(String[] args) {
		v2();
		// v1();
	}

	/**
	 * Long version of fibonacci series. Available from 0 to about 93.
	 */
	public static void v1() {
		long[] ans = { 0, 0 };
		int i = 0;

		while (ans[1] >= ans[0]) {
			i++;
			ans = Calc.fibonacci2(i);
			System.out.printf("fibonacci(%2d)=%20d%n", i, ans[0]);
		}
	}

	/**
	 * BigInteger version of fibonacci series. Available from 0 to about 9600.
	 */
	public static void v2() {
		BigInteger[] ans = { new BigInteger("0"), new BigInteger("0") };
		BigInteger i1 = new BigInteger("0");

		while (ans[1].compareTo(ans[0]) >= 0 && i1.intValue() < 2048) {
			i1 = i1.add(new BigInteger("1"));
			ans = Calc.fibonacci2(i1);
			System.out.println("fibonacci(" + i1 + ")=" + ans[0]);
		}
	}

}
