package Huawai;

import java.util.*;

public class SkipObstacle {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			String s = sc.next();
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == '.') {
					sum++;
					j = j + 2;
				}
			}
			System.out.println(sum);
		}
	}
}
