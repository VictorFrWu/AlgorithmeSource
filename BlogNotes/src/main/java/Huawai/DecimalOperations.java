package Huawai;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author mac 要求编程实现上述高精度的十进制加法。 要求实现方法： public String add (String num1, String
 *         num2) 【输入】num1：字符串形式操作数1，如果操作数为负，则num1的前缀为符号位'-'
 *         num2：字符串形式操作数2，如果操作数为负，则num2的前缀为符号位'-'
 *         【返回】保存加法计算结果字符串，如果结果为负，则字符串的前缀为'-' 注：
 *         (1)当输入为正数时，'+'不会出现在输入字符串中；当输入为负数时，'-'会出现在输入字符串中，且一定在输入字符串最左边位置；
 *         (2)输入字符串所有位均代表有效数字，即不存在由'0'开始的输入字符串，比如"0012", "-0012"不会出现；
 *         (3)要求输出字符串所有位均为有效数字，结果为正或0时'+'不出现在输出字符串，结果为负时输出字符串最左边位置为'-'。
 * 
 * 
 * 
 *         输入描述: 输入两个字符串
 * 
 *         输出描述: 输出给求和后的结果
 * 
 *         示例1 输入 复制 9876543210 1234567890 输出 复制 11111111100
 */
public class DecimalOperations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String a = in.next();
			String b = in.next();
			BigInteger c = new BigInteger(a);
			BigInteger d = new BigInteger(b);
			System.out.println(c.add(d));
		}
	}
}
