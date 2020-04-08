package Huawai;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author mac 输入描述: 输入两个字符串。第一个为短字符，第二个为长字符。
 * 
 *         输出描述: 返回值：
 * 
 *         示例1 输入 复制 bc abc 输出 复制 true
 */
public class MatchString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			char[] first = scan.next().toCharArray();
			char[] second = scan.next().toCharArray();
			int[] bucket = new int[128];
			boolean bool = true;
			for (char c : second) {
				bucket[c]++;
			}
			for (char c : first) {
				if (bucket[c] == 0) {
					System.out.println(false);
					bool = false;
					break;
				}
			}
			if (bool) {
				System.out.println(true);
			}
		}
		scan.close();
	}
}
