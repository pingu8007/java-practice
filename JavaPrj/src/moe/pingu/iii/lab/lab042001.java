package moe.pingu.iii.lab;

public class lab042001 {

	public static void main(String[] args) {
		// int userInput;
		for (int userInput = -8; userInput < 8; userInput++) {
			System.out.print("Your input " + userInput);
			if (userInput >= 0) {
				if (userInput > 0) {
					System.out.print(" is greater then 0, ");
				} else {
					System.out.print(" is equal to 0, ");
				}
			} else {
				System.out.print(" is lower then 0, ");
			}
			if ((userInput % 2) != 0) {
				System.out.println("and it's odd.");
			} else {
				System.out.println("and it's even.");
			}
		}

	}

}
