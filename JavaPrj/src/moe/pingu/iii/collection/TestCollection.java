package moe.pingu.iii.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class TestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList pool1 = new ArrayList();
		pool1.add("Tom");
		pool1.add("Jerry");
		pool1.add(2345);
		pool1.add(new Double(2.71828));
		pool1.add((float) 3.14159);
		// System.out.println(pool1);

		HashSet pool2 = new HashSet();
		while (pool2.size() < 16) {
			pool2.add((int) (Math.random() * 42) + 1);
		}

		TreeSet pool3 = new TreeSet();
		// pool3.add("23456");
		// pool3.addAll(pool1);
		// System.out.println(pool3);

		Queue queue = new LinkedList<>(pool1);
		// System.out.println(queue.size());
		// while (queue.peek() != null) {
		// System.out.println(queue.poll());
		// }
		// System.out.println(queue.size());

		Map<String, String> pool4 = new Hashtable<String, String>();
		pool4.put("1st", "Tom");
		pool4.put("2nd", "Jerry");
		pool4.put("3rd", "Andy");
		pool4.put("3rd", "Tim");

		// Iterator i1 = pool1.listIterator();
		Iterator i2 = pool2.iterator();

		while (i2.hasNext()) {
			System.out.println(i2.next());
		}
		//
		// System.out.println("keys\t=" + pool4.keySet());
		// System.out.println("vals\t=" + pool4.values());
		// System.out.println("pair\t=" + pool4.entrySet());

		System.out.println("1st is " + pool4.get("1st"));
	}

}
