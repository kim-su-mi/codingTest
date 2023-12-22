package sumi.java.exam07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sumi.java.common.ConnUtil;

public class selectMyself {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from professor ");
		sql.append("where name = ? ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, "홍길동");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.print(rs.getInt("profno") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.println(rs.getString("position") + "\t");
				System.out.println(rs.getInt("sal") + "\t");
				System.out.println(rs.getDate("hiredate") + "\t");
				System.out.println(rs.getInt("age") + "\t");
				System.out.println(rs.getInt("deptno") + "\t");
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(SQLException e) {}
			try {if(pstmt!=null) pstmt.close();}catch(SQLException e) {}
			try {if(con!=null) con.close();}catch(SQLException e) {}
		}
	}

}
