package moe.pingu.iii.method;

class Person {
	int age = 23;
	
	public void greeting(){
		System.out.println("konnichiwa~");
	}
}

public class TestMethodEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person yamato = new Person();
		yamato.greeting();
		System.out.println(yamato.age);
	}

}
