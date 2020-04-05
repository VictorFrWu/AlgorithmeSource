package Huawai;

import java.util.Scanner;

public class SplitStringNumber {
	// solution 1
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		while (scan.hasNext()) {
//			String[] strs = new String[2];
//			strs[0] = scan.nextLine();
//			strs[1] = scan.nextLine();
//			for (String str : strs) {
//				helper(str);
//			}
//		}
//	}
//
//	public static void helper(String str) {
//		int len = str.length();
//		int mode = len % 8;
//		int times = len / 8 + (mode == 0 ? 0 : 1);
//		if (mode != 0) {
//			int dif = 8 - mode;
//			StringBuilder sb = new StringBuilder(str);
//			for (int i = 0; i < dif; i++) {
//				sb.append("0");
//			}
//			str = sb.toString();
//		}
//		for (int i = 0; i < times; i++) {
//			System.out.println(str.substring(0, 8));
//			str = str.substring(8);
//		}
//	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			int mode = 8 - str.length() % 8;
			StringBuilder sb = new StringBuilder(str);
			if (mode > 0 && mode < 8) {
				for (int i = 0; i < mode; i++) {
					sb.append("0");
				}
			}
			str = sb.toString();
			while (str.length() > 0) {
				System.out.println(str.substring(0, 8));
				str = str.substring(8);
			}
		}
	}

}
