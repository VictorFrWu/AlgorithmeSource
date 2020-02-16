package AggregationAndComposation;

import java.util.List;

public class Departement {
	private List<Student> students;
	private String name;

	public Departement(String name, List<Student> students) {
		super();
		this.students = students;
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Departement [students=" + students + ", name=" + name + "]";
	}

}
