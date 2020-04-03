package Huawai;

import java.util.Arrays;
import java.util.Scanner;

public class rotatArrat {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			boolean sign = false;
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				if (sign) {
					sum += i;
				} else {
					sum -= i;
				}
				if (i % m == 0) {
					sign = !sign;
				}
			}
			System.out.println(sum);
			
		}
	}
	
	// m^2 * (n/(2*m))

}
