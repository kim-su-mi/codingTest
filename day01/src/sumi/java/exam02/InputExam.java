package sumi.java.exam02;

import java.io.IOException;

/**
 * (기초평가 문제 - 3. 자바 프로그램 연산자 표준 입출력 테스트 20번문제)
 * 삼각형의 넓이를 구하는 예제
 *
 */
public class InputExam {
	public static void main(String[] args) throws IOException {
		System.out.print("밑변 = ");
		int width = System.in.read() - 48;  // 5넣고 엔터치면 \r \n이라서
		System.in.read(); System.in.read(); // 엔터값\r \n 처리
		
		System.out.print("높이 = ");
		int height = System.in.read() - '0';
		System.out.println("넓이 = " + (width * height / 2.f));
	}
}
