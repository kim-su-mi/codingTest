package sumi.java.exam03;
/**
 * 디비에 데이터 삭제
 */
import java.sql.*;

public class JdbcEx3 { // delete 예제
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete department ");
		sql.append("where dname = '전자계산학과' ");
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sumi", "sumi");
			stmt = con.createStatement();
//update문
			int i = stmt.executeUpdate(sql.toString());
			System.out.println(i + " 개의 행이 삭제되었습니다.");
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
