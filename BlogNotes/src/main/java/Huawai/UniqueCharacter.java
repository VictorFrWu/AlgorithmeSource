package Huawai;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueCharacter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<Character> set = new HashSet<>();
		while (scan.hasNext()) {
			char[] cs = scan.nextLine().toCharArray();
			for (char c : cs) {
				if ((int) (c) >= 0 && (int) (c) < 128) {
					set.add(c);
				}
			}
		}
		System.out.println(set.size());
	}
}
