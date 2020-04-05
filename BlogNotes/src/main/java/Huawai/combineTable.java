package Huawai;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class combineTable {
	 public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			while (scan.hasNext()) {
				int m = scan.nextInt();
				Map<Integer, Integer> map = new TreeMap<>();
				for (int i = 0; i < m; i++) {
					int key = scan.nextInt();
					int value = scan.nextInt();
					if (map.containsKey(key)) {
						map.put(key, (map.get(key) + value));
					}else {
						map.put(key, value);
					}
				}
				map.forEach((k, v) -> System.out.println(k + " " + v));
			}
	    }

}
