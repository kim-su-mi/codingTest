package part5;
/**
 * 배열의 총합과 평균 구하기
 * @author sumi
 *
 */
public class arrEx1 {
	public static void main(String[] args) {
		int sum = 0;
		float avg = 0.f;
		
		int[] score = {100,88,67,100,90};
		
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		
		avg = sum/(float)score.length;
		
		System.out.println("배열의 총합: " +sum);
		System.out.println("배열의 평균: " + avg);
		
	}

}
