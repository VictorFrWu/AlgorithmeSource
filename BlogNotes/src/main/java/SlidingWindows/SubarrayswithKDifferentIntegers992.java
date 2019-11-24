package SlidingWindows;

import org.junit.Test;

/**
 * @author mac Given an array A of positive integers, call a (contiguous, not
 *         necessarily distinct) subarray of A good if the number of different
 *         integers in that subarray is exactly K.
 * 
 *         (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 *         Return the number of good subarrays of A.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: A = [1,2,1,2,3], K = 2 Output: 7 Explanation: Subarrays formed
 *         with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3],
 *         [1,2,1], [2,1,2], [1,2,1,2]. Example 2:
 * 
 *         Input: A = [1,2,1,3,4], K = 3 Output: 3 Explanation: Subarrays formed
 *         with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * 
 * 
 *         Note:
 * 
 *         1 <= A.length <= 20000 1 <= A[i] <= A.length 1 <= K <= A.length
 */
public class SubarrayswithKDifferentIntegers992 {
	public int subarraysWithKDistinct(int[] nums, int k) {
		return mostKDsitinct(nums, k) - mostKDsitinct(nums, k - 1);
	}

	public int mostKDsitinct(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k >= nums.length)
			return 0;
		int[] hash = new int[nums.length];
		int l = 0, count = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			hash[nums[i]]++;
			if (hash[nums[i]] == 1)
				count++;
			while (count > k) {
				if (--hash[nums[l++]] == 0)
					count--;
			}
			res += i + 1 - l;
		}
		return res;
	}

	@Test
	public void test() {
		int[] A = { 1, 2, 1, 2, 3 };
		int K = 2;
		System.out.println(subarraysWithKDistinct(A, K));
	}
}
