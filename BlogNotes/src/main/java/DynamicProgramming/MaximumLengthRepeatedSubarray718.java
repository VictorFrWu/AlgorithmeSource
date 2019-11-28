package DynamicProgramming;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu Given two integer arrays A and B, return the maximum length of
 *         an subarray that appears in both arrays.
 * 
 *         Example 1:
 * 
 *         Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The
 *         repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 *         Note:
 * 
 *         1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 */
public class MaximumLengthRepeatedSubarray718 {
	// find sebsequence
	public int findLength2(int[] A, int[] B) {
		if (A.length == 0 || B.length == 0)
			return 0;
		int[][] dp = new int[A.length + 1][B.length + 1];
		// Arrays.fill(dp, 0);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[A.length][B.length];
	}

	public int findLength(int[] A, int[] B) {
		if (A.length == 0 || B.length == 0)
			return 0;
		int res = 0;
		int[][] dp = new int[A.length + 1][B.length + 1];
		for (int i = A.length - 1; i >= 0; --i) {
			for (int j = B.length - 1; j >= 0; --j) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] A = { 1, 2, 3, 2, 1 }, B = { 3, 2, 1, 4, 7 };
		System.out.println(findLength(A, B));
	}
}
