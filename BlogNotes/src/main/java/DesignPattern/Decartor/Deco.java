package DesignPattern.Decartor;

public class Deco extends Drink {
	private Drink obj;

	public Deco(Drink obj) {
		this.setObj(obj);
	}

	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return super.getPrice() + obj.cost();
	}

	public Drink getObj() {
		return obj;
	}

	public void setObj(Drink obj) {
		this.obj = obj;
	}

	@Override
	public String getDes() {
		return super.getDes() + " " + cost() + " && " + obj.getDes();
	}

}
