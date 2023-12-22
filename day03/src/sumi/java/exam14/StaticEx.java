package sumi.java.exam14;

public class StaticEx {
	private int x;
	private static int y;
	
	// static초기화 구문
	static {y = 10;}
	
	public StaticEx() {	x=10; y= 5;}
	
	
	
	public int getX() {return x;}



	public static int getY() {return y;}

	public void aaa() { y = x+10;}

	public static void main(String[] args) {
//		System.out.println("x =" + x);  // private으로 선언해 못씀
		System.out.println("y =" + StaticEx.y);
		System.out.println("y =" + y);
		StaticEx se = new StaticEx();
		System.out.println("x = " + se.getX());
		System.out.println("y = " + se.getY());
		se.aaa();   // 예외적으로 클래스의 멤버 메서드일 경우 허용
		System.out.println("y = " + y);
		System.out.println("y = " + StaticEx.y);
	}

}
