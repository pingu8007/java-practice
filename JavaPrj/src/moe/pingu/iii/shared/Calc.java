package moe.pingu.iii.shared;

public class Calc {

	public static void main(String[] args) {

	}

	public double[] quadratic(int a, int b, int c) {
		// Ax^2+Bx+C=(ax+b)(cx+d)=0
		// (-B±(B^2-4AC)^0.5)/2A
		// int a = 2, b = 11, c = 12;
		double ans[] = new double[2];
		ans[0] = (0 - b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		ans[1] = (0 - b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		return ans;

	}
}
