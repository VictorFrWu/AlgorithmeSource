package AggregationAndComposation;

import java.util.List;

public class Institute {
	private String InstiLogo;
	private List<Departement> dept;

	public Institute(String instiLogo, List<Departement> dept) {
		super();
		InstiLogo = instiLogo;
		this.dept = dept;
	}

	public String getInstiLogo() {
		return InstiLogo;
	}

	public void setInstiLogo(String instiLogo) {
		InstiLogo = instiLogo;
	}

	public List<Departement> getDept() {
		return dept;
	}

	public void setDept(List<Departement> dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Institute [InstiLogo=" + InstiLogo + ", dept=" + dept + "]";
	}

	public int getTotalStudentsInInstitute() {
		if (dept == null || dept.size() == 0) {
			return 0;
		}
		int sum = 0;
		for (Departement d : dept) {
			List<Student> students = d.getStudents();
			sum += students.size();
		}
		return sum;
	}

}
