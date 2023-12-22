package sumi.java.exam03;

public class StringBufferExOne {
	public static void main(String[] ar) {
		StringBuffer sb = new StringBuffer("JAVA");
		sb.append("1.6");
		System.out.println(sb);
		sb.delete(3, 5);
		System.out.println(sb);
		sb.insert(3, "A1");
		System.out.println(sb);
		sb.replace(4, 7, "일점육");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
	}
}
