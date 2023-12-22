package sumi.java.exam10;

// 한 클래스에 public은 하나만
class Sample {
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
}	
	
public class SampleEx {
	public static void main(String[] args) {
		Sample sp = new Sample();
		sp.setX(10);
		System.out.println(sp.getX());
	}
}
