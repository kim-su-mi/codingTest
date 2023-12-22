package sumi.java.exam11;
/**
 * 
 * 자바 자료 - 9강 이너 클래스 참고
 * static 이너 클래스
 *
 */
public class StaticInner {
	int a = 10;
	private int b = 100;
	static int c = 200;

	static class Inner {
		// 어쩔 수 없이 이너 클래스를 static으로 선언해야 할 경우가 있다. 
		// 그건 바로 이너 클래스의 멤버들 중 하나라도 static멤버가 있을 때이다. 
		static int d = 1000;

		public void printData() {
			// System.out.println("int a : "+a); //오류
			// System.out.println("private int b : "+b); //오류
			// => 오류 나는 이유 : static영역에서는 static변수만 사용할 수 있어서!
			System.out.println("static int c : " + c);
		}
	}

	public static void main(String[] args) {
//또 다른 독립된 객체에서 static 이너 클래스 생성시
		StaticInner.Inner inner = new StaticInner.Inner();
		inner.printData();
	}
}
