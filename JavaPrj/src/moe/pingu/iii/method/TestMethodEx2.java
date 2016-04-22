package moe.pingu.iii.method;

class MathOperation {
	public int f(int x) {
		return 2 * x + 1;
	}
}

public class TestMethodEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathOperation mobj1 = new MathOperation();
		int ans = mobj1.f(9);
		System.out.println("the answer of f(9) is " + ans);
	}

}
