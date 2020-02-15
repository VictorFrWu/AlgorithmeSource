package solid;

public class Circle extends Shapes {
	private int radius;

	public Circle(String name, int radius) {
		super(name);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int area() {
		return (int) (Math.PI * radius * radius);
	}

	@Override
	public int volume() {
		return (int) (Math.PI * radius * 2);
	}
}
