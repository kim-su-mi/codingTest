package sumi.java.exam02;

import java.net.Socket;

public class SocketEx {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 3000);
		System.out.println("접속 성공");
	}
}
