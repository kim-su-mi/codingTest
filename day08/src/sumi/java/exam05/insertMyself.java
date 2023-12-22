package sumi.java.exam05;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sumi.java.common.ConnUtil;

public class insertMyself {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into professor ");
		sql.append("values (?, ?, ?, ?, ?, sysdate, ?, ?) ");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1, 1111);
			pstmt.setString(2, "손오공");
			pstmt.setString(3,"son" );
			pstmt.setString(4, "외래교수");
			pstmt.setInt(5, 500);
			pstmt.setInt(6, 30);
			pstmt.setInt(7, 203);
			
			int i = pstmt.executeUpdate();
			System.out.println(i+"개의 행이 삽입되었습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null) pstmt.close();}catch(SQLException e) {}
			try {if(con!=null) con.close();}catch(SQLException e) {}
		}
	}

}
