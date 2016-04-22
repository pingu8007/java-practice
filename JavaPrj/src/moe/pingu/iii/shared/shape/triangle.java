package moe.pingu.iii.shared.shape;

public class triangle {

	// Declaration
	public char symbol = '*'; // symbol for solid part
	public boolean flip_v = false; // vertically flip
	public boolean overflow = true; // fill the boundary
	public double slope = 1.0; // slop = v/h
	public int high = 6; // block size = (max_high/slope) * max_high / 2

	protected int c_high = 1; // current step, 1 <= c_high <= max_high

	protected triangle fill = null;
	protected boolean alt = false; // fill the other half
	protected boolean flip_h = false; // horizontally flip when alt=true

	public void setAlt(boolean fillAuto, boolean fillBefore, char fillSymbol) {
		alt = fillAuto;
		flip_h = fillBefore;
		if (fillAuto) {
			fill = new triangle();
			fill.symbol = fillSymbol;
			fill.flip_v = !this.flip_v;
			fill.overflow = !this.overflow;
			fill.slope = this.slope;
			fill.high = this.high;
		} else {
			fill = null;
		}
	}

	public void fill(int line) {
		if (line >= 1 && line <= high) {

			// padding and padding before main
			if (alt && flip_h) {
				fill.fill(line);
			}

			// main
			double length;
			if (flip_v) {
				length = (((high - line + 1) / slope) + (high - line / slope)) * 1 / 2;
			} else {
				length = (((line - 1) / slope) + (line / slope)) * 1 / 2;
			}
			int l_length = 0;
			if (overflow) {
				l_length = (int) (length + 1);
			} else {
				l_length = (int) (length);
			}
			for (int i = 0; i < l_length; i++) {
				System.out.print(symbol);
			}

			// padding and padding after main
			if (alt && !flip_h) {
				fill.fill(line);
			}
		}
	}

	public void fillNext() {
		this.fill(c_high);
		c_high++;
	}

	public void fillAll() {
		c_high = 1;
		while (!this.isEnd()) {
			this.fillNext();
			System.out.print("\n");
		}
	}

	public boolean isEnd() {
		if (c_high > high) {
			return true;
		} else {
			return false;
		}
	}

}
