package DesignPattern.adapter.Class1;

/**
 * @author he.wu
 *	1 adapter design pattern 
 *	high coupling but agile 
 *
 *
 *spring handler 
 *dispatch servelet 
 *
 *login - tomcat - dispatch servlet - handler mapping - model and view - execute method by adapter design pattern - applicationcontext xml configuration 
 */
public class App {
	public static void main(String[] args) {
		System.out.println(" ====  adapter class =====");
		Phone p = new Phone();
		p.charge(new VoltageAdapter());
	}
}
