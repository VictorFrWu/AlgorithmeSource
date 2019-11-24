package SlidingWindows;

import org.junit.Test;

/**
 * @author mac Given a string, find the length of the longest substring T that
 *         contains at most 2 distinct characters. For example, Given s =
 *         â€œecebaâ€�, T is "ece" which its length is 3.
 */
public class LongestSubstringAtMostTwoDistinct159 {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		int res = 0, left = 0, count = 0;
		char[] c = s.toCharArray();
		int[] hash = new int[128];
		for (int i = 0; i < c.length; i++) {
			hash[c[i]]++;
			if (hash[c[i]] == 1) {
				count++;
			}
			while (count > 2) {
				hash[c[left]]--;
				if (hash[c[left]] == 0) {
					count--;
				}
				left++;
			}
			res = Math.max(i - left + 1, res);
		}
		return res;
	}

	@Test
	public void test() {
		String s = "eeeceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

}
