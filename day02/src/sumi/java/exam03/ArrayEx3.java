package sumi.java.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * 성적표 -  한사람에 대해서, 단 응시과목에 대해서 자유도를 부여
 * 			 사용자가 시험 볼 과목을 알아서 고름
 * 실행 : java ArrayEx3 과목1 과목2 ... 과목N
 * @throws IOException 
 */
public class ArrayEx3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("학생이름 = ");
		String name = br.readLine();
		
		String[] subject = new String[args.length]; // 과목명
		// 과목수 = subject.length = args.length -> args는 메인에 있는 거라 안건들이는게 좋음 그래서 subject.length로 올김
		//  args.length만큼 과목 수이며 배열의 크기를 정함
		// 과목수 = subject.length = args.length
		// args는 건들지 않는 것이 좋으므로 subject[]에 담음
		for(int i=0; i<subject.length; i++) {
			subject[i] = args[i]; // 과목명을 옮기기
		}
		
		int[] jumsu = new int[subject.length + 1];  // +1은 총점 공간/ 총점도 점수이므로 배열에 합침 
		for(int i=0; i<subject.length; i++ ) {
			System.out.print(subject[i]+"점수 = ");
			jumsu[i] = Integer.parseInt(br.readLine());
			jumsu[jumsu.length - 1] += jumsu[i]; // 총점 계산 - 점수의 마지막 방번호(jumsu.length - 1)에 i번째 점수 게속 더해서 쌓음
		}
		
		// 평균
		float avg = jumsu[jumsu.length-1] / (float)subject.length;
		// 평균을 소숫점 3째 자리에서 반올림해서 소숫점 둘째 자리까지 나오게 실제 평균 값 변경 -> 원리 설명은 8.22노트 필기 참고
		avg = (int)((avg + 0.005)*100) / 100.f;
		
		//등급
		char grade = 0;
		switch((int)avg / 10) {
		case 10:
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default : grade = 'F'; break;
		
		// 출력	
		}
		System.out.print("-----------------------");
		System.out.print("성적표");
		System.out.println("-----------------------");
		
		System.out.print("이름\t");
		for(int i=0; i<subject.length; i++) {
			System.out.print(subject[i]+"\t");
		}
		System.out.println("총점\t평균\t학점");
		
		System.out.print(name + "\t");
		for(int i=0; i<jumsu.length; i++) {
			System.out.print(jumsu[i]+"\t");
		}
		System.out.println(avg + "\t" + grade);
		
		
		
 	}

}
