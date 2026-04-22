package relationaldbs.model;

public class Product {

	// fields
	private long id;

	private String name;

	private String description;

	private double price;

	// methods

	private String category;

	private int stock;

	private String subCategory;

	private int rating;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;

	}
	
	public String setName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String setDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
	public double setPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}
	
	public String setCategory() {
		return category;
	}

	public int getStock() {
		return stock;
	}
	
	public int setStock() {
		return stock;
	}

	public String getSubCategory() {
		return subCategory;
	}
	
	public String setSubCategory() {
		return subCategory;
	}

	public int getRating() {
		return rating;
	
	}
	
	public int setRating() {
		return rating;
	}
	
	public Product(long id, String name, String description, double price, String category, int stock, String subCategory,
			int rating) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.stock = stock;
		this.subCategory = subCategory;
		this.rating = rating;
	}

}
