package part4;

public class ForEx {
	public static void main(String[] args) {
		
	for(int i=1, j=10; i<= 10; i++, j--) {
				System.out.println("i: "+i+"/ j: "+j);
			}
	
	// 초기화,조건식, 증감식 모두 생략가능
	for(; ; ) { //=for(true)라고 쓴거랑 똑같음
				System.out.println("무한 반복");
			}

	}

}
