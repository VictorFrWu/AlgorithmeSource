package solid;

public class Square extends Shapes {
	private int length;

	public Square(String name, int length) {
		super(name);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int area() {
		return length * length;
	}

	@Override
	public int volume() {
		return (int) Math.pow(length, 3);
	}

}