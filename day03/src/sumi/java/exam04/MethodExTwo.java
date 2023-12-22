package sumi.java.exam04;
/**
 * 자바 자료 - 6강 객체지향 프로그래밍
 * Q1.) 메서드는 문법 구조 상 반환값 하나만 받을 수 있음, 여러개 받으려면 어떻게 해야함? 
 * 		-> call by reference써서 주소를 인자값으로 전달받으면 됌 (이클 day3 - exam07참고)
 * 
 */
public class MethodExTwo {
	int var1, var2; // 멤버 변수들
	public int sum(int a, int b){ // 메소드(멤버 함수)
		return a+b;
	}
	public static void main(String[] ar){
		MethodExTwo me = new MethodExTwo();
		int res = me.sum(1000, -10);
		System.out.println("res = " + res);
	}
}
