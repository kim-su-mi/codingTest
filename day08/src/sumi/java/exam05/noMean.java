package sumi.java.exam05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sumi.java.common.ConnUtil;

public class noMean {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into professor ");
		sql.append("values (?, ?, ?, ?, ? ,sysdate, ?, ?) ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,2000);
			pstmt.setString(2, "사오정");
			pstmt.setString(3,"sa" );
			pstmt.setString(4, "부교수");
			pstmt.setInt(5, 300);
			pstmt.setInt(6, 20);
			pstmt.setInt(7, 203);
			
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 행이 삽입되었습니다");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null) pstmt.close();}catch(SQLException e) {};
			try {if(con!=null) con.close();}catch(SQLException e) {};
		}
		
	}

}
