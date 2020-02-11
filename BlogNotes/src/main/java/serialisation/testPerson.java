package serialisation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class testPerson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("/Users/mac/eclipse/eclipse-workspace/AlgorithmeSource/person.txt");

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
		Person person = new Person(3, "abc", "mdp", "paris");
		objectOutputStream.writeObject(person);
		objectOutputStream.close();

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		Object readObject = objectInputStream.readObject();
		objectInputStream.close();

		Person newPerson = (Person) readObject;
		System.out.println(person == newPerson); // Person [age=3, name=abc]
		System.out.println(newPerson);

//		File file = new File("/Users/mac/eclipse/eclipse-workspace/AlgorithmeSource/transientperson.txt");
//		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//
//		TransientPerson person = new TransientPerson(3, "abc", 123);
//		objectOutputStream.writeObject(person);
//		objectOutputStream.close();
//
//		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
//		Object readObject = objectInputStream.readObject();
//		objectInputStream.close();
//
//		TransientPerson newPerson = (TransientPerson) readObject;
//		System.out.println(person == newPerson); // Person [age=3, name=abc, money = 123]
//		System.out.println(newPerson);
	}
}
