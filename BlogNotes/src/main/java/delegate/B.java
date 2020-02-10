package delegate;

public class B {
    private A a;
    public B(A a) {
        this.a = a; 
    }
    void foo() {
        a.foo(); // call foo() on the a-instance }
    }
    void bar() {
        System.out.println("b.bar");
    }
    
    public static void main(String[] args) {
    	A a = new A();
    	B b = new B(a); 
    	b.foo();
    	b.bar();
	}
}
