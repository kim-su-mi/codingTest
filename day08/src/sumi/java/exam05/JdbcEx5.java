package sumi.java.exam05;
/**
 * 동적쿼리
 * insert예제
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sumi.java.common.ConnUtil;


public class JdbcEx5 {
	public static void main(String[] args) {
		//preparedStatement를 사용하는 경우
		// sql쿼리에서 실제값으로 대체될 부분을 ?로 처리한다. //?는 db에서 sql실행시에 실제값으로 대체된다. 
		StringBuffer sql = new StringBuffer();
		sql.append("insert into professor ");
		sql.append("values(?, ?, ?, ?, ?, sysdate, ?, ?)");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			// PreparedStatement 객체 얻기
			pstmt = con.prepareStatement(sql.toString());  // 괄호안에 원래 쿼리가 들어가야하느데 sql에 쿼리 저장해둬서 저거 씀
			// 파라미터 셋팅
			// 쿼리의 ?(바인딩 변수)에 대체될 실제값 지정하기
			pstmt.setInt(1, 9920);
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "gildong");
			pstmt.setString(4, "전임교수");
			pstmt.setInt(5, 450);
			pstmt.setInt(6, 40);
			pstmt.setInt(7, 203);
			// 쿼리 실행
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개의 행이 추가되었습니다.");
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