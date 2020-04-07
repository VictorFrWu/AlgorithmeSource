package Huawai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mac 输入描述: 输入说明 1 输入两个整数 2 输入一个整数数组
 * 
 *         输出描述: 输出一个整数数组
 * 
 *         示例1 输入 复制 5 2 1 3 5 7 2 输出 复制 1 2
 */
public class OutputMinimumNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int m = scan.nextInt();
			int n = scan.nextInt();
			int[] nums = new int[m];
			for (int i = 0; i < m; i++) {
				nums[i] = scan.nextInt();
			}
			Arrays.sort(nums);
			if (n > m) {
				System.out.print(false);
			}
			int[] arr = Arrays.copyOfRange(nums, 0, n);
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
