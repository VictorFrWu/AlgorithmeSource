package Huawai;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine().trim();
			str = str.replaceAll("[^a-zA-Z]+", " ");
			String[] strs = str.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = strs.length - 1; i >= 0; i--) {

				sb.append(strs[i] + " ");

			}
			System.out.println(sb.toString().trim());
		}
	}

}
