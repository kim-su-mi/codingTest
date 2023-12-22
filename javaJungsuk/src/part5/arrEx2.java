package part5;

import java.util.Arrays;

/**
 * 배열의 최대값과 최솟값 구하기
 * @author sumi
 *
 */
public class arrEx2 {
	public static void main(String[] args) {
		int[] num = new int[10];
		
		
		
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random()*100)+1;
		}
		
		int max = num[0];
		int min = num[0];
		
		System.out.println("랜덤으로 생성된 배열 : " + Arrays.toString(num));
		
		for(int i=0; i<num.length; i++) {
			if(num[i]>max) {
				max = num[i];
			}else if (num[i]<min) {
				min = num[i];
			}
		}
		System.out.println("최솟값: " + min);
		System.out.println("최댓값: " + max);
		
		
		
	}
	

}
