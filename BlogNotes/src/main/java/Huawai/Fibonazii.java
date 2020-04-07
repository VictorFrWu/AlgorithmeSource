package Huawai;

public class Fibonazii {
	public static int fibonazi(int n) {
		if (n <= 1) {
			return n;
		} else {
			int a = fibonazi(n - 1);
			int b = fibonazi(n - 2);
			return a + b;
		}
	}

	public static int fibonazi2(int n) {
		if (n < 1) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int fibonazi3(int n) {
		if (n < 0) {
			return 0;
		}
		if (n < 2) {
			return n;
		}
		int first = 0, second = 1, sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(fibonazi3(6));
	}
}
