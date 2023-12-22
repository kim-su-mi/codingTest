package sumi.java.exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * (기초평가 문제 - 5. 배열 테스트 18번 문제)
 * 로또 게임 풀이
 */
public class LottoGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] lotto;
		System.out.println("몇 게임 하실 건가요? : ");
		int number = Integer.parseInt(br.readLine());
		
		lotto = new int[number][6];
		
		for(int game = 0; game<lotto.length; game++ ) {
			for(int col =0; col<lotto[game].length; col++) {
				lotto[game][col] = (int)(Math.random()*45) +1 ; // 1~45, 0,0자리의 숫자 하나 만들어짐
				for(int tCol=0; tCol<col; tCol++) {
					if(lotto[game][col] == lotto[game][tCol]) { // 새로 만들어진 번호가 기존 번호랑 같으면
						col--;
						break;
						
					}
				}
			}// end for col
			// 2번째 줄 비교
			int count = 0;
			
			for(int tGame=0; tGame<game; tGame++) {
				count = 0;
				for(int col=0; col<lotto[game].length; col++) {
					for(int tCol=0; tCol<lotto[tGame].length; tCol++) {
						if(lotto[game][col] == lotto[tGame][tCol]) {
							count++; break;
						}
					}
					if(col+1 != count) break; //같지않으면 뒤에 볼 필요 없음
				}
				if(count == 6) {
					game--;
					break;
				}
			}
		}// end for game
		
		for(int i=0; i<lotto.length; i++ ) {
			System.out.print(i +1+"번째 추첨 번호 : ");
			for(int j=0; j<lotto[i].length; j++) {
				System.out.print(lotto[i][j] + "\t");
			}
			System.out.println();
		}

	}// end main

}
