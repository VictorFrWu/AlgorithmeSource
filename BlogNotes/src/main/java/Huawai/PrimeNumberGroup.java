package Huawai;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author mac 输入说明 1 输入一个正偶数n 2 输入n个整数
 * 
 *         输出描述: 求得的“最佳方案”组成“素数伴侣”的对数。
 * 
 *         示例1 输入 复制 4 2 5 6 13 输出 复制 2
 */
public class PrimeNumberGroup {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			int N = Integer.parseInt(str);
			long[] nums = new long[N];
			String[] str1 = sc.nextLine().split(" ");
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(str1[i]);
			}
			// 偶数部分
			ArrayList<Long> evens = new ArrayList<Long>();
			// 奇数部分
			ArrayList<Long> odds = new ArrayList<Long>();
			for (int i = 0; i < N; i++) {
				if (nums[i] % 2 == 0) { // 偶数
					evens.add(nums[i]);
				} else { // 奇数
					odds.add(nums[i]);
				}
			}
			long[] evensMatch = new long[evens.size()];
			int result = 0;
			for (int i = 0; i < odds.size(); i++) {
				int[] used = new int[evens.size()];
				if (find(odds.get(i), evens, used, evensMatch)) {
					result++;
				}
			}
			System.out.println(result);

		}
		sc.close();
	}

	private static boolean isPrime(long num) {
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
			if (num == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean find(long x, ArrayList<Long> evens, int[] used, long[] evensMatch) {
		int j;
		for (j = 0; j < evens.size(); j++) {
			if (isPrime(x + evens.get(j)) && used[j] == 0) {
				used[j] = 1;
				if (evensMatch[j] == 0 || find(evensMatch[j], evens, used, evensMatch)) {
					evensMatch[j] = x;
					return true;
				}
			}
		}
		return false;
	}

}
