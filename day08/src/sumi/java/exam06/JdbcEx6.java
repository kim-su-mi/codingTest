package sumi.java.exam06;
/**
 * 동적쿼리
 *  update문 예제
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sumi.java.common.ConnUtil;


public class JdbcEx6 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update professor ");
		sql.append("set sal = ? ");
		sql.append("where name = ? ");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 500);
			pstmt.setString(2, "홍길동");
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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