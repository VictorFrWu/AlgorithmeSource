package Huawai;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraySort {
	public static void main(String[] args) {
		Integer[][] m = { { 1, 2 }, { 3, 4 }, { 3, 3 }, { 2, 6 } };
		Arrays.sort(m, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1].compareTo(o2[1]);
			}
			return o1[0].compareTo(o2[0]);
		});
		System.out.println(Arrays.deepToString(m));

		List<Person> list = Arrays.asList(new Person("a", 3, 11), new Person("b", 2, 33), new Person("c", 2, 22));
//		Collections.sort(list, (o1, o2) -> {
//			if (o1.money == o2.money) {
//				return o1.age - o2.age;
//			}
//			return o1.money - o2.money;
//		});
		Collections.sort(list, Comparator.comparingInt(Person::getMoney).thenComparingInt(Person::getAge));
		list.forEach(System.out::println);
	}

	public static class Person {
		 String name;

		 int money;
		 int age;

		public Person(String name, int money, int age) {
			this.name = name;
			this.money = money;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", money=" + money + ", age=" + age + "]";
		}

	}
}
