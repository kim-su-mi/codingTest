package sumi.java.exam16;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.DomainCombiner;

public class MyFrame extends Frame {

	/**
	 * 창띄우고 끄기
	 * 방법4)익명 이너 클래스 사용
	 * 
	 * WindowAdapter : 창 끄는 기능 보유한 클래스
	 * Frame : 창 띄우는 기능 있는 클래스
	 * => 둘 다 기존에 있는 클래스 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyFrame() {
		super("익명이너 클래스");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("종료");
				System.exit(0);
			}
		});
		setSize(300,200);
		setVisible(true);
	}
		public static void main(String[] args) {
			new MyFrame();
		}
	}

