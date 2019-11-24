package SlidingWindows;

import org.junit.Test;

/**
 * @author mac Given a string, find the length of the longest substring T that
 *         contains at most k distinct characters.
 * 
 *         For example, Given s = “eceba” and k = 2,
 * 
 *         T is "ece" which its length is 3. ————————————————
 * 
 */
public class LongestSubstringAtMostKDistinct340 {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0)
			return 0;
		if (k >= s.length())
			return s.length();
		int left = 0, count = 0, res = 0;
		char[] c = s.toCharArray();
		int[] hash = new int[128];
		for (int i = 0; i < c.length; i++) {
			hash[c[i]]++;
			if (hash[c[i]] == 1) {
				count++;
			}
			while (count > k) {
				hash[c[left]]--;
				if (hash[c[left]] == 0) {
					count--;
				}
				left++;
			}
			res = Math.max(res, i - left + 1);
		}
		return res;
	}

	@Test
	public void test() {
		String s = "eceba";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}
}
