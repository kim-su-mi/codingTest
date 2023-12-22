package sumi.java.exam01;

class ParentEx {
	int foo = 5;

	public int getNumber(int a) {
		return a + 1;
	}
}

public class SonEx extends ParentEx {
	int foo = 7;
	
	@ Override
	public int getNumber(int a) {  // 보모의 getNumber메서드 오버 라이드
		return a + 2;
	}

	public static void main(String args[]) {
		ParentEx pe = new SonEx();
		System.out.println(pe.getNumber(0)); // 결과 2  -> 자식 메서드 사용
		System.out.println(pe.foo); // 결과 5 -> 부모 멤버 변수 사용
	}
}
