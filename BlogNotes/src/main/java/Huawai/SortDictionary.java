package Huawai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mac 9 cap to cat card two too up boat boot
 */
public class SortDictionary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		String[] arr = new String[m];
		for (int i = 0; i < m; i++) {
			arr[i] = scan.next();
		}
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
		for (String s : arr) {
			System.out.println(s);
		}
	}
}
