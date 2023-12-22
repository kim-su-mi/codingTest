package sumi.java.exam09;
/**
 * 
 * 자바 자료 -10강 알아두면 좋은 클래스 참고 
 * Singleton패턴 테스트
 *
 */
class MyClass {
	
}
public class MyTest {
	public static void main(String[] args) {
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		System.out.println(mc1);
		System.out.println(mc2);
		
		// Singleton은 객체 하나만듬
		MySingleton ms1 = MySingleton.getInstance();
		MySingleton ms2 = MySingleton.getInstance();
		System.out.println(ms1);
		System.out.println(ms2);
		
	}

}
