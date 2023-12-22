package sumi.java.exam06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sumi.java.common.ConnUtil;

public class updateMyself {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update professor ");
		sql.append("set age = ? ");
		sql.append("where ename = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1, 50);
			pstmt.setString(2, "son");
		
			
			int i = pstmt.executeUpdate();
			System.out.println(i+"개의 행이 업데이트 되었습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null) pstmt.close();}catch(SQLException e) {}
			try {if(con!=null) con.close();}catch(SQLException e) {}
		}
	}

}
