package sumi.java.exam10;
/**
 * 
 * 자바 자료 - 9강 이너 클래스 참고
 * 지역 이너 클래스
 * -> 아우터의 특정 메소드 안에서 정의되는 클래스로 
 * 		아우터 클래스의 지역 변수와 같은 위치에 선언돼서 지역 이너 변수
 */
public class LocalInner {
	int a = 100; // 멤버 변수

	public void innerTest(int k) {
		int b = 200; // 지역변수
		final int c = k; // 상수
		class Inner {
			// Local 이너 클래스는 외부클래스의 멤버 변수와
			// 상수들만 접근이 가능하다.
			public void getData() {
				System.out.println("int a : " + a);
				// System.out.println("int b : "+b);
				// Local 이너클래스는 지역변수를 사용할 수 없다. => 7.0이후로 사용가능해짐
				System.out.println("final int c : "+c);//상수 사용
			}
		} // 이너 클래스의 끝
		Inner i = new Inner(); // 메소드 내에서 Local 이너 클래스 생성
		i.getData(); // 생성된 reference를 통해 메소드 호출
	} // 메소드의 끝

	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.innerTest(1000);
	}
}
