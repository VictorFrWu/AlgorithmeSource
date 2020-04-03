package Huawai;

import java.util.Scanner;

public class hexoToDecimal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String tem = scan.nextLine().substring(2);
			System.out.println(Integer.parseInt(tem, 16));
		}
	}

}
