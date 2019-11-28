package DynamicProgramming;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author he.wu Given two strings text1 and text2, return the length of their
 *         longest common subsequence.
 * 
 *         A subsequence of a string is a new string generated from the original
 *         string with some characters(can be none) deleted without changing the
 *         relative order of the remaining characters. (eg, "ace" is a
 *         subsequence of "abcde" while "aec" is not). A common subsequence of
 *         two strings is a subsequence that is common to both strings.
 * 
 * 
 * 
 *         If there is no common subsequence, return 0.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The
 *         longest common subsequence is "ace" and its length is 3. Example 2:
 * 
 *         Input: text1 = "abc", text2 = "abc" Output: 3 Explanation: The
 *         longest common subsequence is "abc" and its length is 3. Example 3:
 * 
 *         Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is
 *         no such common subsequence, so the result is 0.
 */
public class LongestCommonSubszquence1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1.length() == 0 || text2.length() == 0)
			return 0;
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < text1.length(); i++) {
			for (int j = 0; j < text2.length(); j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[text1.length()][text2.length()];
	}

	// print the longest common subsequence
	public String longestCommonSubsequence2(String text1, String text2) {
		if (text1.length() == 0 || text2.length() == 0)
			return "";
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < text1.length(); i++) {
			for (int j = 0; j < text2.length(); j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		int index = dp[text1.length()][text2.length()];
		if (index == 0)
			return "";
		return printLCS(text1.length(), text2.length(), index, dp, text1, text2);
	}

	// print the longest common subsequence
	public Set<String> longestCommonSubsequence3(String text1, String text2) {
		TreeSet<String> set = new TreeSet<String>();
		if (text1.length() == 0 || text2.length() == 0)
			return set;
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < text1.length(); i++) {
			for (int j = 0; j < text2.length(); j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		int index = dp[text1.length()][text2.length()];
		if (index == 0)
			return set;
		StringBuffer sb = new StringBuffer();
		printAllLcs(index, dp, text1, text2, set, text1.length(), text2.length(), sb);
		return set;
	}

	private String printLCS(int m, int n, int index, int[][] dp, String text1, String text2) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		int i = m, j = n;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
				sb.append(text1.charAt(i - 1)); // Put current character in result
				i--;
				j--;
				index--; // reduce values of i, j and index
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (dp[i - 1][j] > dp[i][j - 1])
				i--;
			else
				j--;
		}
		return sb.reverse().toString();
	}

	// all largest common string
	private void printAllLcs(int index, int[][] dp, String text1, String text2, Set<String> set, int i, int j,
			StringBuffer sb) {
		while (i > 0 && j > 0) {
			if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
				sb.append(text1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					j--;
				} else {
					printAllLcs(index, dp, text1, text2, set, i - 1, j, sb);
					printAllLcs(index, dp, text1, text2, set, i, j - 1, sb);
					return;
				}
			}
		}
		set.add(sb.reverse().toString());
	}

	@Test
	public void test() {
		String text1 = "artificiale", text2 = "algorithme";
		System.out.println(longestCommonSubsequence3(text1, text2));
	}
}
