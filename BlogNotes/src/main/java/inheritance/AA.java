package inheritance;

public class AA extends A{
	public void test() {
		System.out.println("AA");
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.test();
	}
}
