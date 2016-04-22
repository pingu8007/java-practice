package moe.pingu.iii.operator;

public class TypeOperatorTestEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 1, b2, b3;
		
		b2 = 2;
		b3 = (byte) (b1 + b2);
		System.out.println("b1= " + b1 + "\nb2= " + b2 + "\nb3= " + b3);
		
		b2 = 127;
		b3 = (byte) (b1 + b2);
		System.out.println("b1= " + b1 + "\nb2= " + b2 + "\nb3= " + b3);

	}

}
