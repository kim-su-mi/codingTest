package sumi.java.exam00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {
		// 2번 드라이버 로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공");
		}catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
		}
		
		// 3번 : 데이터 베이스 연결
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","sumi","sumi");
			System.out.println("데이터 베이스 연결 성공");
		}catch (SQLException sqle) {
			System.err.println("데이터 베이스 연결 실패");
		}
		
		//4,5단계
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
//			// 정적 쿼리
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from mytable");
			
			//동적쿼리
			Scanner scan = new Scanner(System.in);
			System.out.println("몇살 이상 검색 = ");
			int inputAge = scan.nextInt();
			
			pstmt = conn.prepareStatement("select * from mytable where age > ?");
//			pstmt.setInt(1,20); // 1번쨰 물음표에 20 넣음
			pstmt.setInt(1,inputAge); // 사용자한테 받은 나이 입력
			rs = pstmt.executeQuery();
			
			// 쿼리결과 화면에 출력
			// 화면에 출력안하면 쿼리한 결과는 rs에 담겨있기만함
			while(rs.next()) {  // 다음줄에 맨 앞으로 가서 데이터 있으면 트루 없으면 펄스
				int num = rs.getInt(1); //첫번쨰 줄 첫번쨰 컬럼값 가져옴 / 두번째 컬럼으로 커서 옮겨감
				String name = rs.getString(2);
				int age = rs.getInt("age"); // 필드명 바로주면 그 필드명에 있는 값 가져옴
				String address = rs.getString("address");
				java.sql.Date date = rs.getDate("birth"); // sql의 Date라 자바에서 날짜 계산 못함
				java.util.Date d = new java.util.Date(date.getTime()); // sql의 DAte를 자바의 데이트로 변환 = 자바에서 날짜 계산 가능
				System.out.println(num+"\t"+name +"\t"+age+"\t"+address+"\t" +
								date.toString() +"\t" + d.toString());
			}
			
		}catch (SQLException sqle) {
			System.err.println("쿼리문이 오류일 가능성이 높다");
			sqle.printStackTrace();
		}finally { // 6단계
			try { if(rs!=null) rs.close();}catch (SQLException sqle) {}
//			try { if(stmt!=null) stmt.close();}catch (SQLException sqle) {}
			try { if(pstmt!=null) pstmt.close();}catch (SQLException sqle) {}
			try { if(conn!=null) conn.close();}catch (SQLException sqle) {}
		}
		
		
	}// main

}
