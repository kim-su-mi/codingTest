package sumi.java.exam08;

public class ExceptionEx7 {
	int[] ss;

	public ExceptionEx7() {
		ss = new int[3];// 속성(멤버필드) 초기화
	}

	public void program() {
		for (int i = 0; i <= ss.length; i++) {
			System.out.println("for문의 시작 " + i + "번째");
			try {
				System.out.println(ss[i]);
			} catch (Exception e) {
				System.out.println("toString() : " + e.toString());
				System.out.println("printStackTrace() : "); e.printStackTrace();
				System.out.println("getMessage() : " + e.getMessage());
				System.err.println("예외 발생 : code 1005");
				return;
			} finally {
				System.out.println("finally 영역");
			}
			System.out.println("for문의 끝" + i + "번째");
		}
	}

	public static void main(String[] args) {
		ExceptionEx7 ref = new ExceptionEx7();
		ref.program();
		System.out.println("프로그램 끝!");
	}
}
