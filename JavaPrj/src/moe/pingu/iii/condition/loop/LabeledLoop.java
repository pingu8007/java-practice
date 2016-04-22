package moe.pingu.iii.condition.loop;

public class LabeledLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test: for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (i == 2 && j == 3) {
					break test;
				}
				System.out.println("i=" + i + ", j=" + j);
			}
		}
		System.out.println("fin.");
	}
}
