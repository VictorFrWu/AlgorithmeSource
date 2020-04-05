package Tencent;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchJava {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int[] m = new int[181];
			for (int i = 0; i <= 180; i++) {
				m[i] = i - 90;
			}
			int index = Arrays.binarySearch(m, n);
			System.out.println(Integer.toBinaryString(m[index]).substring(26));
		}
	}

}
