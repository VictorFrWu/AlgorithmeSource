package RMI;

import java.rmi.Naming;

public class HelloWorldClient {
	public static void main(String args[]) {
		try {
			// 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
			HelloWorld rhello = (HelloWorld) Naming.lookup("rmi://127.0.0.1:8888/RHello");
			System.out.println(rhello.sayHello("world"));
			System.out.println(rhello.sum(454, 5457));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
