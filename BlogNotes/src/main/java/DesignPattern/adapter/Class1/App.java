package DesignPattern.adapter.Class1;

/**
 * @author he.wu
 *	1 adapter design pattern 
 *	high coupling but agile 
 */
public class App {
	public static void main(String[] args) {
		System.out.println(" ====  adapter class =====");
		Phone p = new Phone();
		p.charge(new VoltageAdapter());
	}
}
