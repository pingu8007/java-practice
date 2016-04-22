package moe.pingu.iii.operator;

public class TypeOperatorTestEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 20, j = 4, k;
		k = (i++ + ++j - j++ + ++i + j) % 2;
		System.out.println("i=" + i + ", j=" + j + ", k=" + k);

	}

}
