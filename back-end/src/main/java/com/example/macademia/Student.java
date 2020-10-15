package com.example.macademia;

<<<<<<< HEAD:back-end/src/main/java/com/example/macademia/Student.java
import com.example.macademia.auth.User;
=======
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import macademia.auth.User;
>>>>>>> a6d432a52aaa037b17cd865ea9e8f718fe5de21d:back-end/macademia/Student.java

/**
 * Class that holds a student, which contains: - Matricula Object - Name -
 * Department - Student Number
 * 
 * @author igtampe
 */
public class Student extends User {

	// -[Variables]----------------------------------------------------------------------

	private Matricula matricula;
	private Department department;
	private String Name;
	private String StudentNumber;
	private List<Matricula> matriculas;
	private List<Course> priorities;

	// -[Constructors]----------------------------------------------------------------------

	/**
	 * Turns a User into a Student by retrieving their student details from the
	 * database.
	 * 
	 * @param user
	 */
	public Student(User user) {
		super(user);

		// TODO: Get Details from Database

		// Get details from this user from the database
		// GetDetailsFromDatabase(this.getUsername()); or something like this.
	}

	/**
	 * Creates a student object with the following details.
	 * 
	 * @param user          User object
	 * @param Name          Name of the student
	 * @param StudentNumber Student number of the student
	 * @param matricula     Matricula of this student
	 * @param Department    Department of this student
	 */
	public Student(User user, String Name, String StudentNumber, Matricula matricula, Department Department) {
		super(user);

		this.Name = Name;
		this.StudentNumber = StudentNumber;
		this.department = Department;
		this.matricula = matricula;
		this.matriculas = new ArrayList<Matricula>();
		this.priorities = new ArrayList<Course>();

	}

	// -[Getters]----------------------------------------------------------------------

	/**
	 * Gets this student's Student Number (ID)
	 * 
	 * @return
	 */
	public String getStudentNumber() {
		return StudentNumber;
	}

	/**
	 * Gets this student's Name (Not Username)
	 * 
	 * @return
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Gets this student's department.
	 * 
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Gets this student's Matricula
	 * 
	 * @return
	 */
	public Matricula getMatricula() {
		return matricula;
	}

	// -[Check-Up]----------------------------------------------------------------------

	public void addCourse(Course e) throws IOException {
		if ((verifyPrereqs(e) || e.getPrereq().isEmpty()) && (verifyCoreqs(e) || e.getCoreq().isEmpty())) {
			this.matricula.addCourse(e);
		} else {
			throw new IOException("Course pre-requisites not met.");
		}
	}

	public void addMatricula(Matricula e) {
		this.matricula = e;
		matriculas.add(0, e);
	}

	public Matricula createMatricula(String p) {
		List<Course> l = new ArrayList<Course>();
		Matricula m = new Matricula(l, p);
		return m;
	}

	public boolean verifyPrereqs(Course e) {
		int counter = 0;
		for (int i = 1; i < matriculas.size(); i++) {
			for (int j = 0; j < e.getPrereq().size(); j++) {
				if (matriculas.get(i).getCourses().contains(e.getPrereq().get(j))) {
					counter++;
				}
			}
		}
		return counter == e.getPrereq().size();
	}

	public boolean verifyCoreqs(Course e) {
		int counter = 0;
		for (int i = 0; i < matriculas.size(); i++) {
			for (int j = 0; j < e.getCoreq().size(); j++) {
				if (matriculas.get(i).getCourses().contains(e.getCoreq().get(j))) {
					counter++;
				}
			}
		}
		return counter == e.getCoreq().size();
	}

	public void addPriority(Course e) {
		priorities.add(e);
	}

	public Course removePriority(int i) {
		return priorities.remove(i);
	}

	public void swapPriority(int i, int j) {
		Course temp = priorities.get(i);
		priorities.set(i, priorities.get(j));
		priorities.set(j, temp);
	}

	// -[Overrides]----------------------------------------------------------------------

	/**
	 * Returns this student as a displayable string
	 * 
	 * @return NAME (STUDENT_NUMBER)
	 */
	public String toString() {
		return Name + " (" + StudentNumber + ")";
	}

	/**
	 * Checks if an object is equal to this student
	 * 
	 * @param obj
	 * @return True if and only if the object is not null, is an instance of
	 *         student, and has the same student ID
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Student) {
			Student OtherStudent = (Student) obj;
			return OtherStudent.StudentNumber == StudentNumber;
		}
		return false;
	}

}
