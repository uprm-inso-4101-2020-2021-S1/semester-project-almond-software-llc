package com.macademia.main;

import com.macademia.main.auth.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		this.matriculas.add(0, this.matricula);
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

	public void addSections(Section e, Course f) throws IOException {
		if ((verifyPrereqs(f) || f.getPrereq().isEmpty()) && (verifyCoreqs(f) || f.getCoreq().isEmpty())) {
			this.matricula.addSections(e, f);
		} else {
			throw new IOException("Course pre-requisites not met.");
		}
	}

	public void addMatricula(Matricula e) {
		this.matricula = e;
		matriculas.add(0, e);
	}

	public Matricula createMatricula(MatriculaPeriod p) {
		Matricula m = new Matricula(p);
		return m;
	}

	public boolean verifyPrereqs(Course e) {
		int counter = 0;
		for (int i = 1; i < matriculas.size(); i++) {
			for (int j = 0; j < e.getPrereq().size(); j++) {
				if (matriculas.get(i).getCoursesTaken().contains(e.getPrereq().get(j))) {
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
				if (matriculas.get(i).getCoursesTaken().contains(e.getCoreq().get(j))) {
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

	//Makes a giant list with all the courses ever taken
	public List<Course> getAllCoursesTaken() {
		List<Course> listOcourses = new ArrayList<Course>();
		for (Matricula m : this.matriculas) {
			for (Course c : m.getCoursesTaken()) {
				listOcourses.add(c);
			}
		}
		return listOcourses;
	}

	public void turn() {
		int count = 0;
		List<Course> allCourses = getAllCoursesTaken();
		for (Course c : this.matricula.getCoursesTaken()) {
			for (Course prq : c.getPrereq()) {
				if (allCourses.contains(prq)) continue;
				else {
					count++;
					this.matricula.getCoursesTaken().remove(c);
					break;
				}
			}
		}
		for (Course c : this.matricula.getCoursesTaken()) {
			for (Course corq : c.getCoreq()) {
				if (allCourses.contains(corq) || this.matricula.getCoursesTaken().contains(corq)) continue;
				else {
					count++;
					this.matricula.getCoursesTaken().remove(c);
					break;
				}
			}
		}

		//Updates the section list by removing the sections with the courses removed on the CoursesTaken List
		for (Section s : this.matricula.getSections()) {
			if (this.matricula.getCoursesTaken().contains(s.getCourse())) continue;
			else this.matricula.getSections().remove(s);
		}

		//Removes it from matricula if its full
		for (Section s : this.matricula.getSections()) {
			if (s.isFull()) {
				this.matricula.removeSections(s);
				count++;
			}
		}

		//Removes the last added class that conflicts with an earlier class of the same time.
		for (int i = 0; i < this.matricula.getSections().size(); i++) {
			for (int j = i + 1; j < this.matricula.getSections().size(); j++) {
				if (this.matricula.getSections().get(i).getTime() == this.matricula.getSections().get(j).getTime()) {
					if (i > j) {
						this.matricula.removeSections(this.matricula.getSections().get(i));
						this.matricula.getCoursesTaken().remove(this.matricula.getSections().get(i).getCourse());
						count++;
					}
					if (j > i) {
						this.matricula.removeSections(this.matricula.getSections().get(j));
						this.matricula.getCoursesTaken().remove(this.matricula.getSections().get(i).getCourse());
						count++;
					}
				}
				else {
					continue;
				}
			}
		}
		while (count > 0 || !this.priorities.isEmpty()) {
			this.matricula.getCoursesTaken().add(this.priorities.remove(0));
			count--;
		}

		




	}

}
