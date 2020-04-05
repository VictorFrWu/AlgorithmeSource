package Huawai;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PokerGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			Integer[] n = new Integer[m];
			for (int i = 0; i < m; i++) {
				n[i] = scan.nextInt();
			}
			Arrays.sort(n, Collections.reverseOrder());
			long sum = 0;
			boolean sign = false;
			for (int i : n) {
				if (sign) {
					sum -= i;
				} else {
					sum += i;
				}
				sign = !sign;
			}
			System.out.println(sum);
		}
	}

}
