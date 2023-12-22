package sumi.java.exam11;
/**
 * 
 * 생성자 오버로딩
 *
 */

public class MyClass {
	//멤버필드
	private String name;
	private int age;
	
	//기본 생성자
	public MyClass() {
		name = "무명";
	}
	
	// 지정 생성자
	public MyClass(String n) {
		name = n;
	}

	public MyClass(int a, String n) {
		age = a;
		name = n;
	}

	public MyClass(String n, int a) {
		age = a;
		name = n;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
