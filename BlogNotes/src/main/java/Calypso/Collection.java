package Calypso;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mac
 *
 *         interface iterable -> collection | Class:
 *         abstractlist,abstractqueue,abstractset Interface: list, set, queue
 *
 */

public class Collection {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "A");
		map.put(1, "B");
		map.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		String a = new String("a");
		String b = new String("a");
		System.out.println(a.equals(b));
		System.out.println(a == b);
		System.out.println(a.hashCode() + " " + b.hashCode());
	}
}
