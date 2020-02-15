package solid;

public class App {
	public static void main(String[] args) {
		Square s = new Square("square", 1);
		Circle c = new Circle("circle", 1);
		Shapes[] ss = { s, c };
		CalculatorArea ca = new CalculatorArea(ss);
		System.out.println(ca.sumShapes());
		FormatOutputter fo = new FormatOutputter(formatter.HTML, ca);
		fo.transfer();
	}
}
