package sumi.java.exam12;

public class SystemEx {
	public static void main(String args[]) {
		long startLoopTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			for (int j = 0; j < 100; j++) {
				int k = i * j;
			}
		}
		long ttime = System.currentTimeMillis() - startLoopTime;
		System.out.println(" 소요시간=" + ttime + "m sec");
		/*
		 * System.in.read() : 1byte입력
		 * System.in.read(byte[]) : 배열로 입력
		 * System.in.read(byte[], int start, int length)
		 * 
		 */
		byte buffer[] = new byte[255];
		System.out.println("\nType a line of text: ");
		try {
			System.in.read(buffer, 0, 255);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(new String(buffer)); // byte[] -> String
		// String -> byte[] : str.getByte() = 스트링을 바이트 배열로 변환
	}
}