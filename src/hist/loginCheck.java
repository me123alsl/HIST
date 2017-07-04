package hist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginCheck {

	public static void loginIdCheck(String id, String pwd){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "1234";
		
		boolean connect = false;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			connect = true;
			System.out.println("Connect Success!!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select id from member where id = "+id+" and password = "+pwd+"");
			conn.close();
		}
		catch(Exception e){
			connect = false;
			e.printStackTrace();
			System.out.println("Connect fail!!");
		}
		
		
	}
}
