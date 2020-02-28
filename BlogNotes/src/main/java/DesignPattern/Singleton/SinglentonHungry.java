package DesignPattern.Singleton;

/**
 * @author mac 1 private constrcutor 2 creta an instance 3 get instance
 *         (sychronized)
 */
public class SinglentonHungry {

	private SinglentonHungry() {
		System.out.println("hello Singlenton Hungry");
	}

	private static SinglentonHungry hungry;

	public static synchronized SinglentonHungry getInstanceHungry() {
		if (hungry == null) {
			hungry = new SinglentonHungry();
		}
		return hungry;
	}

	public static void main(String[] args) {
		SinglentonHungry.getInstanceHungry();
	}
}