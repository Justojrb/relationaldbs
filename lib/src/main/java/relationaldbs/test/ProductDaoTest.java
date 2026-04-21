package relationaldbs.test;

import relationaldbs.dao.ProductDaoImpl;
import relationaldbs.model.User;

public class ProductDaoTest {

	public static void main(String[] args) {
		ProductDaoImpl dao = new ProductDaoImpl();
		
		// Insert
		User user = new User(1, "Juan", "pass123", 1000, "juan@mail.com", "555-1234", "Calle 1", "user", 25);
		dao.insert(user);
		
		// Find
		User found = dao.find(1);
		System.out.println("Find: " + (found != null ? found.getName() : "Not found"));
		
		// Update
		user.setName("Juan Updated");
		dao.update(user);
		System.out.println("Updated");
		
		// Find All
		System.out.println("Total users: " + dao.findAll().size());
		
		// Delete
		dao.delete(1);
		System.out.println("Deleted");
	}

}
