package BattleDev11Novembre2019;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author he.wu
 *
 *
 */
public class cable3 {
	public static void main(String[] argv) throws Exception {
		String line;
		Scanner sc = new Scanner(System.in);
		String[] global = sc.nextLine().split(" ");
		int number = Integer.valueOf(global[0]);
		int request = Integer.valueOf(global[1]);
		int[][] ints = new int[request][2];
		int i = 0;
		while (sc.hasNextLine() && i < request) {
			line = sc.nextLine();
			String[] tem = line.split(" ");
			ints[i][0] = Integer.valueOf(tem[0]);
			ints[i][1] = Integer.valueOf(tem[1]);
			i++;
		}
		Arrays.sort(ints, (int[] n1, int[] n2) -> n1[0] - n2[0]);
		int[] ans = new int[request];
		ans[0] = 1;
		int[] min = new int[2];
		min[0] = 1;
		min[1] = ints[0][1];
		boolean bool = true;
		for (int j = 1; j < ints.length; j++) {
			if (j + 1 < request) {
				ans[j] = j + 1;
				if (ints[j][1] < min[1]) {
					min[0] = j;
					min[1] = ints[j][1];
				}
			} else {
				if (ints[j][0] > min[1]) {
					bool = false;
				} else {
					ans[j] = min[0];
				}
			}
		}

		if (bool)
			System.out.println(ans);
		else
			System.out.println("pas possible");
	}
}
