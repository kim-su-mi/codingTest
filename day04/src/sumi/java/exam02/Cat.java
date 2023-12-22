package sumi.java.exam02;
/**
 * 
 * Animal 클래스 상속받은 자식 클래스
 *
 */
public class Cat extends Animal {
	private String name;

	public Cat() {
		name = getClass().getSimpleName();
	}

	public String scream() {
		return "야옹야옹";
	}

	public String getName() {
		return name;
	}

}
