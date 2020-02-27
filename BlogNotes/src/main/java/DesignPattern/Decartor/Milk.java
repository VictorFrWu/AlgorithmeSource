package DesignPattern.Decartor;

public class Milk extends Deco {

	public Milk(Drink obj) {
		super(obj);
		setDes("milk");
		setPrice(0.5f);
	}

}
