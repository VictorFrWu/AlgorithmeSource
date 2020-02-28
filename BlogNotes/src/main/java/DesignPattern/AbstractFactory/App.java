package DesignPattern.AbstractFactory;

public class App {
	public static void main(String[] args) {
		new OrderPizza(new BjFactory());
	}
}
