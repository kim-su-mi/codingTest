package sumi.java.exam02;
/**
 * 7강 - 상속과 다형성 참고
 * Animal 클래스 상속받은 자식 클래스
 *
 */
public class Dog extends Animal {
	private String name;

	public Dog() {
		name = getClass().getSimpleName();
	}

	public String scream() {
		return "멍멍깨깽";
	}

	public String getName() {
		return name;
	}
	

}
