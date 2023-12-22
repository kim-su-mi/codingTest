package sumi.java.exam12;

public class ThisEx1 {
	public static void main(String[] args) {
		ThisEx ref = new ThisEx();
//		ThisEx ref = new ThisEx("홍길동","1234");  => 생성자 오버로딩 해둬서 이렇게 생성도 가능
//		ThisEx ref = new ThisEx("홍길동","1234","1234-1234");
		System.out.println("Name : " + ref.getName());
		System.out.println("TEL : " + ref.getTel());
		System.out.println("Jumin : " + ref.getJumin());
		

	}

}
