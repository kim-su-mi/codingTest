package sumi.java.exam06;
/**
 * StringTokenizer 와 split의 차이점
 * StringTokenizer - 빈 문자열 무시
 * split - 빈 문자열 포함
 */
import java.util.StringTokenizer;

public class StringTokenEx2 {
	public static void main(String[] args) {
		String str = "학교,집,,게임방";
		StringTokenizer tokens = new StringTokenizer(str, ",");
		for (int x = 1; tokens.hasMoreTokens(); x++) {
			System.out.print("문자" + x + " = " + tokens.nextToken() + "\t");
		}
		System.out.println("");
		System.out.println("=============================");
		String[] values = str.split(",");
		for (int x = 0; x < values.length; x++) {
			System.out.print("문자" + (x + 1) + " = " + values[x] + "\t");
		}
		System.out.println("");
	}
}
