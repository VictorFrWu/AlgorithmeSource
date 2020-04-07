package Huawai;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mac
 *         Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化
 *         ABBA->12ABBA,ABA->ABAKK,123321->51233214
 *         。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * 
 * 
 * 
 *         输入描述: 输入一个字符串
 * 
 *         输出描述: 返回有效密码串的最大长度
 * 
 *         示例1 输入 复制 ABBA 输出 复制 4
 */
public class LongestPalindrome {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("aaa");
		StringBuilder s = new StringBuilder();
		char[] cs = sb.toString().toCharArray();
		s.append(cs[0]);
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] != cs[i - 1]) {
				s.append(cs[i - 1]);
			}
			s.append(cs[i]);
		}
		s.append(cs[cs.length - 1]);
		System.out.println(s);
	}

}
