package sumi.java.exam03;

public class MethodExOne {
	public static void main(String[] args) {
		MethodEx ref = new MethodEx(); // 객체 생성
		 int i =10;
		 int j =10;
		 System.out.println("더한값 : " + ref.sum(i, j));  // 객체.메서드해서 사용
		 System.out.println("뺀값 : " + ref.sub(i, j));
		 System.out.println("곱한값 : " + ref.multi(i, j));
		 System.out.println("나눈값 : " + ref.divi(i, j));

	}

}
