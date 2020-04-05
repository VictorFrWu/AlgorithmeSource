package Huawai;

import java.util.Scanner;

public class ReverseSentence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		String[] strs = str.split(" ");
		for (int i = strs.length - 1; i >= 0; i--) {
			System.out.println(strs[i]);
		}
	}
}
