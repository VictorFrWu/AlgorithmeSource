package DesignPattern;

public class Sheep implements Cloneable {
	private String name;
	private int id;
	public Sheep friend;

	public Sheep(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// shallow copy
//	@Override
//	public Object clone() {
//		Sheep sheep = null;
//		try {
//			sheep = (Sheep) super.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.toString());
//		}
//		return sheep;
//	}

	// deep copy 1 clone
	@Override
	public Object clone() throws CloneNotSupportedException {
		Sheep sheep = null;
		sheep = (Sheep) super.clone();
		return sheep;
	}

	@Override
	public String toString() {
		return "sheep [name=" + name + ", id=" + id + "]";
	}

}
