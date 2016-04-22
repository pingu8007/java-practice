package moe.pingu.iii.condition;

public class NestedIfTestEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int level = 132;
		if (level > 0) {
			System.out.println("Welcome to OZ, the largest SNS world.");
			if (level >= 20) {
				System.out.println("You can challenge other player.");
				if (level >= 40) {
					System.out.println("UNKNOWN accepted ypur challenge!");
					if (level >= 100) {
						System.out.println("You Win!");
					} else {
						System.out.print("You Lose.");
					}
				} else {
					System.out.println("UNKNOWN rejected your challenge.");
				}
			} else {
				System.out.println("Sorry, your level too low.");
			}
		}
		System.out.println("Bye Bye~");
	}

}
