package moe.pingu.iii.lab;

public class hw042104 {

	public static void main(String[] args) {

		int level = 10, repeat_h = 1, repeat_v = 9;
		boolean top = false, button = true, left = true, right = true;

		// vertically repeat
		for (int k = 0; k < repeat_v; k++) {

			// upper half
			for (int i = 0; i < level && top == true; i++) {

				// horizontally repeat
				for (int c = 0; c < repeat_h; c++) {

					// left side
					for (int j = level - i; j > 0 && left == true; j--) {
						System.out.print(" ");
					}
					for (int j = i; j > 0 && left == true; j--) {
						System.out.print("*");
					}

					// right side
					for (int j = i; j >= 0 && right == true; j--) {
						System.out.print("*");
					}
					for (int j = level - i; j > 0 && right == true; j--) {
						System.out.print(" ");
					}
				}
				System.out.print("\n");
			}

			// lower half
			for (int i = level; i >= 0 && button == true; i--) {

				// i=0 only for last line
				if (i == 0 && k != repeat_v - 1 && top == true) {
					continue;
				}

				// horizontally repeat
				for (int c = 0; c < repeat_h; c++) {

					// left side
					for (int j = level - i; j > 0 && left == true; j--) {
						System.out.print(" ");
					}
					for (int j = i; j > 0 && left == true; j--) {
						System.out.print("*");
					}

					// right side
					for (int j = i; j >= 0 && right == true; j--) {
						System.out.print("*");
					}
					for (int j = level - i; j > 0 && right == true; j--) {
						System.out.print(" ");
					}
				}
				System.out.print("\n");
			}
		
		//level = level + 12;
		}

	}

}
