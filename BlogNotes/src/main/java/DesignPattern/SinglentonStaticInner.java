package DesignPattern;

public class SinglentonStaticInner {
	private SinglentonStaticInner() {
		System.out.println("hello singleton inner");
	}

	private static final SinglentonStaticInner getInstanceInner() {
		return SingletonHolder.INSTANCE;
	}

	private static class SingletonHolder {
		private static final SinglentonStaticInner INSTANCE = new SinglentonStaticInner();
	}

	public static void main(String[] args) {
		SinglentonStaticInner.getInstanceInner();
	}
}
