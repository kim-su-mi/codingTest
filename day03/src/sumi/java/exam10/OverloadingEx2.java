package sumi.java.exam10;
/**
 * 메서드 오버로딩 - 하나의 클래스에서 같은 이름을 가진 메서드가 여러개 정의되는 것
 * 원칙: 매개변수 or 자료형이 다르면 메서드 오버로딩할 수 있다. => 이름이 같아도 인자값이 다름
 *
 */
public class OverloadingEx2 {
	public void getLength(int n){
		String s = String.valueOf(n);
		getLength(s);
	}

	void getLength(float n) {
		String s = String.valueOf(n);
		getLength(s);
	}

	private int getLength(String str) {
		System.out.println("입력한 값의 길이 : " + str.length());
		return 0;
	}

	public static void main(String[] args) {
		OverloadingEx2 oe2 = new OverloadingEx2();
		oe2.getLength(1000);
		oe2.getLength(3.14f);
		oe2.getLength("10000");
		

	}

}
