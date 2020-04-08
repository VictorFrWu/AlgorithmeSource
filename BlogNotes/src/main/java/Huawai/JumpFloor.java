package Huawai;

public class JumpFloor {
	public static int JumpFloor(int target) {
		if (target <= 3) {
			return target;
		} else {
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}
	}

	public static void main(String[] args) {
		System.out.println(JumpFloor(4));
	}

	public int JumpFloor2(int target) {
		if (target < 0) {
			return 0;
		}
		if (target < 3) {
			return target;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target];
	}

	public int JumpFloor3(int target) {
		if (target < 0) {
			return 0;
		}
		if (target < 3) {
			return target;
		}
		int sum = 0, first = 1, second = 1;
		for (int i = 2; i <= target; i++) {
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
	}
}
