package relationaldbs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest {
	// The direction of the database that we are going to connect
	private static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres?";

	private static String username = "postgres";
	private static String password = "admin";

	public static void main(String[] args) {

		try {
			// Obtain a object class "Connection" Which represents a connection with a
			// specific database
			Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
			System.out.println("the address of the connection object is " + conn);
			// Create a new database
			// The following SQL statement is used to send the SQL statement to the database

			// table creation sql
			String createTableSQL = "create table if not exists users(" + "id integer not null,"
					+ "usenname VARCHAR(255), " + "psw VARCHAR(255)," + "isVIP SMALLINT(1)," + "balance FLOAT,"
					+ "PRIMARY KEY (id)" + ")";

			PreparedStatement ps = conn.prepareStatement(createTableSQL);
			ps.executeUpdate();

			// insert sql

			String insertSQL = "insert into users values (10, 'Manolo',"
					+ " 12343', 1, 234.3), (20, 'Alejandro', '123', 1, 234.3)";

			ps = conn.prepareStatement(insertSQL);

			// ps.executeupdate() is used to execute SQL statements that change the database
			// such as CREATE, INSERT, UPDATE, DELETE statements
			ps.executeUpdate();
			ps.close();

			// delete sal

			// select psw, isVIP from users where username = 'Manolo' ;
			String selectSQL = "select * from users where username = 'Manolo'";
			ps = conn.prepareStatement(selectSQL);
			System.out.println(ps.executeUpdate());
			//

			ps.close();

			try (ResultSet rs = ps.getResultSet();) {
				if (rs.next()) {
					System.out.println(rs.getString("username"));
					System.out.println(rs.getString("psw"));
					System.out.println(rs.getBoolean("isVIP"));
				}
			}
			createDatabase(conn);
			// eliminate the user table
			String dropTableSQL = "DROP TABLE users";
			PreparedStatement ps1 = conn.prepareStatement(dropTableSQL);
			ps1.executeUpdate();
			ps.close();

			deleteByName(ps, conn, "Manolo");
			deleteByName(ps, conn, "Alejandro");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// We use the "next()" to check if we have reached the end of the result set
	// //If we receive true, then there is more data //rs.next();
	// We can use a series of "getXXXX" methods to access each column of L/each row
	// of data if(rs-next()) 0
	private static void deleteByName(PreparedStatement ps, Connection conn, String name) throws SQLException {
		String deleteSQL = "DELETE FROM users WHERE username = " + name;
		ps = conn.prepareStatement(deleteSQL);
		System.out.println(ps.executeUpdate());
		ps.close();
	}

	// select psw, is VIP from users where username = 'Manolo' ;

	private static int getString(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void createDatabase(Connection conn) {

		try {
			String dbCreationSQL = "CREATE DATABASE happylearning";
			// This one is for postgress sql
			// "CREATE DATABASE happylearning";
			PreparedStatement ps = conn.prepareStatement(dbCreationSQL);

			// ps.executeupdate() is used to execute SQL statements that change the database
			// such as CREATE, INSERT, UPDATE, DELETE statements
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}