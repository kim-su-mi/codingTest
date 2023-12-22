package sumi.java.exam13;

class StaticEx {
	int x;
	static int y;
}

public class StaticExTest {
	public static void main(String[] ar) {
//		System.out.println(StaticEx.x); // Error (객체를 발생시켜야 함)
		System.out.println(StaticEx.y); // 0 출력
		StaticEx.y = 100;
		System.out.println(StaticEx.y); // 100 출력
		StaticEx se = new StaticEx(); // x = 0 , y = 0
		System.out.println(se.x); // 0 출력
		System.out.println(se.y); // 100 출력
	}
}