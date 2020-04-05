package Huawai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class returnNoDuplicatedNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			char[] cs = scan.nextLine().toCharArray();
			List<Character> list = new ArrayList<>();
			for (int i = cs.length - 1; i >= 0; i--) {
				char c = cs[i];
				if (!list.contains(c)) {
					list.add(c);
				}
			}
			StringBuilder sb = new StringBuilder();
			for (char c : list) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}
