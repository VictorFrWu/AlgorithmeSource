package Huawai;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author mac 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *         注意每个输入文件有多组输入，即多个字符串用回车隔开 输入描述: 字符串只包含小写英文字母,
 *         不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 
 *         输出描述: 删除字符串中出现次数最少的字符后的字符串。
 * 
 *         示例1 输入 复制 abcdd 输出 复制 dd
 */
public class DeleteTheMinmumCharacter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			char[] cs = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			Map<Character, Integer> map = new HashMap<>();
			for (char c : cs) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			for (char c : cs) {
				if (map.get(c) > 1) {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
