package SlidingWindows;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * @author mac Given an array nums, there is a sliding window of size k which is
 *         moving from the very left of the array to the very right. You can
 *         only see the k numbers in the window. Each time the sliding window
 *         moves right by one position. Return the max sliding window.
 * 
 *         Example:
 * 
 *         Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
 *         Explanation:
 * 
 *         Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3
 *         -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1
 *         -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7 Note: You may assume k is always
 *         valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 *         Follow up: Could you solve it in linear time?
 */
public class SlidingWindowMaximum239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0)
			return new int[0];
		int n = nums.length, left = 0;
		int[] res = new int[n - k + 1];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < nums.length; i++) {
			// remove number out of k
			if (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			if (i >= k - 1) {
				res[left] = nums[dq.peek()];
				left++;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(maxSlidingWindow(nums, k));
	}
}
