package Huawai;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveFirstLetterString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			Character[] cs = new Character[str.length()];
			for (int i = 0; i < str.length(); i++) {
				cs[i] = Character.valueOf(str.charAt(i));
			}
			boolean bool = false;
			List<Character> ls = Arrays.asList(cs);
			for (char c : cs) {
				if (ls.indexOf(c) == ls.lastIndexOf(c)) {
					System.out.println(c);
					bool = true;
					break;
				}
			}
			if (!bool) {
				System.out.println(-1);
			}
		}
	}
}
