package sumi.java.exam09;
/**
 * 클래스 생성 (8.22)
 *
 */
public class Sample {
	// 멤버필드
	private int x;  // private붙여서 멤버필드에 접근 못하게 은닉화
	int y;
	
	//생성자
	// 기본 생성자 - public Sample(){}
	
	// 메서드
	public int getX() {         // 메서드로 접근할 수 있게 캡슐화
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * ## 접근 제한자
	 * private - 클래스 내부에서만
	 * default(=안쓰면) - 클래스 내부 + 같은 패키지
	 * protected - 클래스 내부 + 같은 패키지 + 상속관계
	 * public - 누구나
	 */

}
