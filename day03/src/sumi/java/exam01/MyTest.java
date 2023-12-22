package sumi.java.exam01;

class MyClass{ // extends Object
	// String toString()
	
}
public class MyTest {

	public static void main(String[] args) {
		MyClass mc = new MyClass(); // mc객체를 hashcode로 저장
		System.out.println(mc);     // 찍어보면 mc객체 정보 나옴 @뒷자리를 16진수로 변경해보면 hashcode
		System.out.println(mc.hashCode());
		
		MyClass mc1 = new MyClass();
		System.out.println(mc1);

	}

}
