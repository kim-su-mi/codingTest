package sumi.java.exam05;
/**
 * (기초평가 문제 - 5. 배열 테스트 17번 문제)
 * 마방진 풀이
 */
import java.io.IOException;

public class MabangJin {

	public static void main(String[] args) throws IOException {
		System.out.print("숫자(홀수만) = ");
		int num = System.in.read() - 48;
		System.in.read(); System.in.read(); // 엔터값
		
		int[][] mabang = new int[num][num];
		int row = 0; int col = num /2;
		
		for(int su=1; su<= num*num; su++) {
			mabang[row][col] = su;
			if(su % num == 0) { // 3x3일 때 4넣을 떄 막힘
				row++; continue;
			}
			row--; col++;
			if(row < 0) row = mabang.length-1;
			if(col > mabang.length-1) col = 0;
			
		}
				
		//결과 출력
		for(int i=0; i<mabang.length; i++) {
			for(int j=0; j<mabang[i].length; j++) {
				System.out.print(mabang[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
