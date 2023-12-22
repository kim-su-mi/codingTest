package sumi.java.exam10;

import java.net.*;
import java.io.*;

public class MultiServerThread implements Runnable {
	private Socket socket; // 현재 클라이언트와의 통신을 위한 소켓
	private MultiServer ms; // MultiServer 객체에 대한 참조
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public MultiServerThread(MultiServer ms) {
		this.ms = ms; // MultiServer 객체를 생성자에서 전달받아 멤버 변수에 할당
	}

	public synchronized void run() {
		boolean isStop = false;
		try {
			// MultiServer에서 전달한 소켓을 받아옴
			socket = ms.getSocket();
			ois = new ObjectInputStream(socket.getInputStream()); // 입력 스트림 초기화
			oos = new ObjectOutputStream(socket.getOutputStream()); // 출력 스트림 초기화
			String message = null;
			while (!isStop) {
				message = (String) ois.readObject(); // 클라이언트로부터 메시지를 읽어옴
				String[] str = message.split("#"); // 메시지를 '#' 문자를 기준으로 분리
				if (str[1].equals("exit")) {
					broadCasting(message);
					isStop = true;
				} else {
					broadCasting(message);
				}
			}
			// 스레드가 종료되면 MultiServer의 리스트에서 제거
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		} catch (Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "비정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		}
	}
	// 모든 클라이언트에게 메시지를 브로드캐스팅하는 메서드
	public void broadCasting(String message) throws IOException {
		for (MultiServerThread ct : ms.getList()) {
			ct.send(message);
		}
	}
	// 특정 클라이언트에게 메시지를 보내는 메서드
	public void send(String message) throws IOException {
		oos.writeObject(message);
	}
}