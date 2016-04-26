package moe.pingu.iii.shared.gen;

/**
 * Generate triangle and print out. First used in Homework 1 and 2.
 * 
 * @version 1.1.2016.04.26
 * @author PinGu
 *
 */
public class Triangle {

	// Declaration
	/**
	 * Which character should be print out in main part.
	 */
	private char symbol = '*'; // symbol for solid part

	/**
	 * When true, the output vertically mirrored.
	 */
	private boolean flip_v = false; // vertically flip

	/**
	 * Decide the line ending be print or not if the length is between 0 and 1.
	 */
	private boolean over_h = true; // fill the boundary

	/**
	 * Triangle's slope. Too buggy to use.
	 */
	private double slope = 1.0; // slop = v/h //Very buggy, maybe switch to
								// enum to limit value...

	/**
	 * How many line is the triangle.
	 */
	private int high = 6; // block size = (max_high/slope) * max_high / 2

	/**
	 * Internal index, only used when line number not specified.
	 */
	private int c_high = 1; // current step, 1 <= c_high <= max_high

	/**
	 * Triangle for space-padding.
	 */
	private Triangle fill = null;

	/**
	 * Padding or not.
	 */
	private boolean alt = false; // fill the other half

	/**
	 * When true, the output horizontally mirrored.
	 */
	private boolean flip_h = false; // horizontally flip when alt=true

	/**
	 * Constructor for triangle pattern.
	 */
	public Triangle() {
		this.high = 6;
		this.symbol = '*';
		this.flip_v = false;
		this.over_h = true;
	}

	/**
	 * Constructor for triangle pattern.
	 * 
	 * @param high
	 *            Level of triangle, must larger than zero.
	 */
	public Triangle(int high) {
		if (high < 1) {
			this.high = 1;
		} else {
			this.high = high;
		}
		this.symbol = '*';
		this.flip_v = false;
		this.over_h = true;
	}

	/**
	 * Constructor for triangle pattern.
	 * 
	 * @param high
	 *            Level of triangle, must larger than zero.
	 * @param flip_v
	 *            When true, the output vertically mirrored.
	 */
	public Triangle(int high, boolean flip_v) {
		if (high < 1) {
			this.high = 1;
		} else {
			this.high = high;
		}
		this.symbol = '*';
		this.flip_v = flip_v;
		this.over_h = true;
	}

	/**
	 * Constructor for triangle pattern.
	 * 
	 * @param high
	 *            Level of triangle, must larger than zero.
	 * @param symbol
	 *            Character user for filling.
	 */
	public Triangle(int high, char symbol) {
		if (high < 1) {
			this.high = 1;
		} else {
			this.high = high;
		}
		this.symbol = symbol;
		this.flip_v = false;
		this.over_h = true;
	}

	/**
	 * Constructor for triangle pattern.
	 * 
	 * @param high
	 *            Level of triangle, must larger than zero.
	 * @param symbol
	 *            Character user for filling.
	 * @param flip_v
	 *            When true, the output vertically mirrored.
	 */
	public Triangle(int high, char symbol, boolean flip_v) {
		if (high < 1) {
			this.high = 1;
		} else {
			this.high = high;
		}
		this.symbol = symbol;
		this.flip_v = flip_v;
		this.over_h = true;
	}

	/**
	 * Constructor for triangle pattern.
	 * 
	 * @param high
	 *            Level of triangle, must larger than zero.
	 * @param symbol
	 *            Character user for filling.
	 * @param flip_v
	 *            When true, the output vertically mirrored.
	 * @param fillOver
	 *            Decide the line ending be print or not if the length is
	 *            between 0 and 1.
	 */
	public Triangle(int high, char symbol, boolean flip_v, boolean fillOver) {
		if (high < 1) {
			this.high = 1;
		} else {
			this.high = high;
		}
		this.symbol = symbol;
		this.flip_v = flip_v;
		this.over_h = fillOver;
	}

	/**
	 * Setup the space-padding triangle.
	 * 
	 * @param fillAuto
	 *            Whether padding with alt char or not.
	 */
	public void setAlt(boolean fillAuto) {
		alt = fillAuto;
		flip_h = false;
		if (fillAuto) {
			fill = new Triangle(this.high, ' ', !this.flip_v, !this.over_h);
		} else {
			fill = null; // release it.
		}
	}

	/**
	 * Setup the space-padding triangle.
	 * 
	 * @param fillAuto
	 *            Whether padding with alt char or not.
	 * @param fillBefore
	 *            Padding before the main triangle.
	 */
	public void setAlt(boolean fillAuto, boolean fillBefore) {
		alt = fillAuto;
		flip_h = fillBefore;
		if (fillAuto) {
			fill = new Triangle(this.high, ' ', !this.flip_v, !this.over_h);
		} else {
			fill = null; // release it.
		}
	}

	/**
	 * Setup the space-padding triangle.
	 * 
	 * @param fillAuto
	 *            Whether padding with alt char or not.
	 * @param fillBefore
	 *            Padding before the main triangle.
	 * @param fillSymbol
	 *            Filling with what character.
	 */
	public void setAlt(boolean fillAuto, boolean fillBefore, char fillSymbol) {
		alt = fillAuto;
		flip_h = fillBefore;
		if (fillAuto) {
			fill = new Triangle(this.high, fillSymbol, !this.flip_v, !this.over_h);
		} else {
			fill = null; // release it.
		}
	}

	/**
	 * Print out single line.
	 * 
	 * @param line
	 *            Line number, from 1 to @high
	 */
	public void fill(int line) {
		if (line >= 1 && line <= high) {

			// when padding and padding before main
			if (alt && flip_h) {
				fill.fill(line);
			}

			// main
			// calculate line length
			double length;
			if (flip_v) {
				length = (((high - line + 1) / slope) + ((high - line) / slope)) / 2;
			} else {
				length = (((line - 1) / slope) + (line / slope)) / 2;
			}
			int l_length = 0;

			// handle the ending
			// Attention! when length = 0, 0.5, 1 may lead to error.
			if (over_h && (length % 1 > 0)) {
				l_length = (int) (length + 1);
			} else {
				l_length = (int) (length);
			}

			// print out
			for (int i = 0; i < l_length; i++) {
				System.out.print(symbol);
			}

			// when padding and padding after main
			if (alt && !flip_h) {
				fill.fill(line);
			}
		}
	}

	/**
	 * Auto print out next lines, the line number will start from 1 and not
	 * affect by fill()
	 */
	public void fillNext() {
		this.fill(c_high);
		c_high++;
	}

	/**
	 * Print out ALL lines.
	 */
	public void fillAll() {
		c_high = 1;
		while (!this.isEnd()) {
			this.fillNext();
			System.out.print("\n");
		}
	}

	/**
	 * Check whether the internal index already goes to the end.
	 * 
	 * @return Boolean, return true when it's end.
	 */
	public boolean isEnd() {
		if (c_high > high) {
			return true;
		} else {
			return false;
		}
	}

}
