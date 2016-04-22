package moe.pingu.iii.condition.loop;

public class UnFairDiceTextEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int luckyNum = 6;
		while (true) {
			int chance = (int) (Math.random() * 6) + 1;
			if (luckyNum == chance) {
				System.out.println("You are lucky guy.");
				break;
			} else {
				System.out.println("Oops! try again.");
			}
		}
	}

}
