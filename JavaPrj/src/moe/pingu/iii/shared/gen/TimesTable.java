package moe.pingu.iii.shared.gen;

public class TimesTable {

	private char padChar = ' ';
	private boolean padding = true;

	private int size_x = 1;
	private int size_y = 1;
	private final int start_x = 1;
	private final int start_y = 1;

	private int pos_h = 1;
	private int pos_v = 1;

	private int length_x = 1;
	private int length_y = 1;
	private int length_z = 1;

	public static void main(String[] args) {
		TimesTable obj = new TimesTable();
		obj.setSize(10, 20);
		obj.setPadding(true);

//		obj.fill(10, 20);
//		System.out.print('\n');
//
//		obj.fillNext();
//		System.out.print('\n');
//		obj.fillNext();
//		System.out.print('\n');
//		obj.fillNext();
//		System.out.print('\n');
//		System.out.print('\n');
//
//		obj.fillLine(1);

		obj.fillAll();

//		obj.setPadding(false);
//		obj.fillAll();
	}

	/**
	 * Setting the size of Times Table.
	 * 
	 * @param size_h
	 *            Horizontal size of the Times Table.
	 * @param size_v
	 *            Vertical size of the Times Table.
	 */
	public void setSize(int size_h, int size_v) {
		this.size_x = size_h;
		this.length_x = (int) Math.log10(size_h) + 1;
		this.size_y = size_v;
		this.length_y = (int) Math.log10(size_v) + 1;
		this.length_z = (int) Math.log10(size_h * size_v) + 1;
	}

	/**
	 * Padding with space or not.
	 * 
	 * @param padding
	 */
	public void setPadding(boolean padding) {
		this.padding = padding;
	}

	/**
	 * Fill in correspond equation.
	 * 
	 * @param pos_h
	 *            value X
	 * @param pos_v
	 *            value Y
	 */
	public void fill(int pos_h, int pos_v) {
		if (pos_h >= start_x && pos_h <= size_x && pos_v >= start_y && pos_v <= size_y) {

			for (int j = length_y - (int) Math.log10(pos_v) - 1; j > 0; j--) {
				System.out.print(padChar);
			}
			System.out.print(pos_v);
			if (padding) {
				System.out.print(" ");
			}

			System.out.print("*");
			if (padding) {
				System.out.print(" ");
			}

			for (int i = length_x - (int) Math.log10(pos_h) - 1; i > 0; i--) {
				System.out.print(padChar);
			}
			System.out.print(pos_h);
			if (padding) {
				System.out.print(" ");
			}

			System.out.print("=");
			if (padding) {
				System.out.print(" ");
			}

			for (int k = length_z - (int) Math.log10(pos_h * pos_v) - 1; k > 0; k--) {
				System.out.print(padChar);
			}
			System.out.print(pos_h * pos_v);
			if (padding) {
				System.out.print("\t");
			}
		}
	}

	/**
	 * Fill in next equation.
	 */
	public void fillNext() {
		fill(pos_h, pos_v);
		if (pos_h < size_x) {
			pos_h++;
		} else {
			pos_h = start_x;
			pos_v++;
		}
	}

	/**
	 * Fill in correspond line.
	 * 
	 * @param pos_v
	 *            Line number
	 */
	public void fillLine(int pos_v) {
		this.pos_h = start_x;
		this.pos_v = pos_v;
		while (this.pos_v == pos_v) {
			fillNext();
		}
		System.out.print('\n');
	}

	/**
	 * Fill in everything.
	 */
	public void fillAll() {
		pos_v = start_y;
		while (pos_v <= size_y) {
			fillLine(pos_v);
		}
	}

}
