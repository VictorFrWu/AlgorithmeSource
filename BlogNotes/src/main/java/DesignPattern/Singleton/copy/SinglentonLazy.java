package DesignPattern.Singleton.copy;

/**
 * @author mac 1 constructor private 2 create a global instance 3 get a instance
 */

public class SinglentonLazy {
	private SinglentonLazy() {
		System.out.println("hello lazy singlenton");
	}

	private static SinglentonLazy lazy = new SinglentonLazy();

	public static SinglentonLazy getInstanceLazy() {
		return lazy;
	}

	public static void main(String[] args) {
		SinglentonLazy ss = SinglentonLazy.getInstanceLazy();
	}
}
