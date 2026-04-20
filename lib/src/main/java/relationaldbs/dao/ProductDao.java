package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import relationaldbs.model.User;

/**
 * 
 * @author Justo 10 abr 2026
 * 
 */

public class ProductDao implements UserDao {

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin";

	public boolean insert(User user) {
		String sql = "INSERT INTO users(name, password, isVIP, balance) VALUES(?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, false);
			ps.setDouble(4, user.getBalance());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(long id) {
		
		


		return false;

	}

	public void update(User user) {


	}

	public User find(long id) {


		return null;

	}

	public User findByEmail(String emal) {


		return null;

	}

	public List<User> findAll() {


		return null;

	}

}