package sumi.java.exam16;
/**
 * 
 * 자바 자료 - 7강 상속 참고
 *
 */
public class MP3Phone extends CellPhone {  // MP3Phone은 CellPhone상속 받음
	int size; // 저장 용량 -> 생기면서 MP3Phone이 됌

	public MP3Phone(String model, String num, int chord, int size) {
		this.model = model;  // 부모 클래스의 model물려받아서 나한테 없어도 쓸 수 있음
		number = num;
		this.chord = chord;
		this.size = size; // 코딩 추가하면 부모 클래스의 기능뿐만아니라 추가 기능도 쓸 수 있음 
						  // => 확장이 개념
	}

}
