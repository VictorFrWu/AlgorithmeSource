package delegate;

public class A {
	void foo() {
		this.bar();
	}

	void bar() {
		System.out.println("a.bar");
	}
}