package sumi.java.exam14;

import java.util.*;

class AA {
	int a;

	AA(int a) {
		this.a = a;
	}
}

public class VectorEx {
	public static void main(String[] ar) {
		Vector<AA> vc = new Vector<AA>();  // <AA> : 제네릭을 검
		vc.add(new AA(10));// vc 0 vc 0
		vc.add(new AA(20));// vc 1 vc 2
		vc.add(new AA(30));// vc 2 vc 3
		vc.add(new AA(10));// vc 3 vc 4
		vc.add(new AA(40));// vc 4 vc 5
		vc.add(new AA(50));// vc 5 vc 6
		vc.add(1, new AA(15));// vc 1
		for (int i = 0; i < vc.size(); i++) {
			AA ap =  vc.elementAt(i);  // i번째 거 뽑아라
			System.out.println(ap.a);
		}
		vc.removeElementAt(4);   // 4번방에 있는 데이터 지워라
		for (int i = 0; i < vc.size(); i++) {
			AA ap =  vc.elementAt(i);
			System.out.println("지운후 = " + ap.a);
		}
	}
}