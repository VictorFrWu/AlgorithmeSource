package Huawai;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mac 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 
 *         规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 
 *         如，输入： Type 输出： epTy
 * 
 *         规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 
 *         如，输入： BabA 输出： aABb
 * 
 *         规则 3 ：非英文字母的其它字符保持原来的位置。
 * 
 * 
 *         如，输入： By?e 输出： Be?y
 */
public class LetterSortOutput {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			List<String> ls = new LinkedList<>();
			for (char c : str.toCharArray()) {
				if (Character.isLetter(c)) {
					ls.add(String.valueOf(c));
				}
			}
			Collections.sort(ls, String.CASE_INSENSITIVE_ORDER);
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (char c : str.toCharArray()) {
				if (Character.isLetter(c)) {
					sb.append(ls.get(count));
					count++;
				} else {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
