package solid;

public abstract class Shapes implements ShapeInterface, ShapeVolumInterface {
	private String name;

	public Shapes(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
