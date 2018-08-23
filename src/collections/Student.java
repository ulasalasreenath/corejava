package collections;

public class Student implements Comparable<Student> {

	private int studentId;
	private String firstName;
	private String lastName;
	private int finalMark;
	private String finalGrade;

	/**
	 * getter for Student's Id
	 * @return int
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * setter for Student's Id
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * getter for Student's first name
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setter for Student's first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getter for Student's last name
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setter for Student's last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getter for Student's final mark
	 * @return int
	 */
	public int getFinalMark() {
		return finalMark;
	}

	/**
	 * setter for Student's final mark
	 * @param finalMark
	 */
	public void setFinalMark(int finalMark) {
		this.finalMark = finalMark;
	}

	/**
	 * getter for Student's final grade
	 * @return String
	 */
	public String getFinalGrade() {
		return finalGrade;
	}

	/**
	 * setter for Student's final grade
	 * @param finalGrade
	 */
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

	/**
	 * toString representation of Student
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder sbr = new StringBuilder();
		sbr.append(this.getStudentId()).append(",").append(this.getFirstName()).append(",").append(this.getLastName())
				.append(",").append(this.getFinalMark()).append(",").append(this.getFinalGrade());
		return sbr.toString();
	}

}
