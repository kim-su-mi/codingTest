package sumi.java.exam08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sumi.java.common.ConnUtil;

public class JdbcEx8 {
	public static void main(String[] args) {
	//transaction : 논리적인 작업단위
	//insert, delete, update등의 작업들을 하나의 논리적인 작업단위로
	//묶어서 쿼리실행시 모든 작업이 정상처리된경우에는 commit을
	//실행해서 db에 반영하고, 쿼리실행중 하나라도 정상처리되지 않은 경우
	//rollback을 실행해서 작업단위내의 모든 작업을 취소한다. 
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into department ");
		sql1.append("values(?,?,?,?) ");
		StringBuffer sql2 = new StringBuffer();
		sql2.append("update department ");
		sql2.append("set dname = ?, loc = ? ");
		sql2.append("where deptno = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//////////// transaction 시작 ////////////////////
			//하나의 논리적인 작업단위 시작
						con = ConnUtil.getConnection();
			//autoCommit기능 비활성화 시키기
						con.setAutoCommit(false);
			//-------------- 1번 작업 시작 --------------------//
			pstmt = con.prepareStatement(sql1.toString());
			pstmt.setInt(1, 255);
			pstmt.setString(2, "핵물리학과");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "9호관");
			pstmt.executeUpdate();
			//-------------- 1번 작업 종료 --------------------//
			//-------------- 2번 작업 시작 --------------------//
			pstmt = con.prepareStatement(sql2.toString());
			pstmt.setString(1, "생명공학과");
			pstmt.setString(2, "8호관");
			pstmt.setInt(3, 255);
			pstmt.executeUpdate();
			//-------------- 2번 작업 종료 --------------------//
			//쿼리가 정상적으로 실행된 경우 db에 반영
			con.commit();
			System.out.println("db에 반영됨..........");
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("db 반영이 취소됨.........");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
			///////////////// transaction 종료 /////////////////////
		}
	}
}