package exceptionCheck;

public class exceptionCatch {
	public static int getNum() {

		try {
			int a = 1 / 0;
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

	public static void main(String[] args) {
		System.out.println(getNum());
	}
}
