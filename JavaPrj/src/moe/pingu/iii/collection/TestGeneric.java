package moe.pingu.iii.collection;

import java.util.Hashtable;
import java.util.LinkedList;

class Tester<T> {
	private T value;

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tester<Integer> i1 = new Tester<Integer>();
		i1.setValue(20);
		System.out.println(i1.getValue());

		LinkedList<Hashtable<String, String>> l1 = new LinkedList<Hashtable<String, String>>();
		Hashtable<String, String> p1 = new Hashtable<String, String>();
		p1.put("x", "22");
		l1.add(p1);
	}

}
