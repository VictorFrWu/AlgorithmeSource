package XMLReader;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private int age;
	private String role;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String gender, int age, String role) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", role=" + role + "]";
	}
}
