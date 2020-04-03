package Huawai;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SatisfyWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int tasks = scan.nextInt();
			int workers = scan.nextInt();

			// map save tasks
			Map<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < tasks; i++) {
				int difficult = scan.nextInt();
				int pi = scan.nextInt();
				if (map.containsKey(difficult)) {
					int updatePI = Math.max(pi, map.get(difficult));
					map.put(difficult, updatePI);
				}
				map.put(difficult, pi);
			}

			// 定义一个最小值
			int Max = 0x80000000;
			// 遍历
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				Integer key = (Integer) it.next();
				Integer value = map.get(key);
				// 如果大于最小值，就存下来
				if (value >= Max)
					Max = value;
				// 如果小于 直接替换即可
				else
					map.put(key, Max);
			}

			// list save

			for (int i = 0; i < workers; i++) {
				int ability = scan.nextInt();
				Integer index = ((TreeMap<Integer, Integer>) map).floorKey(ability);
				if (index != null) {
					System.out.println(map.get(index));
				} else {
					System.out.println(0);
				}
			}
		}
	}
}
