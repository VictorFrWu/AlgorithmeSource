package Huawai;

import java.util.Scanner;

public class intBinaryCount {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int m = scan.nextInt();
//		char[] cs = Integer.toBinaryString(m).toCharArray();
//		int sum = 0;
//		for (char c : cs) {
//			if (c == '1') {
//				sum++;
//			}
//		}
//		System.out.println(sum);
//	}

	// bit manipulation
	public static void main(String[] args) {
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (; n > 0; n &= n - 1) {
			count++;
		}
		System.out.println(count);
	}
}
