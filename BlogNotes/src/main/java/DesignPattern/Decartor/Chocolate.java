package DesignPattern.Decartor;

public class Chocolate extends Deco {

	public Chocolate(Drink obj) {
		super(obj);
		setDes("chocolate");
		setPrice(1.5f);
	}

}
