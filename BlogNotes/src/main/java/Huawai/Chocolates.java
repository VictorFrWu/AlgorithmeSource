package Huawai;

import java.util.Scanner;

public class Chocolates {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int day = scan.nextInt();
		int number = scan.nextInt();
		System.out.print(fun(day, number));
	}

	// 计算第一天吃s个巧克力一共需要多少个多少个巧克力
	public static int sum(int s, int n, int m) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += s;
			s = (s + 1) / 2;// 向上取整
		}
		return sum;
	}

	// 二分查找
	public static int fun(int n, int m) {
		if (n == 1)
			return m;
		int low = 1;
		int high = m;// 第一天的巧克力一定是大于等于1小于等于m的
		while (low <= high) {
			int mid = (low + high + 1) / 2;// 向上取整
			if (sum(mid, n, m) == m)
				return mid;// 如果第一天吃mid个巧克力，刚刚好吃完所有巧克力，那么直接返回
			else if (sum(mid, n, m) < m) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}

}
