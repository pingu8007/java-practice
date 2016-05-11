package moe.pingu.iii.collection;

import java.util.Hashtable;
import java.util.Iterator;
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
		// System.out.println(i1.getValue());

		LinkedList<Hashtable<String, Integer>> l1 = new LinkedList<Hashtable<String, Integer>>();
		for (int i = 0; i <= 16; i++) {
			Hashtable<String, Integer> p = new Hashtable<String, Integer>();
			p.put("x", i);
			p.put("y", i * i);
			l1.add(p);
//			l1.offer(p);
		}

		// method A
		Iterator<Hashtable<String, Integer>> catcher = l1.iterator();
		while (catcher.hasNext()) {
			System.out.println(catcher.next().get("y"));
		}

		// method B
		for (Hashtable<String, Integer> p : l1) {
			// System.out.println(p.get("y"));
		}
	}

}
