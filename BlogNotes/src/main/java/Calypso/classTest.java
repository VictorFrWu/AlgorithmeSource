package Calypso;

public class classTest {
	int x;

	classTest() {
		super();
		System.out.println("s");
	}

	classTest(int x) {
		super();
		this.x = x;
		System.out.println("ss");
	}

	public static void main(String[] args) {
		classTest c = new classTest(1);
		System.out.println(c);
	}
}
