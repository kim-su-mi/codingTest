package sumi.java.exam14;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements WindowListener {
	
	/**
	 * 창띄우고 끄기
	 * 방법2) 상속 받음 
	 *  -> 근데 인터페이스 상속 받으니까 
	 *  	쓰지도 않을 메서드 오버라이드해야해서 귀찮음
	 * 
	 * WindowAdapter : 창 끄는 기능 보유한 클래스
	 * Frame : 창 띄우는 기능 있는 클래스
	 * => 둘 다 기존에 있는 클래스 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame() {
		super("Test");
		addWindowListener(this);
		setSize(300,200);
		setVisible(true);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("종료");
		System.exit(0);
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {}

	
	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
