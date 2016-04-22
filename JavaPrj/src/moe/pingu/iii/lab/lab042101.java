package moe.pingu.iii.lab;

public class lab042101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iMax = 128, jMax = 9, aMax;
		aMax = iMax * jMax;

		int i = 1;
		while (i <= iMax) {
			int j = 1;
			while (j <= jMax) {

				// Padding
				for (int hold = i; hold < Math.pow(10, (int)(Math.log10(iMax))); hold = hold * 10) {
					System.out.print(" ");
				}
				System.out.print(i + "x");

				// Padding
				for (int hold = j; hold < Math.pow(10, (int)(Math.log10(jMax))); hold = hold * 10) {
					System.out.print(" ");
				}
				System.out.print(j + "=");

				int ans = i * j;

				// Padding
				for (int hold = ans; hold < Math.pow(10, (int)(Math.log10(aMax))); hold = hold * 10) {
					System.out.print(" ");
				}
				System.out.print(ans + "\t");

				j++;
			}
			System.out.print("\n");
			i++;
		}
	}

}
