package sumi.java.exam23;
/**
 * 자바 자료 - 7강 상속 참고
 * Account클래스 상속받아 NewAccount만들고 비밀번호 변경 기능 추가
 *
 */
public class NewAccount extends Account {  
	// 멤버
	private String pass;

	// 생성자
	public NewAccount() {
	}

	public NewAccount(String name, String pass) {
		super(name);
		this.pass = pass;
	}

	// 메소드
	public boolean passCheck(String pass) { //본인확인
		if (pass.equals(this.pass)) {
			return true;
		} else {
			return false;
		}
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

}
