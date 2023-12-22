package sumi.java.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 여러 사람에 대한 성적표 - 응시 과목에 대한 자유도 부여
 * 실행 java ArrayEx5 응시한 사람 수 과목1 과목2 ... 과목N
 * EX) java ArrayEx5 4명 국어 영어 수학
 */
public class ArrayEx5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int human = Integer.parseInt(args[0]); //사람수
		String[] name = new String[human];
		String[] subject = new String[args.length-1];
		// 과목수 = subject.length = args.length-1
		
		for(int i=0; i<subject.length; i++)
			subject[i] = args[i+1];
		int[][] jumsu = new int[human][subject.length +1 ]; // +1은 총점 공간
		float[] avg = new float[human];
		char[] grade = new char[human];
		int[] rank = new int[human];
		
		for(int i=0; i<human; i++) {
			System.out.print(i+1+"번째 학생 이름 = ");
			name[i] = br.readLine();
			
			System.out.println();
			System.out.println(name[i] + "학생의 과목별 점수 입력");
			for(int j=0; j<subject.length; j++) {
				System.out.print(subject[j] + "점수 = ");
				jumsu[i][j] = Integer.parseInt(br.readLine());
				jumsu[i][jumsu[i].length-1] += jumsu[i][j]; //총점 계산
			}
			
			//평균
			avg[i] = jumsu[i][jumsu[i].length-1] / (float)subject.length;
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
		}// end for i = human
		
		// 등수계산
		for(int i=0; i<human; i++) {
			rank[i]++;
			for(int j=0; j<human; j++) {
				if(avg[i] < avg[j]) rank[i]++;
			}
		}
		
		System.out.print("----------------------------");
		System.out.print("성적표");
		System.out.println("----------------------------");
		
		System.out.print("이름\t");
		for(int i=0; i<subject.length; i++) {
			System.out.print(subject[i]+"\t");
		}
		System.out.println("총점\t평균\t학점\t등수");
		
		for(int i=0; i<human; i++) {
			System.out.print(name[i] + "\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println(avg[i] + "\t" + grade[i] + "\t" + rank[i]);
		}
	

	}

}
