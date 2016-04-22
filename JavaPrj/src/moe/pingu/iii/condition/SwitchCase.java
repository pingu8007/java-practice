package moe.pingu.iii.condition;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = 7;
		int year = 2016;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(year + "/" + month + " has 31 days.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(year + "/" + month + " has 30 days.");
			break;
		case 2:
			if (year % 4 != 0) {
				System.out.println(year + "/" + month + " has 28 days.");
			} else if (year % 100 != 0) {
				System.out.println(year + "/" + month + " has 29 days.");
			} else if (year % 400 != 0) {
				System.out.println(year + "/" + month + " has 28 days.");
			} else {
				System.out.println(year + "/" + month + " has 29 days.");
			}
			break;
		default:
			System.out.println("Invalid month.");
		}

	}

}
