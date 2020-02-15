package BattleDev11Novembre2019;

interface AnimalService {
	String getName();
}

abstract class Animal implements AnimalService{
	String name;

	Animal(String name) {
		this.name = name;
	}

	public abstract String getName();
}

class Dog extends Animal {

	/**
	 * Creates a new dog with the given name.
	 */
	Dog(String name) {
		super(name);
	}

	public String getName() {
		return name;
	}
}

class Cat extends Animal {
	Cat(String name) {
		super(name);
	}

	public String getName() {
		return name;
	}
}

class Application {

	/**
	 * @return the name of the given​​​​​​‌​​​‌​‌​‌‌​​​​​​‌‌‌‌‌‌‌​​ animal
	 */
	public static void main(String[] args) {
		Animal d = new Dog("dog");
		System.out.println(d.getName());
	}
}
