package sumi.java.exam02;
/**
 * 예외처리 없어서 
 * 10번 돌려야하는데 
 *
 */
public class ExceptionEx1 {
	public static void main(String args[]) {
		int number = 50;
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result = number / (int) (Math.random() * 5);
			System.out.println(result);
		}
	}
}