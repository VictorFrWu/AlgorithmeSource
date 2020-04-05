package Huawai;

import java.util.Scanner;

public class LastString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			String[] strs = str.split(" ");
			int length = strs[strs.length - 1].length();
			System.out.println(length);
		}
	}
}
