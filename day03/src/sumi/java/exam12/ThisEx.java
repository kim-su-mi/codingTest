package sumi.java.exam12;
/**
 * 자바 자료 - 6강 객체지향 프로그래밍 참고
 * this는 나 자신 = 내가 가지고 있는 것 : 주소 값 or 변수
 * this() : 현재 객체의 생성자
 * -> 생성자 안에서 오버로딩된 다른 생성자 호출할 경우 this()사용 => 항상 생성자의 맨위에 위치
 *
 */
class ThisEx {
	// 멤버필드
	String name, jumin, tel;
	
	// 생성자
	public ThisEx() {
		this.name = "Guest";
		this.jumin = "000000-0000000";
		tel = "000-0000-0000";
	}

	public ThisEx(String name) {
		this(); // 위의 아무 인자도 안받는 기본 생성자 호출
		this.name = name;
	}

	public ThisEx(String name, String jumin) {
		this(name); // 위의 이름 하나만 인자로 받는 생성자 호출
		this.jumin = jumin;
	}

	public ThisEx(String name, String jumin, String tel) {
		this(name, jumin);
		this.tel = tel;
	}

	public String getJumin() {
		return jumin;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}
	 
		 

}
