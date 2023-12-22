package sumi.java.exam09;

public class ExceptionEx8 {
	private static void test() throws Exception {
		System.out.println(6 / 0);
	}

	public static void main(String[] args) {
		try {
			test(); // try catch문으로 예외처리 해야함
		} catch (Exception e) {
			System.out.println("예외 발생");
		}
	}
}
