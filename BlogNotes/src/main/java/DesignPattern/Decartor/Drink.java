package DesignPattern.Decartor;

public abstract class Drink {
	private String des;
	private float price = 0f;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public abstract float cost();;

}
