package serialisation;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientPerson implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient Integer age;
	private transient String name;
	private transient Integer money;

	public TransientPerson(Integer age, String name, Integer money) {
		super();
		this.age = age;
		this.name = name;
		this.money = money;
	}

	private void readObject(ObjectInputStream stream) throws Exception {
		stream.defaultReadObject();
		this.age = (Integer) stream.readObject();
		this.money = (Integer) stream.readObject();
		this.name = (String) stream.readObject();
	}

	private void writeObject(ObjectOutputStream stream) throws Exception {
		stream.defaultWriteObject();
		stream.writeObject(this.age);
		stream.writeObject(this.money);
		stream.writeObject(this.name);
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

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "TransientPerson [age=" + age + ", name=" + name + ", money=" + money + "]";
	}

}
