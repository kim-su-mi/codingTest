package sumi.java.exam01;
/**
 * 1차원 배열(8.22)
 *
 */
public class ArrayEx1 {

	public static void main(String[] args) {
		// 1차원 배열 선언
		int[] x; // 배열 선언
		x = new int[3]; // 배열의 생성(초기화) => new하면 자동 초기화 값0이 들어감
		x[0] = 100; // 값의 할당
		x[1] = 200;
		x[2] = 300;
		
		
		for(int i=0; i<x.length; i++)
			System.out.println("x[" + i +"] = " + x[i]);
		
		// 향상된 for문 - 속도 빠름 , 몇번째 도는지 일일히 체크해야함
		for(int value : x)
			System.out.println("value = " + value);
		
	}

}
