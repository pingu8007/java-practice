package moe.pingu.iii.shared;

public class Array {

	private static boolean debug = false;

	public static void setDebug(boolean isDebug) {
		Array.debug = isDebug;
	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// int[] test = arrayGenerate(20, 0, 255);
	// System.out.println("origional array = ");
	// Array.arrayPrint(test);
	// System.out.println("arrayBubbleSort: ");
	// Array.arrayPrint(Array.arrayBubbleSort(test));
	// System.out.println("arrayBidirectionalBubbleSort: ");
	// Array.arrayPrint(Array.arrayBidirectionalBubbleSort(test));
	// }

	/**
	 * Print out given 1-D array.
	 * 
	 * @param array
	 */
	public static void arrayPrint(int[] array) {
		arrayPrint(array, true);
	}

	/**
	 * Print out given 1-D array.
	 * 
	 * @param array
	 * @param newLine
	 *            Print NewLine at end.
	 */
	public static void arrayPrint(int[] array, boolean newLine) {
		System.out.print("{ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(" }");
		if (newLine)
			System.out.print(" \n");
	}

	/**
	 * Print out given 2-D array.
	 * 
	 * @param array
	 */
	public static void arrayPrint(int[][] array) {
		arrayPrint(array, true);
	}

	/**
	 * Print out given 2-D array.
	 * 
	 * @param array
	 * @param newLine
	 *            Print NewLine at end.
	 */
	public static void arrayPrint(int[][] array, boolean newLine) {
		System.out.print("{ ");
		for (int i = 0; i < array.length; i++) {
			arrayPrint(array[i], false);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(" }");
		if (newLine)
			System.out.print(" \n");
	}

	/**
	 * Generate 1-D array.
	 * 
	 * @param length
	 *            How many item to generate.
	 * @param minimum
	 *            Minimum value.
	 * @param maximum
	 *            Maximum value.
	 */
	public static int[] arrayGenerate(int length, int minimum, int maximum) {
		int[] r = new int[length];
		for (int i = 0; i < length; i++) {
			r[i] = Calc.random(minimum, maximum);
		}
		return r;
	}

	/**
	 * Generate 1-D array and print out.
	 * 
	 * @param length
	 *            How many item to generate.
	 * @param minimum
	 *            Minimum value.
	 * @param maximum
	 *            Maximum value.
	 */
	public static void arrayGeneratePrint(int length, int minimum, int maximum) {
		arrayPrint(arrayGenerate(length, minimum, maximum), false);
	}

	/**
	 * Sort the given 1-D array with Bubble Sorting method.
	 * 
	 * @param array
	 * @return
	 */
	public static int[] arrayBubbleSort(int[] array) {
		int[] r = array.clone();
		int count = 0;
		int k = 0;
		boolean changed;
		do {
			changed = false;
			for (int i = 0; i < r.length - k - 1; i++) {
				count++;
				if (r[i] < r[i + 1]) {
					int temp = r[i];
					r[i] = r[i + 1];
					r[i + 1] = temp;
					changed = true;
				}
			}
			k++;
		} while (changed);
		if (debug)
			System.out.println("BS : " + count);
		return r;
	}

	/**
	 * Sort the given 1-D array with Bidirectional Bubble Sorting method.
	 * 
	 * @param array
	 * @return
	 */
	public static int[] arrayBidirectionalBubbleSort(int[] array) {
		int[] r = array.clone();
		int count = 0;
		int k = 0;
		boolean changed;
		do {
			changed = false;
			for (int i = k; i < r.length - k - 1; i++) {
				count++;
				if (r[i] < r[i + 1]) {
					int temp = r[i];
					r[i] = r[i + 1];
					r[i + 1] = temp;
					changed = true;
				}
			}
			for (int i = r.length - k - 1; i > k; i--) {
				count++;
				if (r[i] > r[i - 1]) {
					int temp = r[i];
					r[i] = r[i - 1];
					r[i - 1] = temp;
					changed = true;
				}
			}
			k++;
		} while (changed);
		if (debug)
			System.out.println("BBS: " + count);
		return r;
	}

	/**
	 * Sort the given 2-D array with Bidirectional Bubble Sorting method,
	 * according to element[][0]. Used in HW 20160428-1.
	 * 
	 * @param array
	 * @return
	 */
	public static int[][] arrayBidirectionalBubbleSort(int[][] array) {
		return arrayBidirectionalBubbleSort(array, 0);
	}

	/**
	 * Sort the given 2-D array with Bidirectional Bubble Sorting method,
	 * according to element[][index]. Used in HW 20160428-1.
	 * 
	 * @param array
	 * @param index
	 *            Which element used for sorting.
	 * @return
	 */
	public static int[][] arrayBidirectionalBubbleSort(int[][] array, int index) {
		int[][] r = array.clone();
		int count = 0;
		int k = 0;
		boolean changed;
		do {
			changed = false;
			for (int i = k; i < r.length - k - 1; i++) {
				count++;
				if (r[i][0] < r[i + 1][0]) {
					int[] temp = r[i].clone();
					r[i] = r[i + 1];
					r[i + 1] = temp;
					changed = true;
				}
			}
			for (int i = r.length - k - 1; i > k; i--) {
				count++;
				if (r[i][0] > r[i - 1][0]) {
					int[] temp = r[i].clone();
					r[i] = r[i - 1];
					r[i - 1] = temp;
					changed = true;
				}
			}
			k++;
		} while (changed);
		if (debug)
			System.out.println("BBS: " + count);
		return r;
	}

}
