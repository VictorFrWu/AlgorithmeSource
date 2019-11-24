package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac Given a string S and a string T, find the minimum window in S
 *         which will contain all the characters in T in complexity O(n).
 * 
 *         Example:
 * 
 *         Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
 * 
 *         If there is no such window in S that covers all characters in T,
 *         return the empty string "". If there is such window, you are
 *         guaranteed that there will always be only one unique minimum window
 *         in S.
 */
public class MinimumWindowSubstring76 {
	public String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0)
			return "";
		int[] hash = new int[128];
		char[] c = s.toCharArray();
		for (char i : t.toCharArray()) {
			hash[i]++;
		}
		int len = Integer.MAX_VALUE, left = 0, count = t.length();
		int begin = 0;
		for (int i = 0; i < c.length; i++) {
			hash[c[i]]--;
			if (hash[c[i]] >= 0) {
				count--;
			}
			while (count == 0) {
				hash[c[left]]++;
				if (hash[c[left]] > 0) {
					if (i - left + 1 < len) {
						begin = left;
						len = i - left + 1;
					}
					count++;
				}
				left++;
			}

		}
		return len != Integer.MAX_VALUE ? s.substring(begin, begin + len) : "";
	}

	// hashmap
	public String minWindow2(String s, String t) {
		if (s.length() == 0 || t.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int len = Integer.MAX_VALUE, count = 0, begin = 0, left = 0;
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (map.containsKey(c[i])) {
				map.put(c[i], map.get(c[i]) - 1);
			} else {
				map.put(c[i], -1);
			}
			if (map.get(c[i]) >= 0) {
				count++;
			}
			while (count == t.length()) {
				map.put(c[left], map.get(c[left]) + 1);
				if (map.get(c[left]) > 0) {
					count--;
					if (i - left + 1 < len) {
						begin = left;
						len = i - left + 1;
					}
				}
				left++;
			}
		}
		return len != Integer.MAX_VALUE ? s.substring(begin, begin + len) : "";
	}

	@Test
	public void test() {
		String S = "ADOBECODEBANC", T = "ABC";
		System.out.println(minWindow2(S, T));
	}

}
