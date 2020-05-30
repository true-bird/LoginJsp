package login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/assignment_db?serverTimezone=Asia/Seoul";
		String id = "connectuser";
		String password = "connect123!@#";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,id,password);
//		Context context = new InitialContext();
//        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/test");
//        Connection conn = dataSource.getConnection();
		return conn;
	}
}
