package moe.pingu.iii.shared.gen;

/**
 * Generate TimesTable and print out. First used in Lab 20160421-1.
 * 
 * @version 1.0.2016.04.26
 * @author PinGu
 *
 */
public class TimesTable {

	private char padChar = ' ';
	private boolean padding = false;

	private int size_x = 1;
	private int size_y = 1;
	private final int start_x = 1;
	private final int start_y = 1;

	private int pos_h = 1;
	private int pos_v = 1;

	private int length_x = 1;
	private int length_y = 1;
	private int length_z = 1;

	/**
	 * Setting the size of Times Table.
	 */
	public TimesTable() {
		this.size_x = 4;
		this.size_y = 4;
		this.length_x = (int) Math.log10(this.size_x) + 1;
		this.length_y = (int) Math.log10(this.size_y) + 1;
		this.length_z = (int) Math.log10(this.size_x * this.size_y) + 1;
		this.padding = false;
		this.padChar = ' ';
	}

	/**
	 * Setting the size of Times Table.
	 * 
	 * @param size_v
	 *            Vertical size of the Times Table, must larger than zero.
	 * @param size_h
	 *            Horizontal size of the Times Table, must larger than zero.
	 */
	public TimesTable(int size_v, int size_h) {
		if (size_h < 1) {
			this.size_x = 1;
		} else {
			this.size_x = size_h;
		}
		if (size_v < 1) {
			this.size_y = 1;
		} else {
			this.size_y = size_v;
		}
		this.length_x = (int) Math.log10(this.size_x) + 1;
		this.length_y = (int) Math.log10(this.size_y) + 1;
		this.length_z = (int) Math.log10(this.size_x * this.size_y) + 1;
		this.padding = false;
		this.padChar = ' ';
	}

	/**
	 * Setting the size of Times Table.
	 * 
	 * @param size_v
	 *            Vertical size of the Times Table, must larger than zero.
	 * @param size_h
	 *            Horizontal size of the Times Table, must larger than zero.
	 * @param padChar
	 *            Character used for padding.
	 */
	public TimesTable(int size_v, int size_h, char padChar) {
		if (size_h < 1) {
			this.size_x = 1;
		} else {
			this.size_x = size_h;
		}
		if (size_v < 1) {
			this.size_y = 1;
		} else {
			this.size_y = size_v;
		}
		this.length_x = (int) Math.log10(this.size_x) + 1;
		this.length_y = (int) Math.log10(this.size_y) + 1;
		this.length_z = (int) Math.log10(this.size_x * this.size_y) + 1;
		this.padding = true;
		this.padChar = padChar;
	}

	/**
	 * Padding with space or not.
	 * 
	 * @param padding
	 *            Whether padding or not.
	 */
	public void setPadding(boolean padding) {
		this.padding = padding;
		this.padChar = ' ';
	}

	/**
	 * Padding with space or not.
	 * 
	 * @param padding
	 *            Whether padding or not.
	 * @param padChar
	 *            Character used for padding.
	 */
	public void setPadding(boolean padding, char padChar) {
		this.padding = padding;
		this.padChar = padChar;
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
			// Switch to printf for (a little) better performance
			if (padding) {
				System.out.printf("%" + length_x + "d" + padChar + "*" + padChar + "%" + length_y + "d" + padChar + "="
						+ padChar + "%" + length_z + "d\t", pos_h, pos_v, pos_h * pos_v);
			} else {
				System.out.printf("%" + length_x + "d*%" + length_y + "d=%" + length_z + "d\t", pos_h, pos_v,
						pos_h * pos_v);
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
