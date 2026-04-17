package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.model.User;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		
		// Create a test user with valid data
		User testUser = new User(0L, "Justo", "password123", 1000.0, "justo@example.com", "555-1234", "123 Main St", "user", 25);
		
		// Insert the user
		boolean success = userDao.insert(testUser);
		
		if (success) {
			System.out.println("Test passed: User inserted successfully!");
		} else {
			System.out.println("Test failed: Could not insert user.");
		}
	}
}
