package moe.pingu.iii.condition;

public class IfElseIfTestEx1 {

	public static void main(String[] args) {

		int year = 2016;
		int month = 4;
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				System.out.println(year + "/" + month + " has 31 days.");
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				System.out.println(year + "/" + month + " has 30 days.");
			} else if (month == 2) {
				if (year % 4 != 0) {
					System.out.println(year + "/" + month + " has 28 days.");
				} else if (year % 100 != 0) {
					System.out.println(year + "/" + month + " has 29 days.");
				} else if (year % 400 != 0) {
					System.out.println(year + "/" + month + " has 28 days.");
				} else {
					System.out.println(year + "/" + month + " has 29 days.");
				}
			} else {
				System.out.println("Please input correct month.");
			}
//		for (int years = 0; years < 40; years++) {
//			year = years * 100;
//			month = 2;
//
//		}

	}

}
