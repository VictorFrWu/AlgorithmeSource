package SlidingWindows;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac Find the length of the longest substring T of a given string
 *         (consists of lowercase letters only) such that every character in T
 *         appears no less than k times.
 * 
 *         Example 1:
 * 
 *         Input: s = "aaabb", k = 3
 * 
 *         Output: 3
 * 
 *         The longest substring is "aaa", as 'a' is repeated 3 times. Example
 *         2:
 * 
 *         Input: s = "ababbc", k = 2
 * 
 *         Output: 5
 * 
 *         The longest substring is "ababb", as 'a' is repeated 2 times and 'b'
 *         is repeated 3 times
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters395 {
	public int longestSubstring(String s, int k) {
		int res = 0;
		int[] hash = new int[26];
		// use how many character match this condition
		char[] c = s.toCharArray();
		for (int i = 1; i <= 26; i++) {
			Arrays.fill(hash, 0);
			int left = 0, right = 0, uniqueChar = 0;
			while (right < s.length()) {
				boolean valid = true;
				if (hash[c[right] - 'a'] == 0) {
					uniqueChar++;
				}
				hash[c[right] - 'a']++;
				right++;
				// need exactly i unique characters
				while (uniqueChar > i) {
					if (hash[c[left] - 'a'] == 1) {
						uniqueChar--;
					}
					hash[c[left] - 'a']--;
					left++;
				}
				// if the string has any character with less than k occurrences, the string is
				// invalid
				for (int j = 0; j < 26; j++) {
					if (hash[j] > 0 && hash[j] < k) {
						valid = false;
						break;
					}
				}
				if (valid) {
					res = Math.max(res, right - left);
				}
			}
		}
		return res;
	}

	@Test
	public void test() {
		String s = "ababbc";
		int k = 2;
		System.out.println(longestSubstring(s, k));
	}
}
