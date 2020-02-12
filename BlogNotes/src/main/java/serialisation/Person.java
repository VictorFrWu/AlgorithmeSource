package serialisation;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer age;
	private String name;
	private transient String pwd;
	private String address; // 新添加的属性

	public Person(Integer age, String name, String pwd, String address) {
		super();
		this.age = age;
		this.name = name;
		this.pwd = pwd;
		this.address = address;
	}

	private void readObject(ObjectInputStream s) throws Exception {
		s.defaultReadObject();
		this.pwd = (String) s.readObject();
	}

	private void writeObject(ObjectOutputStream s) throws Exception {
		s.defaultWriteObject();
		this.pwd = "pwd";
		s.writeObject(this.pwd);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", pwd=" + pwd + ", address=" + address + "]";
	}

}