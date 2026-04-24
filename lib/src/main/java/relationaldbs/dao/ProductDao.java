package relationaldbs.dao;

import java.util.List;
import relationaldbs.model.Product;

/**
 * Interface that defines the functionalities to interact with the database for
 * product related operations
 *
 * @author Justo 10 abr 2026
 */

public interface ProductDao {

	/**
	 * Inserts a product object into the database.
	 *
	 * @param product The product object to be inserted.
	 * @return true if inserted successfully, otherwise false.
	 */
	public boolean insert(Product product);

	/**
	 * Deletes a product by its id.
	 *
	 * @param id The id of the product to delete.
	 * @return true if deleted successfully, otherwise false.
	 */
	public boolean delete(long id);

	/**
	 * Updates an existing product in the database.
	 *
	 * @param product The updated product object.
	 */
	public void update(Product product);

	/**
	 * Finds a product by its id.
	 *
	 * @param id The id of the product to find.
	 * @return The found product, or null if not found.
	 */
	public Product find(long id);

	/**
	 * Finds a product by its name.
	 *
	 * @param name The name of the product to find.
	 * @return The found product, or null if not found.
	 */
	public Product findByName(String name);

	/**
	 * Retrieves all products from the database.
	 *
	 * @return A list of all products.
	 */
	public List<Product> findAll();

}
