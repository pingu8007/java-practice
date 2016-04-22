package moe.pingu.iii.shared.shape;

/**
 * Generate triangle and print out. First used in Homework 1 and 2.
 * 
 * @version 1.0.2016.04.22
 * @author PinGu
 *
 */
public class triangle {

	// Declaration
	/**
	 * Which character should be print out in main part.
	 */
	public char symbol = '*'; // symbol for solid part

	/**
	 * When true, the output vertically mirrored.
	 */
	public boolean flip_v = false; // vertically flip

	/**
	 * Decide the line ending be print or not if the length is between 0 and 1.
	 */
	public boolean over_h = true; // fill the boundary

	/**
	 * Triangle's slope. Too buggy to use.
	 */
	private double slope = 1.0; // slop = v/h //Very buggy, maybe switch to
								// enum to limit value...

	/**
	 * How many line is the triangle.
	 */
	public int high = 6; // block size = (max_high/slope) * max_high / 2

	/**
	 * Internal index, only used when line number not specified.
	 */
	protected int c_high = 1; // current step, 1 <= c_high <= max_high

	/**
	 * Triangle for space-padding.
	 */
	protected triangle fill = null;

	/**
	 * Padding or not.
	 */
	protected boolean alt = false; // fill the other half

	/**
	 * When true, the output horizontally mirrored.
	 */
	protected boolean flip_h = false; // horizontally flip when alt=true

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
			fill = new triangle();
			fill.symbol = fillSymbol;
			fill.flip_v = !this.flip_v;
			fill.over_h = !this.over_h;
			// fill.slope = this.slope;
			fill.high = this.high;
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
