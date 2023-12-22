package sumi.java.exam13;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 
 * 책에 없는 예제
 * 창띄우고 끄기
 * 방법1) 내가 객체 만듦 - 계속 객체.메서드해야해서 귀찮음
 * 
 * WindowAdapter : 창 끄는 기능 보유한 클래스
 * Frame : 창 띄우는 기능 있는 클래스
 * => 둘 다 기존에 있는 클래스
 */
class myEvent extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("종료");
		System.exit(0);
	}
	
}
public class MyFrameEx {
	public static void main(String[] args) {
		Frame myFrame = new Frame();  // Frame은 자바에 원래 있는 클래스
		// 이벤트 연결 메서드
		myFrame.addWindowListener(new myEvent());
		myFrame.setSize(300,200);
		myFrame.setVisible(true);
	}

}
