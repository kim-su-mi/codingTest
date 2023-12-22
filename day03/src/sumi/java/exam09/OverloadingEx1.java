package sumi.java.exam09;
/**
 * 
 * 메서드 오버로딩을 사용하지 않은 예제
 * intLength/floatLength/stringLength 모두입력한 값의 길이를 구해주는 기능인데 입력값의 자료형에 따라 이름이 다 다름
 * -> 이러면 외워야할 메서드 이름이 많아져서 불편 
 */
public class OverloadingEx1 {
	public void intLength(int a){
		String s = String.valueOf(a);
		System.out.println("입력한 값의 길이 : "+s.length());
	}
	public void floatLength(float f){
		String s = String.valueOf(f);
		System.out.println("입력한 값의 길이 : "+s.length());
	}
	public void stringLength(String str){
		System.out.println("입력한 값의 길이 : "+str.length());
	}

	public static void main(String[] args) {
		OverloadingEx1 oe1 = new OverloadingEx1();
		oe1.intLength(1000);
		oe1.floatLength(3.14f);
		oe1.stringLength("10000");
		

	}

}
