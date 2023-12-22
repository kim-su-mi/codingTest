package sumi.java.exam04;

public class ArrayEx4 {
/**
 * 2차원 배열
 * 
 */
	public static void main(String[] args) {
		int[][] x; // int[] x[]; = int x[][]; 배열의 선언
		x = new int[2][3]; // 배열의 생성(초기화) => int[][] x = new int[2][3]
		x[0][0] = 100; // 값의 할당 ==> int[][]x = {{100,200,300},{400,500,600}};
		x[0][1] = 200;
		x[0][2] = 300;
		x[1][0] = 400;
		x[1][1] = 500;
		x[1][2] = 600;
		
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<x[i].length; j++) {
				System.out.print("x[" + i + "][" + j + "] = " + x[i][j] + "\t");
			}
			System.out.println();
		}
	

	}

}
