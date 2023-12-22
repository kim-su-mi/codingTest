package sumi.java.exam06;
/**
 * 
 * 가변길이 배열
 *
 */
public class ArrayEx6 {

	public static void main(String[] args) {
		int[][] x = new int[3][];
		x[0] = new int[2];
		x[1] = new int[1];
		x[2] = new int[3];
		
		x[0][0] = 100;
		x[0][1] = 200;
		
		x[1][0] = 300;
		
		x[2][0] = 400;
		x[2][1] = 500;
		x[2][2] = 600;
		
		for(int i=0; i<x.length; i++ ) {
			for(int j=0; j<x[i].length; j++) {
				System.out.print("x[" + i +"][" + j + "] = " + x[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
