package Huawai;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RandomNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			Set<Integer> set = new TreeSet<>();
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				int temp = scan.nextInt();
				set.add(temp);
			}
			for (int i : set) {
				System.out.println(i);
			}
		}
	}

}
