package SlidingWindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/**
 * @author mac Given a string s and a non-empty string p, find all the start
 *         indices of p's anagrams in s.
 * 
 *         Strings consists of lowercase English letters only and the length of
 *         both strings s and p will not be larger than 20,100.
 * 
 *         The order of output does not matter.
 * 
 *         Example 1:
 * 
 *         Input: s: "cbaebabacd" p: "abc"
 * 
 *         Output: [0, 6]
 * 
 *         Explanation: The substring with start index = 0 is "cba", which is an
 *         anagram of "abc". The substring with start index = 6 is "bac", which
 *         is an anagram of "abc". Example 2:
 * 
 *         Input: s: "abab" p: "ab"
 * 
 *         Output: [0, 1, 2]
 * 
 *         Explanation: The substring with start index = 0 is "ab", which is an
 *         anagram of "ab". The substring with start index = 1 is "ba", which is
 *         an anagram of "ab". The substring with start index = 2 is "ab", which
 *         is an anagram of "ab".
 */

public class FindAllAnagramInString438 {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<Integer>();
		if (s.length() == 0 || p.length() == 0 || p.length() > s.length())
			return res;
		int[] hashP = new int[128];
		char[] c = s.toCharArray();
		int[] hashS = new int[128];
		int count = 0;
		for (char i : p.toCharArray()) {
			hashP[i]++;
		}
		for (int i = 0; i < c.length; i++) {
			hashS[c[i]]++;
			count++;
			if (count == p.length()) {
				if (Arrays.equals(hashP, hashS)) {
					res.add(i + 1 - p.length());
				}
				count--;
				hashS[c[i + 1 - p.length()]]--;
			}
		}
		return res;
	}

	@Test
	public void test() {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}
}
