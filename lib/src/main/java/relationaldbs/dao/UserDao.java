package relationaldbs.dao;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import relationaldbs.model.User;

public interface UserDao {

	/**
	 * Inserts a new user into the database.
	 * 
	 * @param user
	 * @return true if the user was successfully inserted, false otherwise.
	 */

	public boolean insert(User user);
	
	String insertSQL = "insert into users values (10, 'Manolo'," + " 12343', 1, 234.3), (20, 'Alejandro', '123', 1, 234.3)";
	
	return false;

	/**
	 * Deletes a user from the database by its id.
	 * 
	 * @param id
	 * @return true if the user was successfully deleted, false otherwise.
	 */

	public boolean delete(Long id);

	/**
	 * update a user data from the database.
	 * 
	 * @param id
	 * @return the user with the specified id, or null if no such user exists.
	 */

	public User update(User user);

	/**
	 * Finds a user in the database by its id.
	 * 
	 * @param id
	 * @return the user with the specified id, or null if no such user exists.
	 */

	public User findById(Long id);

	/**
	 * Finds a user in the database by its email.
	 * 
	 * @param email
	 * @return the user with the specified email, or null if no such user exists.
	 */

	public User findByEmail(String email);

	public List<User> findAll();

}
