package sumi.java.exam05;

public class ExceptionEx4 {
	public static void main(String args[]) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);

// ArithmeticException을 발생시킨다.

			System.out.println(0 / 0);
			System.out.println(4); // 실행되지 않는다.
		} catch (ArithmeticException ae) {
			System.out.println(5);
		} // try-catch의 끝
		System.out.println(6);
	}// main메서드의 끝
}