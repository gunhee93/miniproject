package login;
import java.sql.*;

public class dbConn {
	public static Connection getConnection() {
		 Connection con = null; // DB Connection
	     Statement stmt = null; // 동적 SQL 처리
	     ResultSet rs = null; // SQL ResultSet 반환
	     
	     String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    	 String user = "system";
    	 String pwd = "oracle";
	     
	     try {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 System.out.println("등록 성공");
	    	   	 
	     } catch (ClassNotFoundException e) {
	    	 System.out.println("연결 실패, 드라이버 Not Found");
	    	 e.printStackTrace();
	     }
	     try {
	    	 con = DriverManager.getConnection(url, user, pwd);
	     } catch (SQLException e) {
	    	 System.out.println("연결 실패, localhost 오류");
	    	 e.printStackTrace();	    	 
	     }
	     return con;
	    	
	}

}
