package sumi.java.exam22;

public class CircleEx extends PointEx {
	private int r;

	public CircleEx() {
	}

	public CircleEx(int x) {
		super(x);
		r = 1;
	}

	public CircleEx(int x, int y) {
		super(x, y);
		r = 2;
	}

	public CircleEx(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getR() {
		return r;
	}

	public void disp() {
		super.disp();
		System.out.println("r value is " + r);
	}

	public static void main(String[] ar) {
		CircleEx ce = new CircleEx();// 생성자를 바꿔보자. 
		ce.disp();
	}

}
