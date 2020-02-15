package Calypso;

public class Male extends Person {
	private boolean sex;

	public Male(String name, int id, boolean sex) {
		super(name, id);
		this.setSex(sex);
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public void eat() {
		System.out.println("male is eating");
	}
}
