package collections;

public class Student implements Comparable<Student> {

	private int studentId;
	private String firstName;
	private String lastName;
	private int finalMark;
	private String finalGrade;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFinalMark() {
		return finalMark;
	}

	public void setFinalMark(int finalMark) {
		this.finalMark = finalMark;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	@Override
	public int compareTo(Student student) {

		if (this.getFinalMark() > student.getFinalMark()) {
			return -1;
		} else if (this.getFinalMark() < student.getFinalMark()) {
			return 1;
		} else {

			if (this.getFirstName().compareTo(student.getFirstName()) == 0) {
				if (this.getLastName().compareTo(student.getLastName()) == 0) {
					if (this.getStudentId() > student.getStudentId()) {
						return 1;
					} else if (this.getStudentId() < student.getStudentId()) {
						return -1;
					} else {
						return 0;
					}
				} else {
					return this.getLastName().compareTo(student.getLastName());
				}
			} else {
				return this.getFirstName().compareTo(student.getFirstName());
			}

		}

	}

	public String toString() {
		StringBuilder sbr = new StringBuilder();
		sbr.append(this.getStudentId()).append(",").append(this.getFirstName()).append(",").append(this.getLastName())
				.append(",").append(this.getFinalMark()).append(",").append(this.getFinalGrade());
		return sbr.toString();
	}

}
