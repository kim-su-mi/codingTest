package sumi.java.exam10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
	// MultiServerThread 객체들을 저장하기 위한 ArrayList
	private ArrayList<MultiServerThread> list; 
	private Socket socket;

	public MultiServer() throws IOException {
		// MultiServerThread 객체를 저장하기 위한 ArrayList 생성
		list = new ArrayList<MultiServerThread>();
		// 서버 소켓을 5000 포트로 생성
		ServerSocket serverSocket = new ServerSocket(5000);
		MultiServerThread mst = null;
		boolean isStop = false;
		while (!isStop) {
			// 서버가 클라이언트 연결을 기다리고 있다는 메시지 출력
			System.out.println("Server Ready");
			// 클라이언트의 연결을 대기하고, 연결이 수락되면 클라이언트와 통신할 소켓 생성
			socket = serverSocket.accept(); 
			// MultiServerThread 객체 생성, this를 통해 MultiServer 인스턴스를 전달
			mst = new MultiServerThread(this);
			// MultiServerThread 객체를 리스트에 추가
			list.add(mst);
			// MultiServerThread를 실행할 새로운 스레드 생성
			Thread t = new Thread(mst);
			t.start(); // 스레드 시작 
		}
	}
	
	// MultiServerThread 객체들을 포함한 리스트 반환
	public ArrayList<MultiServerThread> getList() {
		return list;
	}
	
	// 현재 소켓 반환
	public Socket getSocket() {
		return socket;
	}
	
	// MultiServer 객체 생성 및 서버 시작
	public static void main(String[] ar) throws IOException {
		new MultiServer();
	}
}
