package Calypso;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class testsocket {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("google.com", 80);
		OutputStream output = socket.getOutputStream();
		System.out.println(output.toString());
	}
}