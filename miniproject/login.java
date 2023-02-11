package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class login {
		private Scanner sc = new Scanner(System.in);
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
		private Connection con = null; // DB Connection
	    private Statement stmt = null; // 동적 SQL 처리
	    private ResultSet rs = null; // SQL ResultSet 반환
	    

		public void insert() throws SQLException {
			String sql = "INSERT INTO STUDENT values(?)";
			con = dbConn.getConnection();
			stmt = con.prepareStatement(sql);
			
			System.out.print("이름 입력 : ");
			String name = sc.next();
			
			stmt.setString(1, name);			
			int result = stmt.executeUpdate(sql);
			
			if(result >= 1) {
				System.out.println("이름입력이 완료되었습니다.");
			} else {
				System.out.println("이름이 입력되지 않았습니다.");
			}
		}
			
		public void delete() throws SQLException {
			System.out.println("삭제할 이름 입력 : ");
			String name = sc.next();
			
			String sql = "delete from student where name='"+name+"'";
			int result = stmt.executeUpdate(sql);
			
			if(result >=1) {
				System.out.println("이름이 삭제되었습니다.");
			} else {
				System.out.println("이름이 삭제되지 않았습니다.");
			}
		}	
	}