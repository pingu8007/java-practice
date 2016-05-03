package moe.pingu.iii.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 6, j = 0;
		try {
			assert j != 0 : "i devide by zero";
		} catch (AssertionError e) {
			System.out.println(e);
			e.getStackTrace();
		}

		System.out.println("i/j = " + (i / j));

	}

}
