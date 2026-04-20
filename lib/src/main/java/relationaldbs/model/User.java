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
	private int age;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getRole() {
		return role;
	}

	public int getAge() {
		return age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// construtors
	public User(long id, String name, String password, double balance, String email, String phone, String address,
			String role, int age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.age = age;
		

	}

	public User(int i, Object object, Object object2, Object object3, Object object4, int j, Object object5,
			Object object6) {
		// TODO Auto-generated constructor stub
	}
}
