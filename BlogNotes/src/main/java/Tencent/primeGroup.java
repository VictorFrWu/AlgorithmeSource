package Tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class primeGroup {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int i = 3; i <= n; i++) {
				if (isPrime(i)) {
					list.add(i);
				}
			}
			System.out.println(count(list, n));
		}
	}

	public static int count(List<Integer> list, int n) {
		List<Integer> ans = new ArrayList<>();
		int res = 0;
		for (int i : list) {
			if (2 * i == n || ans.contains(n - i)) {
				res++;
			}
			ans.add(i);
		}
		return res;
	}

	public static boolean isPrime(int n) {
		int k = (int) Math.sqrt(n);
		for (int i = 2; i <= k; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
