package sumi.java.exam01;

/**
 * (기초평가 문제 - 3. 자바 프로그램 연산자 표준 입출력 테스트)
 * System.in.read() : 아스키 코드값으로 입력을 받는다
 * (char)System.in.read(); : 문자 한글자를 입력받는다
 * System.in.read() - 48 (또는 '0') 숫자 한글자를 입력받는다/ 아스키 코드 48은 숫자0
 */

import java.io.IOException;

public class InputTest {
	public static void main(String[] args) throws IOException {
		
		// A입력하면 A의 아스키 코드가 출력됌
		System.out.println("단자리 입력 테스트 : ");
		int number = System.in.read();
		System.out.println("입력 내용 = " + number);
		
		// char로 형변환 하면 문자 출력
		System.out.println("단자리 입력 테스트 : ");
		char number1 = (char)System.in.read();
		System.out.println("입력 내용 = " + number1);
		
		// 숫자 그대로 출력
		System.out.println("단자리 입력 테스트 : ");
		int number2 = System.in.read() - '0';
		System.out.println("입력 내용 = " + number2);
		
	}

}
