package sumi.java.exam11;

public class RuntimeEx {
	public static void main(String args[]) {
		Runtime rt = Runtime.getRuntime();
		long fr = rt.freeMemory();
		System.out.println("freeMemory=" + fr / 1024 + "KB");
		long fr2 = rt.totalMemory();
		System.out.println("totalMemory =" + fr2 / 1024 + "KB");
		try {
			// 외부파일 - 계산기 실행
//			rt.exec("C:\\windows\\system32\\calc.exe");
			// 인터넷 익스플로러로 네이버 실행
			rt.exec("C:\\Program Files\\Internet Explorer\\iexplore" + "www.naver.com");

		} catch (Exception e) {

			System.out.println(e.toString());

		}
	}
}