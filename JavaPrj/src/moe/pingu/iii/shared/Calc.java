package moe.pingu.iii.shared;

public class Calc {

	@SuppressWarnings("unused")
	private static boolean debug = false;

	public static void setDebug(boolean isDebug) {
		Calc.debug = isDebug;
	}

	// public static void main(String[] args) {
	// System.out.println(Calc.fibonacci2(92)[1]);
	// for (int i = 0; i < 100; i++) {
	// System.out.println(random(1, 42));
	// }
	// Array.arrayGeneratePrint(32, 0, 100);
	// }

	public static double[] quadratic(int a, int b, int c) {
		// Ax^2+Bx+C=(ax+b)(cx+d)=0
		// (-B±(B^2-4AC)^0.5)/2A
		// int a = 2, b = 11, c = 12;
		double[] ans = new double[2];
		ans[0] = (0 - b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		ans[1] = (0 - b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		return ans;
	}

	/**
	 * Calculate the value of x in fibonacci series. Mixed recursive implement.
	 * 
	 * @param e
	 *            number from +0~+any
	 * @return number pair. The first one is the value of e-1, and the second
	 *         one is the value of e.
	 */
	public static long[] fibonacci2(int e) {
		long[] r = { 0, 0 };

		if (e <= 0) {
			r[0] = 0;
			r[1] = 0;
		} else if (e == 1) {
			r[0] = 0;
			r[1] = 1;
		} else {
			long[] tmp = fibonacci2(e - 1);
			r[0] = tmp[1];
			r[1] = tmp[0] + tmp[1];
		}
		return r;
	}

	/**
	 * Calculate the value of x in fibonacci series. Pure recursive implement.
	 * 
	 * @param e
	 *            number from +1~+any
	 * @return the value of e.
	 */
	public static long fibonacci(int e) {
		if (e == 1 || e == 2) {
			return (long) (e - 1);
		}
		return fibonacci(e - 1) + fibonacci(e - 2);
	}

	/**
	 * Return a value between minimum and maximum.
	 * 
	 * @param minimum
	 *            Minimum value
	 * @param maximum
	 *            Maximum value
	 * @return
	 */
	public static int random(int minimum, int maximum) {
		return minimum + (int) (Math.random() * (maximum - minimum + 1));
	}
}
