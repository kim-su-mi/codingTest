package sumi.java.exam06;
/**
 * 자바 자료 - 6강 객체지향 프로그래밍의 메모리 그림 참고
 *
 */
public class ValueParameter {
	public int increase(int n) { //메서드
		++n;
		return n;
	}

	public static void main(String[] args) {
		int var1 = 100;
		ValueParameter vp = new ValueParameter();
		int var2 = vp.increase(var1);
		System.out.println("var1 : " + var1 + ", var2 : " + var2);
		

	}

}
