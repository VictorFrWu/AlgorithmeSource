package Huawai;

import java.util.Scanner;

/**
 * @author mac 输入一个String数据
 * 
 *         输出描述: 输出string中大写字母的个数
 * 
 *         示例1 输入 复制 add123#$%#%#O 输出 复制 1
 */
public class CapitalLetterCalcul {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.next();
			int count = 0;
			for (char c : str.toCharArray()) {
				if (c >= 'A' && c <= 'Z') {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
