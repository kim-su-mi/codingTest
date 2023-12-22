package sumi.java.exam09;
/**
 * 
 * 자바 자료 - 9강 이너 클래스 참고
 * 멤버 이너 클래스 : 아우터 입장에서 아우터의 멤버변수와 같은 위치에 선언해서
 * 
 * -아우터 클래스에서 이너 클래스의 객체에 접근
 * -> Inner i = new Inner(); 객체 생성해서 i.메서드(); 이렇게 사용
 * 
 * - 이너 클래스에서 아우터 클래스 객체 가져다 쓰려면 
 * -> 그냥 바로 가져다 씀
 *
 */
public class MemberInner {  // 아우터 클래스
	// 멤버변수
	int a = 10;
	private int b = 100;
	static int c = 200;

	class Inner { // 이너 클래스 정의
		public void printData() {
			System.out.println("int a : " + a);
			System.out.println("private int b : " + b); // 주시하자!
			System.out.println("static int c : " + c);
		}
	}

	public static void main(String[] args) {
		// MemberInner outer = new MemberInner();
		// MemberInner.Inner inner = outer.new Inner();
		MemberInner.Inner inner = new MemberInner().new Inner();
		inner.printData();
	}
}