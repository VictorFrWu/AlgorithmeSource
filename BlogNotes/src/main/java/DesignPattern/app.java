package DesignPattern;

import java.util.Arrays;
import java.util.List;

public class app {
	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep sheep = new Sheep("tom", 1);
		sheep.friend = new Sheep("doli", 2);
		Sheep sheep2 = (Sheep) sheep.clone();
		Sheep sheep3 = (Sheep) sheep.clone();
		Sheep sheep4 = (Sheep) sheep.clone();
		List<Sheep> l = Arrays.asList(sheep, sheep2, sheep3, sheep4);
		l.forEach(s -> System.out.println(s + " tom friend " + s.hashCode()));
	}
}
