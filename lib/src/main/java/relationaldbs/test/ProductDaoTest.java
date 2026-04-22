package relationaldbs.test;

import relationaldbs.dao.ProductDaoImpl;
import relationaldbs.model.Product;

public class ProductDaoTest {

	public static void main(String[] args) {
		ProductDaoImpl dao = new ProductDaoImpl();
		
		// Insert
		Product product = new Product(1, "Laptop", "High-performance laptop", 999.99, "Electronics", 10, "Computers", 4);
		dao.insert(product);
		
		// Find
		Product found = dao.find(1);
		System.out.println("Find: " + (found != null ? found.getName() : "Not found"));
		
		// Update
		Product updated = new Product(1, "Laptop Pro", "High-performance laptop", 1199.99, "Electronics", 8, "Computers", 5);
		dao.update(updated);
		System.out.println("Updated");
		
		// Find All
		System.out.println("Total products: " + dao.findAll().size());
		
		// Delete 
		dao.delete(1);
		System.out.println("Deleted");
	}

}
