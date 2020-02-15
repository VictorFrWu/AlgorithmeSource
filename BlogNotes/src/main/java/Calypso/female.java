package Calypso;

public class female extends Person {
	private boolean bra;

	public female(String name, int id, boolean bra) {
		super(name, id);
		this.bra = bra;
	}

	public boolean isBra() {
		return bra;
	}

	public void setBra(boolean bra) {
		this.bra = bra;
	}

	@Override
	public void eat() {
		System.out.println("feamle is eating");
	}

}
