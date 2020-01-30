package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloWorldServer {
	public static void main(String[] args) {
		try {
			// 创建一个远程对象
			HelloWorld hello = new HelloWorldImp();
			// 生成远程对象注册表Registry的实例，并指定端口为8888（默认端口是1099）
			LocateRegistry.createRegistry(8888);
			// 把远程对象注册到RMI注册服务器上，并命名为RHello
			// 绑定的URL标准格式为：rmi://host:port/name(协议名可以省略，下面两种写法都可以）
			try {
				Naming.bind("rmi://127.0.0.1:8888/RHello", hello);
			} catch (java.rmi.AlreadyBoundException e) {
				System.out.println("发生重复绑定对象异常！");
				e.printStackTrace();
			}
			System.out.println(">>INFO:远程IHello对象绑定成功！");
		} catch (RemoteException e) {
			System.out.println("创建远程对象发生异常！");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("发生URL畸形异常！");
			e.printStackTrace();
		}
	}
}
