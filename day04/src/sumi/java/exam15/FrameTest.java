package sumi.java.exam15;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest extends Frame {

	/**
	 * 창띄우고 끄기
	 * 방법3) 이너 클래스 이용
	 * 
	 * WindowAdapter : 창 끄는 기능 보유한 클래스
	 * Frame : 창 띄우는 기능 있는 클래스
	 * => 둘 다 기존에 있는 클래스 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameTest() {
		super("FrameTest");
		addWindowListener(new myEvent());
		setSize(300,200);
		setVisible(true);
	}
	
	class myEvent extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("종료");
			System.exit(0);
		}
		
	}
}
