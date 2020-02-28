package DesignPattern.adapter.Interface3;

public class App {
	public static void main(String[] args) {
		AdapterV adapter = new AdapterV() {
			@Override
			public void v1() {
				System.out.println("use method 1");
			}
		};
		adapter.v1();
	}
}
