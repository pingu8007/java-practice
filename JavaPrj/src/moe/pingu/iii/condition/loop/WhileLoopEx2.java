package moe.pingu.iii.condition.loop;

public class WhileLoopEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int sum = 0;

		while (++i <= 10) {
			sum = sum + i;
			System.out.println("when i is " + i + ", sum is " + sum);
		}
		System.out.println("sum = " + sum);
	}

}
