package DesignPattern.Singleton.copy;

/**
 * @author mac 2 check double check locking
 */
public class SinglentonDCL {

	private SinglentonDCL() {
		System.out.println("hello singlenton dcl");
	}

	private volatile static SinglentonDCL dcl;

	public static SinglentonDCL getInstanceDcl() {
		if (dcl == null) {
			synchronized (SinglentonDCL.class) {
				if (dcl == null) {
					dcl = new SinglentonDCL();
				}
			}
		}
		return dcl;
	}

	public static void main(String[] args) {
		SinglentonDCL.getInstanceDcl();
	}
}
