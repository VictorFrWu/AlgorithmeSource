package Huawai;

import java.util.Scanner;

public class CubeRoot {
	// 使用二分查找算法
	public static double getCubeRoot(double input) {
		double min = 0;
		double max = input;
		double mid = 0;

		// 注意，这里的精度要提高一点，否则某些测试用例无法通过
		while ((max - min) > 0.001) {
			mid = (max + min) / 2;
			if (mid * mid * mid > input)
				max = mid;
			else if (mid * mid * mid < input)
				min = mid;
			else
				return mid;
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			double input = sc.nextDouble();
			double result = getCubeRoot(input);
			System.out.printf("%.1f\n", result);
		}
		sc.close();
	}
}
