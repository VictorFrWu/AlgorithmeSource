package Calypso;

public class instance {
	static Point currentPoint = new Point();

	public static void main(String[] args) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,1);
	}

}

class Point {
	int x, y;
	Point currentPoint;

	Point() {
		System.out.println("s");
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		currentPoint = new Point(1, 2);
		System.out.println("ss");
	}

}