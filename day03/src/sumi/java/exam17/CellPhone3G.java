package sumi.java.exam17;

/**
 * 
 * 자바 자료 - 7강 상속 참고
 * 메서드 오버라이드 = 메서드 재정의
 *
 */
import java.security.DomainCombiner;

class CellPhone {
	public void call() {
		System.out.println("통화를 합니다.");
	}
}

public class CellPhone3G extends CellPhone {  // CellPhone3G는 CellPhone상속 받음
	@Override // 메서드 재정의
	public void call() {
		System.out.println("영상통화를 합니다."); // 부모 클래스의 call메서드를 재정의해서 사용
												  // 원래 cell메서드 기능 : 통화 -> 재정의 : 영상통화
	}	
	public static void main(String[] args) {	
		CellPhone3G phone = new CellPhone3G();
		phone.call();
		
	
	}
}
