package moe.pingu.iii.lab;

import moe.pingu.iii.shared.Calc;

public class hw042701 {

	public static void main(String[] args) {
		// // TODO Auto-generated method stub

		long[] ans = { 0, 0 };
		int i = 0;
		while (ans[1] >= ans[0]) {
			ans = Calc.fibonacci2(++i);
			System.out.printf("fibonacci(%2d)=%20d%n", i, ans[0]);
		}
		//
		// for (long i = 0; i <= 100; i++) {
		// long ans = Calc.fibonacci2(i)[1];
		// System.out.printf("fibonacci(%3d)=%12d%n", i, ans);
		// }
		// System.out.println(Calc.fibonacci2(60));
	}

}
