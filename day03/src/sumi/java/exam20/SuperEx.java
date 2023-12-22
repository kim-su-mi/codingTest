package sumi.java.exam20;

class Super {
	int a = 5;
}

class Sub extends Super {
	int a = 10;

	public void test() {
		System.out.println(this.a);  // 내꺼
		System.out.println(super.a); // 부모
	}
}

public class SuperEx {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.test();
	}

}
