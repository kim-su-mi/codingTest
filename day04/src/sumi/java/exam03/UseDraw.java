package sumi.java.exam03;

abstract class Diagram {
	abstract void draw();  // 추상 메서드

}

// private를 선언 할 수 없는 이유 :
//자식이 오버라이드 해야 하는데 못하게 된다. // static으로 선언 할 수 없는 이유 :
//객체 없이도 호출이 되는 메소드 이므로 반드시 body가
//정의 되어야 클래스.메서드() 형식으로 호출 할 수 있다. 
class Triangle extends Diagram {
	void draw() {     // 오버라이딩 필수!!!!
		System.out.println("삼각형을 그린다.");
	}
}

class Rectangle extends Diagram {
	void draw() {
		System.out.println("사각형을 그린다.");
	}
}

class Circle extends Diagram {
	void draw() {
		System.out.println("원을 그린다.");
	}
}

public class UseDraw {
	public static void main(String[] args) {
		Diagram[] ref = new Diagram[3];
		ref[0] = new Triangle();
		ref[1] = new Circle();
		ref[2] = new Rectangle();
		for (int i = 0; i < ref.length; i++)
			ref[i].draw();
	}
}