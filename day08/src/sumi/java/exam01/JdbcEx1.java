package sumi.java.exam01;
/**
 * 디비에 데이터 삽입
 */
import java.sql.*;

public class JdbcEx1 { // insert 예제
	public static void main(String[] ar) {
		Connection con = null;
		Statement stmt = null;
		try {
			//jdbc 드라이브 메모리에 로드하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection 객체 얻기
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sumi", "sumi");
			//Statement 객체 얻기
			stmt = con.createStatement();
			//SQL 작성하기
			StringBuffer sql = new StringBuffer();
			sql.append("insert into department ");
			sql.append("values (203, '제어계측공학과', 200, '7호관')");
			//쿼리 실행시키기
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result + " 개의 행이 추가되었습니다");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 사용한 자원 반납 처리
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
