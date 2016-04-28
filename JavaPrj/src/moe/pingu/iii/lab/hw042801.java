package moe.pingu.iii.lab;

import moe.pingu.iii.shared.Array;
import moe.pingu.iii.shared.Calc;

/*
 * 100000 times of any number between  1 and 42
 * stat:
 * times of each number 
 * sort by times and print out
 * ex:
 * num	times
 * ------------
 * 36	2415
 * 42	2313
 * ...	...
 */

public class hw042801 {

	public static void main2(String[] args) {
		// TODO Auto-generated method stub
		// Calc.debug = true;
		int[][] count;

		count = new int[42][2];
		for (int i = 0; i < 42; i++) {
			count[i][1] = i + 1;
		}
		for (int i = 0; i < 100000; i++) {
			count[Calc.random(1, 42) - 1][0]++;
		}

		System.out.println("num\tcount    <--original");
		System.out.println("---\t-----");
		for (int i = 0; i < 42; i++) {
			System.out.println(count[i][1] + "\t" + count[i][0]);
		}

		count = Array.arrayBidirectionalBubbleSort(count);

		// Calc.arrayPrint(count);
		System.out.println("num\tcount    <--sorted");
		System.out.println("---\t-----");
		for (int i = 0; i < 42; i++) {
			System.out.println(count[i][1] + "\t" + count[i][0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Calc.debug = true;
		int[] count, index;

		// Generating
		count = new int[42];
		index = new int[42];
		for (int i = 0; i < 42; i++) {
			index[i] = i + 1;
		}
		for (int i = 0; i < 100000; i++) {
			count[Calc.random(1, 42) - 1]++;
		}

		// Printing-original
		System.out.println("num\tcount    <--original");
		System.out.println("---\t-----");
		for (int i = 0; i < 42; i++) {
			System.out.println(index[i] + "\t" + count[i]);
		}

		// Sorting
		int k = 0;
		boolean changed;
		do {
			changed = false;
			for (int i = k; i < count.length - k - 1; i++) {
				if (count[i] < count[i + 1]) {
					int temp;
					temp = count[i];
					count[i] = count[i + 1];
					count[i + 1] = temp;
					temp = index[i];
					index[i] = index[i + 1];
					index[i + 1] = temp;
					changed = true;
				}
			}
			for (int i = count.length - k - 1; i > k; i--) {
				if (count[i] > count[i - 1]) {
					int temp;
					temp = count[i];
					count[i] = count[i - 1];
					count[i - 1] = temp;
					temp = index[i];
					index[i] = index[i + 1];
					index[i + 1] = temp;
					changed = true;
				}
			}
			k++;
		} while (changed);

		// Printing-sorted
		System.out.println("num\tcount    <--sorted");
		System.out.println("---\t-----");
		for (int i = 0; i < 42; i++) {
			System.out.println(index[i] + "\t" + count[i]);
		}
	}

}
