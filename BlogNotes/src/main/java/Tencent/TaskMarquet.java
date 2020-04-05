package Tencent;

import java.util.Scanner;

public class TaskMarquet {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int first = scan.nextInt();
			int second = scan.nextInt();
			if (first < 1 || first > 1024 || second < 1 || second > 1024) {
				System.out.println(-1);
			} else {
				if (first == second) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
	}

}
