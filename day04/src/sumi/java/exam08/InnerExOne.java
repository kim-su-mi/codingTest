package sumi.java.exam08;
/**
 * 
 * 자바 자료 - 9강 이너 클래스 참고
 *
 */

class OuterEx {  // 컴파일시 Outer.Ex.class로 저장
	public class InnerEx { // 컴파일시 OuterEx$InnerEx.class로 
		int x = 5;
	}
}

public class InnerExOne {  // 컴파일시 InnerExOne.class
	public static void main(String ar[]) {
		//외부클래스 먼저 생성하고. 
		OuterEx eo = new OuterEx();
		//외부를 통해서 내부클래스를 생성한다. 
		OuterEx.InnerEx ei = eo.new InnerEx(); // => 바깥 거쳐서 안으로 접근해야함
		System.out.println("ei.x = " + ei.x);
	}
}
