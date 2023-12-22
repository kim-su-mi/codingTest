package sumi.java.exam23;

public class Account {
	// 멤버필드
	private String name; // 계좌주인
	private long balance; // 잔액
	
	// 생성자
	Account() {
	}
	
	// 생성자 오버로딩
	Account(String name) {
		this.name = name;
	}
	
	// 메서드
	public String getName() {
		return name;
	}

	public long getBalance() {
		return balance;
	}
	
	public void deposit(long amount) { // 입금
		balance += amount;
	}

	public void withdraw(long amount) { //출금
		if (balance < amount)
			System.out.println("잔고가 부족합니다");
		else
			balance -= amount;
	}

}
