package Huawai;

import java.util.Arrays;
import java.util.Scanner;

public class GradesSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			Student.flag = sc.nextInt();

			Student[] stu = new Student[n];
			for (int i = 0; i < n; i++)
				stu[i] = new Student(sc.next(), sc.nextInt());

			Arrays.sort(stu);
			for (Student each : stu)
				System.out.println(each);
		}
		sc.close();
	}

	public static class Student implements Comparable<Student> {
		String name;
		int score;
		public static int flag;

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

		@Override
		public int compareTo(Student other) {
			if (flag == 0)
				return other.score - score;
			return score - other.score;
		}

		@Override
		public String toString() {
			return name + " " + score;
		}
	}
}
