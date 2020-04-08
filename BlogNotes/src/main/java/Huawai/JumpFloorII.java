package Huawai;

import java.util.Arrays;

public class JumpFloorII {
	public int JumpFloorII(int target) {
		if (target < 3) {
			return target;
		} else {
			int count = 0;
			while (target > 0) {
				count += JumpFloorII(target - 1);
				target = target - 1;
			}
			return count + 1;
		}
	}

	public int JumpFloorIIDp(int target) {
		if (target <= 2) {
			return target;
		}
		int[] dp = new int[target + 1];
		Arrays.fill(dp, 1); // 初始化每一种都可以直接从 0 跳到 n
		dp[0] = 0; // 从 0 跳到 0 为 0 种，因为 n = 0，没法跳
		for (int i = 2; i <= target; i++) {
			for (int j = i - 1; j >= 1; j--) {
				dp[i] += dp[j]; // 第 n 个状态是由前 n - 1 种状态推导出来，就是累加！
			}
		}
		return dp[target];
	}

	public int JumpFloorIIMath(int target) {
		if (target < 3) {
			return target;
		} else {
			return 1 << (target - 1);
		}
	}
}
