package sumi.java.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * (기초평가 문제 - 5. 배열 테스트 13번 문제)
 * 가위바위보 게임 풀이
 */
public class RockGame {

	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = 1000;
		int menu = -1;
		boolean isStop = false;
		
		String[] message = {"주먹","가위","보자기"};
		int[][] game = {{0,1,-1},{-1,0,1},{1,-1,0}}; // 이차원 배열
		
		while(! isStop) {
			System.out.println("1. 주먹");
			System.out.println("2. 가위");
			System.out.println("3. 보자기");
			System.out.println("0. 게임 종료");
			System.out.print("메뉴선택 : ");
			
			try {
				menu = Integer.parseInt(br.readLine());
			}catch(NumberFormatException nfe) {
				menu = -1;
			}
			
			if(menu == 0) {
				System.out.println();
				System.out.print("정말로 종료 하시겠습니까? (y/n) : ");
				char result = (char) System.in.read();
				System.in.read(); System.in.read();
				if(result == 'Y' || result == 'y') {
					System.out.println("게임을 종료 합니다");
					isStop = true;
				}
				System.out.println();
				continue;
			}
			
			if(menu != 1 && menu!=2 && menu != 3) {
				System.err.println("메뉴 입력 오류 : 메뉴를 확인하시고 다시 입력해 주세요\n");
			}
			
			System.out.println();
			System.out.print("배팅 금액 = ");
			int batting = Integer.parseInt(br.readLine());
			
			if(batting >= money) {
				System.out.println("\n 가진 돈보다 많이 거셨네여 올인으로 처리합니다\n");
				batting = money;
			}else if(batting <=0) {
				System.out.println("\n최소 배팅 금액은 100원 입니다.\n");
				if(money<100) {
					batting = money;
				}else {
					batting = 100;
				}
			
			}
			
			System.out.println();
			System.out.print("결과를 보려면 Enter를 치세요.^^");
			System.in.read(); System.in.read(); 
			
			int computer = (int)(Math.random()*3); // 0이 주먹, 1이 가위, 2보자기
			
			System.out.print("Computer : " + message[computer] + ", ");
			System.out.println("You : " + message[menu-1]);
			
			if(game[menu-1][computer]  == 0) { //비김
				System.out.println("Draw!!!");
			}else if (game[menu-1][computer]  == 1) { //이김
				System.out.println("You Win!!!");
				money += batting;
			}else if (game[menu-1][computer]  == -1) { //짐
				System.out.println("You Loose!!!");
				money -= batting;
			}
			System.out.println("잔액 : " + money);
			
			if(money>=5000) {
				System.out.println();
				System.out.println("지나친 도박은 건강에 해로워요 강제 종료합니다");
				isStop = true;
			}else if (money<=0) {
				System.out.println();
				System.out.println("돈을 다 잃었네요 다음에 다시 오세요");
				isStop = true;
			}
		}// end while
	}

}
