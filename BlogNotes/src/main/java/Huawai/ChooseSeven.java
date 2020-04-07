package Huawai;

import java.util.Scanner;

public class ChooseSeven {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			if (m < 7) {
				System.out.println(0);
			} else if (m == 7) {
				System.out.println(1);
			} else {
				int count = 0;
				for (int i = 7; i <= m; i++) {
					if (String.valueOf(i).contains("7") || i % 7 == 0) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
		scan.close();
	}
}
