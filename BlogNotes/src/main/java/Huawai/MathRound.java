package Huawai;

import java.util.Scanner;

public class MathRound {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			float f = scan.nextFloat();
			// System.out.println(Math.round(f));
			int i = (int) ((f * 10) % 10);
			if (i > 5) {
				System.out.println(f + 1);
			}
			System.out.println(f);

			System.out.println((int) (f + 0.5));
		}
	}
}
