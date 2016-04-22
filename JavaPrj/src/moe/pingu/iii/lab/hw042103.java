package moe.pingu.iii.lab;

import moe.pingu.iii.shared.Calc;

public class hw042103 {

	public static void main(String[] args) {

		// ver 0.1
		// Ax^2+Bx+C=(ax+b)(cx+d)=0
		// x=(-B±(B^2-4AC)^0.5)/2A

		Calc obj = new Calc();
		int qA = 1, qB = 5, qC = 6;
		double[] ans = obj.quadratic(qA, qB, qC);
		System.out.println("Your question is " + qA + "(x^2) + " + qB + "x + " + qC + " = 0, \nand x is " + ans[0]
				+ " or " + ans[1]);

	}

}
