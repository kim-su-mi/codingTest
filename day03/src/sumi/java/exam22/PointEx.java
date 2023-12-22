package sumi.java.exam22;

public class PointEx {
	private int x;
	private int y;

	public PointEx() {
	}

	public PointEx(int x) {
		this.x = x;
	}

	public PointEx(int x, int y) {
		this(x);
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void disp() {
		System.out.println("x value is " + x);
		System.out.println("y value is " + y);
	}

}
