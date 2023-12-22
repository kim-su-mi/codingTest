package sumi.java.exam07;

class AClass {
}

interface CInter {
}

class BClass extends AClass implements CInter {
}

public class ABCEx {
	public static void main(String[] ar) {
		BClass bp = new BClass();
		System.out.println(bp instanceof Object);
		System.out.println(bp instanceof AClass);
		System.out.println(bp instanceof BClass);
		System.out.println(bp instanceof CInter);
	}
}
