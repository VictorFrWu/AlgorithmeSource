package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class Garph {
	@Test
	public void test() {
		int[] fromsIds = { 0, 0, 1, 1, 1, 3, 3, 4 };
		int[] toIds = { 1, 2, 2, 3, 4, 4, 5, 5 };
		createGraph(fromsIds, toIds);
		arcs.forEach((k, v) -> {
			System.out.print(k + " -> ");
			v.forEach(x -> System.out.printf("%d ", x));
			System.out.println();
		});
	}

	// 存储节点信息
	public Set<Integer> vertices;
	// 存储边的信息
	public Map<Integer, List<Integer>> arcs;
	// 入度为0
	public Set<Integer> pres;

	public void getPres(int[] toIds) {
		Set<Integer> set = vertices;
		for (int i : toIds) {
			set.remove(i);
		}
		set.forEach(x -> pres.add(x));
	}

	public void createGraph(int[] fromIds, int[] toIds) {
		arcs = new HashMap<Integer, List<Integer>>();
		characters(fromIds, toIds);
		getPres(toIds);
		for (int i = 0; i < toIds.length; i++) {
			if (arcs.get(fromIds[i]) == null) {
				List<Integer> temp = new ArrayList<>();
				temp.add(toIds[i]);
				arcs.put(fromIds[i], temp);
			} else {
				arcs.get(fromIds[i]).add(toIds[i]);
			}
		}
		boolean b = checkCircle(arcs);
		if (b) {
			System.out.println("exists circle");
		} else {
			System.out.println("not exists circle");
		}
	}


	private boolean checkCircle(Map<Integer, List<Integer>> arcs2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void characters(int[] fromIds, int[] toIds) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < toIds.length; i++) {
			set.add(toIds[i]);
			set.add(fromIds[i]);
		}
		vertices = set;
	}
}
