package sumi.java.exam08;
/**
 * 
 *
 */
public class ArrayEx8 {

	public static void main(String[] args) {
		String[] str = {"JAVA","HTML","JSP","Spring"}; // 한번 배열 크기 정하면 늘리거나 줄일 수 없음
		
		String[] subject = new String[6];
		subject[0] = "Linux";
		subject[1] = "Oracle";
		
		// str에 있는 4과목을 subject배열의 2번방 부터 붙여넣고 싶음
		System.arraycopy(str, 0, subject, 2, 4);
		
		for(int i=0; i<subject.length; i++ ) {
			System.out.println("subject[" + i + "] = " + subject[i]);
		}

	}

}
