package moe.pingu.iii.method;

class Persons {
	int age = 24;

	public void Greeting() {
		System.out.println("KonNiChiWa");
	}

	public void Bye() {
		System.out.println("SaYoNaRa~");
	}
}

class Cloth {
	char size = 'L';
	// final boolean used;
	int price = 300;
}

class Calculator {
	private double mem = 0;

	public void zero() {
		this.mem = 0;
	}

	public Calculator add(double x) {
		this.mem += x;
		return this;
	}

	public Calculator minus(double x) {
		this.mem -= x;
		return this;
	}

	public Calculator times(double x) {
		this.mem *= x;
		return this;
	}

	public Calculator divide(double x) {
		this.mem /= x;
		return this;
	}

	public double getValue() {
		return mem;
	}
}

class Temperature {
	private double val = 0;
	private char std = 'C';

	public Temperature() {
		this(0, 'C');
	}

	public Temperature(double degree) {
		this(degree, 'C');
	}

	public Temperature(double degree, char std) {
		if (std == 'F' || std == 'C' || std == 'K') {
			this.std = std;
		} else {
			System.out.println("Format error, assume the value is C.");
		}
		val = degree;
	}

	public static double C2F(double degree) {
		return degree * 9 / 5 + 32;
	}

	public static double F2C(double degree) {
		return (degree - 32) / 9 * 5;
	}

	public double getF() {
		if (std == 'C') {
			return Temperature.C2F(this.val);
		} else if (std == 'K') {
			return Temperature.C2F(this.val + 273.15);
		} else {
			return val;
		}
	}

	public double getC() {
		if (std == 'F') {
			return Temperature.F2C(this.val);
		} else if (std == 'K') {
			return this.val + 273.15;
		} else {
			return this.val;
		}
	}

	public double getK() {
		if (std == 'F') {
			return Temperature.F2C(this.val) - 273.15;
		} else if (std == 'C') {
			return this.val - 273.15;
		} else {
			return this.val;
		}
	}
}

public class ClassTestEx1 {

	public static void main(String[] args) {
		// Calculator calc = new Calculator();
		// calc.zero();
		// calc.add(23);
		// calc.minus(64);
		// calc.times(2);
		// calc.divide(64);
		// System.out.println(calc.getValue());
		// calc.zero();
		// System.out.println(calc.add(23).minus(64).times(2).divide(64).getValue());
		// System.out.println(calc);

		// System.out.println(Temperature.C2F(0));
		// System.out.println(Temperature.F2C(32));

		Cloth mine = new Cloth();
		Cloth yours = new Cloth();
		mine.price = 200;
		mine.size = 'L';
		yours.price = 500;
		yours.size = 'M';

		System.out.println(mine + " " + mine.price + " " + mine.size);
		System.out.println(yours + " " + yours.price + " " + yours.size);

		yours = mine;

		System.out.println(mine + " " + mine.price + " " + mine.size);
		System.out.println(yours + " " + yours.price + " " + yours.size);

		yours = new Cloth();

		System.out.println(mine + " " + mine.price + " " + mine.size);
		System.out.println(yours + " " + yours.price + " " + yours.size);

	}

}
