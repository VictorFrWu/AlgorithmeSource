package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//heritage interface of serialization
public class HelloWorldImp extends UnicastRemoteObject implements HelloWorld {

	protected HelloWorldImp() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String sayHello(String name) throws RemoteException {
		return "Hello, " + name;
	}

	@Override
	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}

}
