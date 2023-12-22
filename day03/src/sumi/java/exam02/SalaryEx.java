package sumi.java.exam02;
/**
 * 
 * 제6강 객체지향 프로그램 클래스 자료의 Salary예제
 *
 */

class Salary {
	 private int pay;  // 멤버필드 은닉화
	 public int getPay() {
		 return pay;
	 }
	 public void setPay(int pay, String pass) {
		 if(pass.equals("1234"))
			 this.pay = pay;
	 }
}

public class SalaryEx {
	public static void main(String[] args) {
		Salary sal = new Salary();
		 // sal.pay = 10000;                  => 멤버필드를 직접 변경 못함 private로 선언해서
		 // System.out.println("내 계좌를 마음대로 " + sal.pay);
		 sal.setPay(1000,"1234");  // get,set메서드를 통해서 멤버필드에 접근가능
		 int myPay = sal.getPay();
		 System.out.println("계좌에 입금한 금액"+ myPay);
		

	}

}
