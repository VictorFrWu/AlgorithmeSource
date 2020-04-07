package Huawai;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author mac 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 
 *         输出描述: 输出渊子真正的密文
 * 
 *         示例1 输入 复制 YUANzhi1987 输出 复制 zvbo9441987
 */
public class PasswordChange {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		map.put("abc", 2);
		map.put("def", 3);
		map.put("ghi", 4);
		map.put("jkl", 5);
		map.put("mno", 6);
		map.put("pqrs", 7);
		map.put("tuv", 8);
		map.put("wxyz", 9);
		while (scan.hasNext()) {
			String str = scan.nextLine().trim();
			char[] c = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < c.length; i++) {
				if (c[i] >= '0' && c[i] <= '9') {
					sb.append(c[i]);
					continue;
				}
				if (c[i] >= 'A' && c[i] <= 'Z') {
					int replace = c[i] - 'A' + 98;
					replace = replace <= 122 ? replace : 97;
					char temp = (char) (replace);
					sb.append(temp);
					continue;
				}
				if (c[i] >= 'a' && c[i] <= 'z') {
					for (Map.Entry<String, Integer> it : map.entrySet()) {
						if (it.getKey().contains(String.valueOf(c[i]))) {
							sb.append(it.getValue());
							break;
						}
					}
					continue;
				}
			}
			System.out.println(sb.toString());
		}
	}
}
