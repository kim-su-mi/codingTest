package sumi.java.cms;

import java.io.Serializable;

public class Customer implements Serializable {  // 추가
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
		return "Customer [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + "]";
	}
	
	// source - generate getter setter해서 생성
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
