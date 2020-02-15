package solid;

public class CalculatorArea {
	private Shapes[] shapes;

	public CalculatorArea(Shapes[] shapes) {
		this.shapes = shapes;
	}

	public int sumShapes() {
		int sum = 0;
		if (shapes.length == 0) {
			return 0;
		} else {
			for (Shapes shape : shapes) {
				sum += shape.area();
			}
			return sum;
		}
	}

	public int volumeShapes() {
		int sum = 0;
		if (shapes.length == 0) {
			return 0;
		} else {
			for (Shapes shape : shapes) {
				sum += shape.volume();
			}
			return sum;
		}
	}
}
