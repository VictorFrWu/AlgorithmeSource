package Tencent;

import java.util.HashMap;
import java.util.Map;

public class RedBucket {
	public static int solution(int[] gifts) {
		int len = gifts.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : gifts) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
				if (map.get(i) > len) {
					return i;
				}
			} else {
				map.put(i, 1);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 3, 3, 2 }));
	}

}
