package test01;

import java.util.Arrays;

public class test03 {
	public static void main(String[] args) {
		// 배열 선언 생성 초기화 한번에  
		int[] iArr = {100,95,80,70,60}; // 길이가 5인 int배열 생성및 초기화
		 
		// 배열의 출력
		// 1) 배열의 이름으로 배열의 모든 값 출력 불가
		System.out.println(iArr);
		
		// 2) for문 돌려서 배열의 모든 값 출력
		for(int i=0; i<iArr.length; i++) {
			 System.out.println("iArr[" + i +"] = " + iArr[i]);
		}	 
		// 3) Arrays.toString메서드 활용
		System.out.println(Arrays.toString(iArr));  
	}//main
}
