package Huawai;

import java.util.Scanner;

public class PrimesNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			StringBuilder sb = new StringBuilder();
			long n = scan.nextLong();
			System.out.println(getResult(n, sb));
		}
	}

	public static String getResult(long n, StringBuilder sb) {
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				sb.append(i + " ");
				n = n / i;
				return getResult(n, sb);
			}
		}
		return sb.toString();
	}
}
