package Huawai;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RandomNumberMing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			Set<Integer> set = new TreeSet<>();
			for (int i = 0; i < m; i++) {
				set.add(scan.nextInt());
			}
			for (int i : set) {
				System.out.println(i);
			}
		}
	}

}
