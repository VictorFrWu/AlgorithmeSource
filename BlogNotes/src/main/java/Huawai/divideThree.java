package Huawai;

import java.util.Scanner;

public class divideThree {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int floor = scan.nextInt();
			int plafond = scan.nextInt();
			int[] arr = new int[plafond - floor];
			StringBuilder sb = new StringBuilder();
			int ans = 0;
			for (int i = 1; i <= plafond; i++) {
				sb.append(i);
				if (i >= floor) {
					int temp = Integer.parseInt(sb.toString());
					if (temp % 3 == 0) {
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
