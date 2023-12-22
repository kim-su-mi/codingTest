package _ch02;

public class VarEx2 {

	public static void main(String[] args) {
		int score = 100;
		System.out.println(score);
		
		score = 200;
		System.out.println(score);
		
		// score1이 상수라서 200으로 값 바꾸려고 하니까 에러남
		final int score1 = 100;
//		score1 = 200;
		System.out.println(score1);
		
		boolean power = true;
		System.out.println(power);
		
		// byte타입 이 담을 수 있는 127을 초과해서 오류남
//		byte b = 128;
//		System.out.println(b);
		
		// l은 long타입이고 1000000000은 int타입인데 int를 int보다 큰 long타입에 담으므로 문제 없음
		long l = 1000000000;
		System.out.println(l);
		
		char ch = 'A';
		int i = 'A';
		System.out.println(ch);
		System.out.println(i);
	}

}
