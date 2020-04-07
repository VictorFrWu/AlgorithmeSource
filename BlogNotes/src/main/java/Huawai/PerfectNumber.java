package Huawai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mac 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 
 *         它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 
 *         例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * 
 * 
 * 
 *         给定函数count(int n),用于计算n以内(含n)完全数的个数
 * 
 * @param n 计算范围, 0 < n <= 500000
 * 
 * @return n 以内完全数的个数, 异常情况返回-1
 */
public class PerfectNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			if (m > 500000 || m < 2) {
				System.out.println(-1);
			}
			int count = 0;
			for (int i = 1; i < m; i++) {
				List<Integer> list = new ArrayList<>();
				for (int j = 1; j < i; j++) {
					if (i % j == 0) {
						list.add(j);
					}
				}
				int intSum = list.stream().mapToInt(Integer::intValue).sum();
				if (intSum == i) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(-1);
			} else {
				System.out.println(count);
			}
		}
	}
}
