package part4;

public class SwitchEx1 {
	public static void main(String[] args) {
		// 퀴즈 1: 1~10사이의 난수를 20개 출력하시오
		for (int i=1; i<=20; i++) {
			System.out.println((int)(Math.random()*10)+1);
		}
		
		// 퀴즈 2 : -5~5사이의 난수를 20개 출력하시오
				for (int i=1; i<=20; i++) {
					System.out.println((int)(Math.random()*11)-5);
				}
	}

}
