package Tencent;

import java.util.Scanner;

public class UniCode {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String n = scan.next();
		int len = n.length();
		char[] ch = n.toCharArray();
		long con = 0;
		int[] f = { 25 * 25 * 25 + 25 * 25 + 25 + 1, 25 * 25 + 25 + 1, 25 + 1, 1 };
		for (int i = 0; i < len; i++) {
			con += f[i] * (ch[i] - 'a') + 1;
		}
		if (ch[0] != 'a') {
			con -= 1;
		}
		System.out.println(con);
	}

}
