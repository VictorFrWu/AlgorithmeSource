package DesignPattern.builder;

/**
 * @author he.wu builder design pattern encapsulate detail one director can call
 *         the method for building
 *
 *         a peoduct is composite to an abstract class and then, sub class
 *         realise them
 *
 *         StringBuilder is a builder design pattern
 *
 *         appendable is an interface who is a abstract building class
 *         abstractstringbuilder implement interface stirngbuilder is an
 *         director and a build class
 */
public class App {
	public static void main(String[] args) {
		// common house
		HouseBuilding h = new CommonHouse();
		HouseDirector hd = new HouseDirector(h);
		House house = hd.construct();
		System.out.println("process of construct");
		// gratte ciel
		HouseBuilding h2 = new GratteCiel();
		hd.setHb(h2);
		hd.construct();
	}
}
