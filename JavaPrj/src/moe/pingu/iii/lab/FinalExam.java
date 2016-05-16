package moe.pingu.iii.lab;

class Exam {
	Exam() {

	}

	Exam(int a) {
		System.out.println("Here");
	}
}

public class FinalExam extends Exam {

	public static void main(String[] args) {
		Exam obj = new Exam();
		// A
		// super(10);
		// Exam(10);
	}

	FinalExam() {
		// B
		super(10);
	}

	void function() {
		// C
		// super(10);
	}
}
