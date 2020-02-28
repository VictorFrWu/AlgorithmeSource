package DesignPattern.builder;

/**
 * @author he.wu
 *	builder design pattern encapsulate detail
 *	one director can call the method for building
 *
 *	a peoduct is composite to an abstract class
 *	and then, sub class realise them 
 */
public class App {
	public static void main(String[] args) {
		//common house
		HouseBuilding h = new CommonHouse();
		HouseDirector hd = new HouseDirector(h);
		House house = hd.construct();
		System.out.println("process of construct");
		//gratte ciel 
		HouseBuilding h2 = new GratteCiel();
		hd.setHb(h2);
		hd.construct();
	}
}
