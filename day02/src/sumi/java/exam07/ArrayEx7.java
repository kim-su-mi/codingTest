package sumi.java.exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가변길이 배열 종합예제
 * 성적표 - 여러사람에 대한, 과목명과 응시과목 수 에 대해 자유도를 부여
 * 실행: java ArrayEx7 사람수
 * ex) java ArrayEx7 3 
 * 		1번 학생: 국영수/ 2번학생: 음악,미술 / 3번쨰 학생 : 체육
 */
public class ArrayEx7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int human = Integer.parseInt(args[0]); // args배열 String이니까 int로 바꿔주고 /args배열의 0번째 자리: 사람수
		String[] name = new String[human];
		String[][] subject = new String[human][]; // 가변길이
		int[][] jumsu = new int[human][]; // 가변길이
		float[] avg = new float[human];
		char[] grade = new char[human];
		int[] rank = new int[human];
		
		for(int i=0; i<human; i++) {
			System.out.print(i + 1+ "번 학생이름 = ");
			name[i] = br.readLine();
			
			System.out.println();
			System.out.print(name[i] + "학생의 응시과목수 = ");
			int num = Integer.parseInt(br.readLine());
			subject[i] = new String[num];
			// 과목수 = num = subject[i].length
			for(int j=0; j<subject[i].length; j++ ) {
				System.out.print(j + 1+ "번째 응시과목명 = ");
				subject[i][j] = br.readLine();
			}
			
			System.out.println();
			System.out.println(name[i] + "번 학생의 과목별 점수 출력");
			
			jumsu[i] = new int[subject[i].length +1]; // +1 총점공간
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(subject[i][j] + "점수 = ");
				jumsu[i][j] = Integer.parseInt(br.readLine());
				jumsu[i][jumsu[i].length-1] += jumsu[i][j]; // 총점게산
			}
			
			//평균
			avg[i] = jumsu[i][jumsu[i].length-1] / (float)subject[i].length;
			// 평균을 소숫점 3째 자리에서 반올림해서 소숫점 둘째 자리까지 나오게 실제 평균 값 변경 -> 원리 설명은 8.22노트 필기 참고
			avg[i] = (int)((avg[i] + 0.005)*100) / 100.f;
			
			// 등급
			switch((int)avg[i] / 10) {
			case 10:
			case 9: grade[i] = 'A'; break;
			case 8: grade[i] = 'B'; break;
			case 7: grade[i] = 'C'; break;
			case 6: grade[i] = 'D'; break;
			default : grade[i] = 'F'; break;
			}
			
			System.out.println();
		}// end for i
		
		// 등수계산
		for(int i=0; i<human; i++) {
			rank[i]++;
			for(int j=0; j<human; j++) {
				if(avg[i] < avg[j]) rank[i]++;
			}
		}
		System.out.println();
		for(int i=0; i<human; i++) {
			System.out.print("----------------------------");
			System.out.print("성적표");
			System.out.println("----------------------------");
			
			System.out.print("이름\t");
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(subject[i][j]+"\t");
			}
			System.out.println("총점\t평균\t학점\t등수");
			
			
			System.out.print(name[i] + "\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
				}
			System.out.println(avg[i] + "\t" + grade[i] + "\t" + rank[i]);
			System.out.println();
		}

	}

}
