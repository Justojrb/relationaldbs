package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.model.User;

public class ProductDaoImpl implements ProductDao {
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
		String sql = "DELETE FROM users WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void update(User user) {
		String sql = "UPDATE users SET name = ?, password = ?, balance = ?, email = ?, phone = ?, address = ?, role = ?, age = ? WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setDouble(3, user.getBalance());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getRole());
			ps.setInt(8, user.getAge());
			ps.setLong(9, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User find(long id) {
		String sql = "SELECT * FROM users WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, id);
			var rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getLong("id"), rs.getString("name"), rs.getString("password"),
				rs.getDouble("balance"), rs.getString("email"), rs.getString("phone"), rs.getString("address"),
				rs.getString("role"), rs.getInt("age"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findByEmail(String emal) {
		String sql = "SELECT * FROM users WHERE email = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, emal);
			var rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getLong("id"), rs.getString("name"), rs.getString("password"),
				rs.getDouble("balance"), rs.getString("email"), rs.getString("phone"), rs.getString("address"),
				rs.getString("role"), rs.getInt("age"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> users = new java.util.ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getLong("id"), rs.getString("name"), rs.getString("password"),
				rs.getDouble("balance"), rs.getString("email"), rs.getString("phone"), rs.getString("address"),
				rs.getString("role"), rs.getInt("age"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
