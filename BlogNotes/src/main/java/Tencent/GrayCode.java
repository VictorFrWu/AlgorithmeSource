package Tencent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < (1 << n); i++)
			result.add(i ^ (i >> 1));
		return result;
	}

	public static String[] getGray(int n) {
		if (n == 1)
			return new String[] { "0", "1" };
		String[] s = getGray(n - 1);
		String[] res = new String[s.length * 2];
		for (int i = 0; i < s.length; i++) {
			res[i] = "0" + s[i];
			res[s.length + i] = "1" + s[s.length - 1 - i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs = getGray(3);
		System.out.println(Arrays.toString(strs));
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			List<String> list = new LinkedList<>();
			for (int i = 0; i < (1 << n); i++) {
				int temp = i ^ (i >> 1);
				list.add(Integer.toBinaryString(temp));
			}
			list.forEach(System.out::println);
		}
	}
}
