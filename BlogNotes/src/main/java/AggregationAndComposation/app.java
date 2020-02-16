package AggregationAndComposation;

import java.util.ArrayList;
import java.util.List;

public class app {
	public static void main(String[] args) {
		Student s1 = new Student("Mia", 1, "CSE");
		Student s2 = new Student("Priya", 2, "CSE");
		Student s3 = new Student("John", 1, "EE");
		Student s4 = new Student("Rahul", 2, "EE");

		// making a List of
		// CSE Students.
		List<Student> cse_students = new ArrayList<Student>();
		cse_students.add(s1);
		cse_students.add(s2);

		// making a List of
		// EE Students
		List<Student> ee_students = new ArrayList<Student>();
		ee_students.add(s3);
		ee_students.add(s4);

		Departement CSE = new Departement("CSE", cse_students);
		Departement EE = new Departement("EE", ee_students);

		List<Departement> departments = new ArrayList<Departement>();
		departments.add(CSE);
		departments.add(EE);

		Institute institute = new Institute("BITS", departments);

		System.out.print("Total students in institute: ");
		System.out.println(institute.getTotalStudentsInInstitute());

		// Creating the Objects of Book class.
		Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
		Book b2 = new Book("Thinking in Java", "Bruce Eckel");
		Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");

		// Creating the list which contains the
		// no. of books.
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);

		Library library = new Library(books);

		List<Book> bks = library.getTotalBooksInLibrary();
		for (Book bk : bks) {

			System.out.println("Title : " + bk.getTitle() + " and " + " Author : " + bk.getAuthor());
		}

		// making an engine by creating
		// an instance of Engine class.
		Engine engine = new Engine();

		// Making a car with engine.
		// so we are passing a engine
		// instance as an argument while
		// creating instace of Car.
		Car car = new Car(engine);
		car.move();
	}
}
