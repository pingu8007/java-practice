package moe.pingu.iii.condition;

public class IfElseTestEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int yourSeat = 2;
		int bulletWheel = (int) (Math.random() * 6) + 1;
		System.out.println("Target selected: Seat No."+bulletWheel);
		if (yourSeat == bulletWheel) {
			System.out.println("You Dead! Game Over!");
		} else {
			System.out.println("God bless you.");
		}
		System.out.println("Come on! Try again~");
	}

}
