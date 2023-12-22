package sumi.java.exam06;

interface Inter1 {
	public int getA();
}

interface Inter2 {
	public int getA();
}

interface Inter3 extends Inter1, Inter2 {  // 인터페이스 다중 상속
	public int getData();
}

public class InterEx2 implements Inter3 {
	int a = 100;

	public int getA() {  // 상속해서 여기서 오버라이딩
		return a;
	}

	public int getData() {
		return a + 10;
	}

	public static void main(String[] args) {
		InterEx2 it = new InterEx2();
		Inter1 it1 = it;
		Inter2 it2 = it;
		Inter3 it3 = it;
		System.out.println(it1.getA());
		System.out.println(it2.getA());
		System.out.println(it3.getData());
	}
}
