package sumi.java.exam08;
/**
 * 자바 자료 - 10강 알아두면 유용한 클래스 참고
 * Calender 클래스 
 */
import java.util.Calendar;
import static java.lang.System.out;

public class CalendarEx {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("1 년중 ");
		Calendar now = Calendar.getInstance();   // new안하고 getInstance()통해 객체 생성
		int week_yy = now.get(Calendar.WEEK_OF_YEAR);
		int yy = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH) + 1; // 1월이 0을 기억한다.
		int dd = now.get(Calendar.DAY_OF_MONTH);
		sb.append(week_yy);
		sb.append("주째인 ");
		sb.append(yy);
		sb.append("년 ");
		sb.append(mm);
		sb.append("월 ");
		sb.append(dd);
		sb.append("일");
		out.println(sb.toString()); // 위 문장 더이상 바뀌지 않을거니까 String으로 바꿈
	}
}
