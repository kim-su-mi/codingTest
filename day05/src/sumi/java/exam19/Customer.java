package sumi.java.exam19;

public class Customer {
	// 멤버필드
	private String name;
	private int age;
	private String phone;
	private String address;
	
	
	// 생성자
	// ctrl + space 엔터치면 바로 생성
	public Customer() {
	}
	
	// source - generator constractor using fields
	public Customer(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	
	// 메서드
	@Override
	// source - generate toString해서 생성
	public String toString() {
		return " 이름: " + name + ", 나이:" + age + ", 전화:" + phone + ", 주소:" + address;
	}
	
	// source - generate getter setter해서 생성
	// 멤버변수가 private로 선언되어 있어 직접 접근 불가능해서 get,set메서드로 접근
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
