package solid;

public class FormatOutputter {
	private CalculatorArea ca;
	private formatter format;

	public FormatOutputter(formatter format, CalculatorArea ca) {
		this.format = format;
		this.ca = ca;
	}

	public void transfer() {
		switch (format) {
		case JSON:
			System.out.println("json transfer " + ca.sumShapes());
			break;
		case HTML:
			System.out.println("html transfer " + ca.sumShapes());
			break;
		case TXT:
			System.out.println("txt transfer " + ca.sumShapes());
			break;
		case XML:
			System.out.println("xml transfer " + ca.sumShapes());
			break;
		}

	}

}
