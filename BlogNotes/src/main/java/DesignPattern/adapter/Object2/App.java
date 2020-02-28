package DesignPattern.adapter.Object2;

/**
 * @author he.wu 1 adapter design pattern high coupling but agile
 */
public class App {
	public static void main(String[] args) {
		System.out.println(" ====  adapter object =====");
		Phone p = new Phone();
		p.charge(new VoltageAdapter(new Voltage220()));
	}
}
