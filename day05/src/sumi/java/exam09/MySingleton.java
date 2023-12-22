package sumi.java.exam09;
/**
 * 
 * 자바 자료 -10강 알아두면 좋은 클래스 참고 
 * Singleton패턴
 *
 */
public class MySingleton {
	//멤버필드
	private static MySingleton instance;
	//생성자
	private MySingleton(){  // 생성자에 private해서 외부에서 new못함
		
	}
	//메서드
	public static MySingleton getInstance(){
		if(instance == null) {
			synchronized(MySingleton.class) {  // synchronized - 외부에서 못들어오게 클래스 문 잠금
				instance = new MySingleton();
			}
		}
		return instance;
		
	}

}
