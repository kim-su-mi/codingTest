package sumi.java.exam12;

public class OuterEx { // 컴파일시 OuterEx.class 파일 생김
	public static class InnerEx { // 컴파일시 OuterEx$InnerEx.class
		static int x = 10;

		public static void main(String args[]) {
			OuterEx.InnerEx ei = new OuterEx.InnerEx();
			System.out.println("ei.x = " + ei.x);
			System.out.println("ei.x = " + OuterEx.InnerEx.x);
		}
	}
} // 실행하려면 java OuterEx$InnerEx