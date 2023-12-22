package sumi.java.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * (기초평가 문제 - 3. 자바 프로그램 연산자 표준 입출력 테스트)
 */
public class InputEx {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 = ");
		String name = br.readLine();
		System.out.print("사는 곳 = ");
		String address = br.readLine();
		System.out.print("나이 = ");
		Integer age = Integer.valueOf(br.readLine());
		
		System.out.println(name +"님" + age + "세 이군요" + address + "에 사는 군요.");
	}

}
