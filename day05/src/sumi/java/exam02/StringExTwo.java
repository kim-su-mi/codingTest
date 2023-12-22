package sumi.java.exam02;
/**
 * 
 * 자바 자료 - 10강 알아두면 유용한 클래스 참고
 * 문자열을 +로 더하면 새로운문자열 객체 생성하고 이전 값과 더한 객체 생성해서 
 * 더해서 새로 생성된 객체말고 그 과정에서 생성된 객체들은 쓸모없는 상태로 메모리에 저장됌
 * -> 문자열을 더할 때는 new로 새로 생성해주는게 좋음
 *
 */
public class StringExTwo {
	public static void main(String[] args) {
		String str = new String();
		str += "Hello";
		str += " Java";
		System.out.println("str의 값은 ? : " + str);
	}
}
