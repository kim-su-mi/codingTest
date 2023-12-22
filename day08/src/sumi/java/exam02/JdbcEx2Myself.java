package sumi.java.exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx2Myself {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update department ");
		sql.append("set dname = '국제통상학과',loc = '경상관' ");
		sql.append("where dname = '중어중문' ");
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sumi", "sumi");
			stmt = con.createStatement();
			
			int i = stmt.executeUpdate(sql.toString());   // SteringBuffer 객체에 저장된 문자열을 String타입으로 변경
			System.out.println(i+"개의 행이 업데이트 되었습니다.");
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
