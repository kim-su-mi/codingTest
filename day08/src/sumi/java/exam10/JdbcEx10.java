package sumi.java.exam10;
/**
 * Properties - 키값과 value가 모두 String으로 이루어진 특수 MAP
 * Properties File만드는 법 :
 * src우클릭 - File - 파일이름.Properties (확장자를 Properties로 줌)
 * 
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import sumi.java.common.ConnUtil;

public class JdbcEx10 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties pro = new Properties();
		pro.load(new FileInputStream("src/department.properties"));
		//이클립스라면 -> src/department.properties
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			//department.properties에 정의된 sql을 가져와서
			//preparedstatement 만들기
			pstmt = con.prepareStatement(

					pro.getProperty("department_insert"));
			//parameter(바인딩변수에 값 할당하기) 셋팅하기
			pstmt.setInt(1, 100);
			pstmt.setString(2, "산업공학과");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "5호관");
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
