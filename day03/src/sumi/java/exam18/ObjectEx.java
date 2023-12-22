package sumi.java.exam18;
/**
 * 
 * Object클래스
 *
 */

public class ObjectEx {
	private String name;
	private int price;

	public ObjectEx(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public static void main(String[] args) {
		ObjectEx test1 = new ObjectEx("1", 1);
		ObjectEx test2 = new ObjectEx("1", 1);
		System.out.println("test1은? " + test1);
		System.out.println("test2은? " + test2);
		System.out.println("test1의 해시코드는? " + test1.hashCode());
		System.out.println("test2의 해시코드는? " + test2.hashCode());
		System.out.println("test1과 test2는 같은가? " + test1.equals(test2));
	}
}
