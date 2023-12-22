package sumi.java.exam21;

class Super {
	public Super() {
		System.out.println("상위 클래스 기본 생성자");  // 2. 기본 생성자 추가 후 실행하면 Super()호출 안했는데도 출력됌
	}
	
	public Super(int x) {
		System.out.println("상위클래스 생성자 : " + x);
	}
}

class Sub extends Super {
	public Sub() {
//		super(5);  => 1. 주석처리하면 부모클래스 기본 생성자 없다고 오류뜸
		System.out.println("하위클래스 생성자");
	}
}

public class SuperEx2 {
	public static void main(String[] args) {
		Sub sub = new Sub();
	}

}
