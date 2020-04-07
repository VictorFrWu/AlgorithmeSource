package Huawai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mac Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * 
 *         输出描述: Lily的所有图片按照从小到大的顺序输出
 * 
 *         示例1 输入 复制 Ihave1nose2hands10fingers 输出 复制 0112Iaadeeefghhinnnorsssv
 */
public class SortWithASCII {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			char[] str = scan.next().toCharArray();
			Arrays.sort(str);
			StringBuilder sb = new StringBuilder();
			for (char c : str) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
		scan.close();
	}

}
