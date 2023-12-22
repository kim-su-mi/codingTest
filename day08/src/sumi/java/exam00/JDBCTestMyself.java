package sumi.java.exam00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTestMyself {
	public static void main(String[] args) {
		// 2.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
		}
		
		//3.데이터 베이스 연결
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","sumi","sumi");
			System.out.println("데이터 베이스 연결 성공");
		}catch(SQLException sqle) {
			System.err.println("데이터 베이스 연결 실패");
		}
		
		//4,5단계 (정적)쿼리문 작성 및 결과 담기
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("몇 살이상 검색 : ");
			int ans = scan.nextInt(); 
			
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from mytable where name = '손오공'");
			
			
			pstmt = conn.prepareStatement("select * from mytable where age >?");
			pstmt.setInt(1, ans); 
			rs = pstmt.executeQuery();
			
			
			//쿼리 결과 화면 출력
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				java.sql.Date date = rs.getDate("birth");
				java.util.Date d = new java.util.Date(date.getTime());
				
				System.out.println(num + "\t" + name + "\t" + age + "\t" +
								address + "\t" + date + "\t" + d );
			}
			
		} catch (SQLException e) {
			System.err.println("쿼리문이 오류일 가능성이 큽니다.");
			e.printStackTrace();
		} finally {
			try{if(rs != null) rs.close();} catch(SQLException sqle){}; 
//			try{if(stmt != null) stmt.close();} catch(SQLException sqle){}; 
			try{if(pstmt != null) pstmt.close();} catch(SQLException sqle){}; 
			try{if(conn != null) conn.close();} catch(SQLException sqle){}; 
		}
		
		
	} //main

}


