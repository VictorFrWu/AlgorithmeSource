package Huawai;

import java.util.Scanner;

public class Dividestring {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				printString(scan.next().trim());
			}
		}
	}

	public static void printString(String str) {
		int len = str.length();
		int mode = len % 8;
		for (int i = 0; i < len / 8; i++) {
			System.out.println(str.substring(0, 8));
			str = str.substring(8);
		}
		if (mode > 0) {
			while (mode < 8) {
				str += "0";
				mode++;
			}
			System.out.println(str);
		}

	}
}
