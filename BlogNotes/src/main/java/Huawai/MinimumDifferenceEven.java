package Huawai;

import java.util.Scanner;

/**
 * @author mac 查找组成一个偶数最接近的两个素数 20 输出 7 13
 */
public class MinimumDifferenceEven {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			for (int i = m / 2; i >= 2; i--) {
				if (isPrime(i) && isPrime(m - i)) {
					System.out.println(i + "\n" + (m - i));
					break;
				}
			}
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
