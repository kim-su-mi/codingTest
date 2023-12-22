package sumi.java.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
/**
 * (기초평가 문제 - 5. 배열 테스트 14번 문제)
 * 주민등록번호 문제 풀기
 */

public class JuminTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 = ");
		String name = br.readLine();
		
		int[] jumin = new int[13];
		System.out.print("주민번호 =");
		for(int i=0; i<jumin.length; i++) {
			jumin[i] = System.in.read() - 48;
		} // end for
		System.in.read(); System.in.read(); // 엔터값 처리 
//		String imsiJumin = br.readLine();
//		if(imsiJumin.length() != 13) {
//			System.err.println("주민번호 입력오류");
//			System.exit(0);
//		}
//		for(int i=0; i<imsiJumin.length(); i++) {
//			jumin[i] = imsiJumin.charAt(i) - 48;
//		}
//		//확인코드
//		System.out.println(name);
//		for(int i =0; i<jumin.length; i++)
//			System.out.println("jumin["+i+"]="+jumin[i]);
		float hap = 0; float temp = 0; float total = 0;
		float cre = 2.f;
		for(int i = 0; i<jumin.length-1; i++) {
			if(cre == 10.f) cre = 2.f;
			hap += jumin[i] *cre;
			cre++;
		}
		
		temp = 11.0f *(int)(hap/11.0f)+11.0f-hap;
		total = temp - 10.0f*(int)(temp/10.0f);
		if(jumin[jumin.length-1] != total) {
			System.err.println("올바른 주민번호가 아닙니다.");
			return;
		}
		// 요기까지 오면 정상적인 주민번호라는 뜻
		System.out.println();
		System.out.println(name + "님의 개인정보 분석 결과");
		int year = 1900;
		switch(jumin[6]) {
		case 3:
		case 4: year = 2000; break;
		case 9:
		case 0: year = 1800; break;
		default : year = 1900; break;
		}
		year = year + jumin[0]*10 + jumin[1];
		int mon = jumin[2]*10 + jumin[3];
		int day = jumin[4]*10 + jumin[5];
		System.out.println("생년월일 :" + year +"년" + mon + "월" + day + "일생");
		
		System.out.println("나이 = "+ (Calendar.getInstance().get(Calendar.YEAR) - year) + "세");
		
		System.out.println("성별 : " + (jumin[6]%2==0?"여성":"남성"));
		
		switch(jumin[7]) {
		case 0 : System.out.println("출생지역 : 서울"); break;
		case 1 : System.out.println("출생지역 : 경기"); break;
		case 2 : System.out.println("출생지역 : 강원"); break;
		case 3 : System.out.println("출생지역 : 충북"); break;
		case 4 : System.out.println("출생지역 : 충남"); break;
		case 5 : System.out.println("출생지역 : 전북"); break;
		case 6 : System.out.println("출생지역 : 전남"); break;
		case 7 : System.out.println("출생지역 : 경북"); break;
		case 8 : System.out.println("출생지역 : 경남"); break;
		case 9 : System.out.println("출생지역 : 제주"); break;
		}
	}

}
