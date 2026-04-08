package relationaldbs.model;

public class User {

	// fields
	private long id;
	private String name;
	private String password;
	private double balance;
	private String email;
	private String phone;
	private String address;
	private String role;
	private String age;
	

	// methods
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public double getBalance() {
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
	}

	// construtors
	public User(long id, String name, String password, double balance, String email, String phone, String address, String role, String age ) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.balance = balance;

	}
}
