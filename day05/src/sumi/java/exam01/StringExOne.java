package sumi.java.exam01;
/**
 * 
 * 자바 자료 - 10강 알아두면 유용한 클래스 참고
 *
 */
public class StringExOne {
	public static void main(String[] args) {
		// 암시적 객체 생성 - 같은 값을 연타로 생성하면 
		//					   constant pool에 값 하나 올리고 s1,s2모두 그 주소 가르킴
		// 					 "==" 로 비교하면 주소가 같아서 s1,s2같다고 나옴
		String s1 = "Twinkle";
		String s2 = "Twinkle";
		if (s1 == s2)
			System.out.println("s1과 s2는 같다. ");
		else
			System.out.println("s1과 s2는 같지 않다. ");
		// 명시적 객체 생성 - heap메모리에 Little Star라는 값 각각 생성 = 주소 다름
		// "==" 로 비교하면 주소가 달라서 s1,s2틀리다고 나옴
		// 그래서 == 말고 equals써야함
		String s3 = new String("Little Star");
		String s4 = new String("Little Star");
		if (s3 == s4)
			System.out.println("s3과 s4는 같다. ");
		else
			System.out.println("s3과 s4는 같지 않다. ");
		
		// equals쓰니까 같다고 나옴
		boolean same = s3.equals(s4);
		System.out.println(same);
	}
}
