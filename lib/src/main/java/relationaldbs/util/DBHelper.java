package relationaldbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private final static String mysqlUrl = "jdbc:mysql://localhost:3306/relationaldbs";
	
	public final static String username = "	root";
	
	public final static String password = "admin";
	
	
	public Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(mysqlUrl, username, password);
		
	}

}
