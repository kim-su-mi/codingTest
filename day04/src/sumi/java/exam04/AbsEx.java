package sumi.java.exam04;
/**
 * 
 * 자바 자료 - 8강 추상클래스와 인터페이스 참고
 *
 */
abstract class AbsEx1 {
	int a = 100; // 변수
	final String str = "abstract test"; // 상수

	public String getStr() { // 일반 메소드
		return str;
	}
// 추상 메소드는 몸체(body)가 없다. abstract public int getA();
}

abstract class AbsEx2 extends AbsEx1 {
	public int getA() { // 부모클래스의 추상 메소드 재 정의
		return a;
	}

	public abstract String getStr();
}

public class AbsEx extends AbsEx2 {
	public String getStr() { // AbsEx2의 추상 메소드 재 정의
		return str; // str은 AbsEx1의 멤버이다
	}

	public static void main(String[] args) {
		AbsEx ae = new AbsEx();
		System.out.println("ae.getA():" + ae.getA());
		System.out.println("ae.getStr():" + ae.getStr());
	}
}
