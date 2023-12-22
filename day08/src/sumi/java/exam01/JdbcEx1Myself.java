package sumi.java.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1Myself {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into department ");
		sql.append("values (208,'중어중문',150,'북악관')");
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sumi", "sumi");
			stmt = con.createStatement();
			
			int i = stmt.executeUpdate(sql.toString());
			System.out.println(i+"개의 행이 추가 되었습니다.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 사용한 자원 반납 처리
			try {if(stmt!=null) stmt.close();}catch(SQLException e) {}
			try {if(con!=null) con.close();}catch(SQLException e) {}
		}
	}

}
