package sumi.java.exam01;
/**
 * 7강 - 상속과 다형성 참고
 * 다형성 예시
 * 멤버변수는 부모거 사용 / 오버라이드한 메서드는 자식거 사용
 *
 */
class Super{
	void aaa() { System.out.println("aaa");}
	void bbb() { System.out.println("bbb");}
}

class Sub extends Super{
	@Override
	void aaa() {System.out.println("Override Method");}
	void ccc() {System.out.println("ccc");}
 }
public class PolimorphismTest {
	public static void main(String[] args) {
		Super s = new Sub();  // 다형성
		s.aaa(); // Super타입이지만 자식이 aaa메서드 오버라이드해서 자식 메서드 사용
		s.bbb(); // SUper의 bbb메서드 사용
//		s.ccc(); -> 오류 :  Super타입이라 자식이 가지고 있는 ccc메서드는 오버라이드되지 않아 쓸 수 없음
	}

}
