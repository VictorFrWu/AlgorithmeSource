package Huawai;

import java.util.Scanner;

public class HexToDecimal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine().substring(2);
			int i = Integer.parseInt(str, 16);
			System.out.println(i);
		}
	}
}
