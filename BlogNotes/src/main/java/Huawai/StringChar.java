package Huawai;

import java.util.Scanner;

public class StringChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			char[] cs = scan.nextLine().toLowerCase().toCharArray();
			char c = scan.nextLine().charAt(0);
			int res = 0;
			for (char i : cs) {
				if (c == i) {
					res++;
				}
			}
			System.out.println(res);
		}
	}
}
