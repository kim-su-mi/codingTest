package sumi.java.exam06;
/**
 * 동적쿼리
 * delete문
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sumi.java.common.ConnUtil;

public class deleteMyself {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete professor ");
		sql.append("where ename = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, "sa");
		
			
			int i = pstmt.executeUpdate();
			System.out.println(i+"개의 행이 삭제 되었습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(pstmt!=null) pstmt.close();}catch(SQLException e) {}
			try {if(con!=null) con.close();}catch(SQLException e) {}
		}
	}

}
