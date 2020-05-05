package Huawai;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class NoNegativeNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int count = 0;
		while (scan.hasNext()) {
			count++;
			int m = scan.nextInt();
			if (m >= 0) {
				list.add(m);
			}
		}
		scan.close();
		OptionalDouble average = list.stream().mapToDouble(x -> x).average();
		System.out.println(count - list.size());
		if (average.isPresent()) {
			System.out.printf("%.1f\n", average.getAsDouble());
		} else {
			System.out.println(0.0);
		}
	}
	
}
