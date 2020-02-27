package DesignPattern.Decartor;

public class Soja extends Deco{

	public Soja(Drink obj) {
		super(obj);
		setPrice(0.5f);
		setDes("soja");
	}
}
