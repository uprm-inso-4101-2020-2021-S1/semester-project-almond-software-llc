package com.macademia.main;

import com.macademia.main.auth.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Class that holds a student, which contains: - Matricula Object - Name -
 * Department - Student Number
 * 
 * @author igtampe
 */
public class Student extends User {

	// -[Variables]----------------------------------------------------------------------

	private Department department;
	private String Name;
	private String StudentNumber;
	private Map<MatriculaPeriod, Matricula> matriculas;
	private List<Course> priorities;
	private List<Course> coursesTaken;

	// -[Constructors]----------------------------------------------------------------------

	/**
	 * Creates a student object with the following details.
	 * 
	 * @param user          User object
	 * @param Name          Name of the student
	 * @param StudentNumber Student number of the student
	 * @param Department    Department of this student
	 */
	public Student(User user, String Name, String StudentNumber, Department Department) {
		super(user);

		this.Name = Name;
		this.StudentNumber = StudentNumber;
		this.department = Department;
		this.matriculas = new Hashtable<MatriculaPeriod,Matricula>(4);
		this.priorities = new ArrayList<Course>();

	}

	// -[Getters]----------------------------------------------------------------------

	/**
	 * Gets this student's Student Number (ID)
	 */
	public String getStudentNumber() {return StudentNumber;}

	/**
	 * Gets this student's Name (Not Username)
	 */
	public String getName() {return Name;}

	/**
	 * Gets this student's department.
	 */
	public Department getDepartment() {return department;}

	/**
	 * Gets this student's Matriculas
	 */
	public Collection<Matricula> getMatriculas() {return matriculas.values();}
	
	/**
	 * Gets this student's matricula for a specified matricula period
	 * @param Mat
	 */
	public Matricula getMatricula(MatriculaPeriod Mat) {return matriculas.get(Mat);}
	
	/**
	 * Gets this student's priority courses
	 * @return
	 */
	public List<Course> getPriority(){return priorities;}

	/**
	 * gets Courses this student has taken
	 * @return
	 */
	public List<Course> getCoursesTaken(){return coursesTaken;}
	
	// -[Check-Up]----------------------------------------------------------------------

	/**
	 * Adds a section to the matricula of the specified period
	 * @param e Section you want to add
	 * @param f Course of the section you wish to add.
	 * @param m Matricula Period of the matricula you wish to add this section to.
	 * @throws IllegalArgumentException if the course prerequesites aren't met, or if the Section doesn't match with the course
	 */
	public void addSections(Section e, Course f, MatriculaPeriod m) throws IOException {
		
		//TODO: VERIFY IF THESE WILL ACTUALLY BE EQUAL
		if(f.getDept()+f.getCode()!=e.getCourseCode()) {throw new IllegalArgumentException("Course doesn't match with section.");}
		
		if ((verifyPrereqs(f) || f.getPrereq().isEmpty()) && (verifyCoreqs(f) || f.getCoreq().isEmpty())) {
			matriculas.get(m).addSections(e);;
			coursesTaken.add(f); 
		} else {throw new IllegalArgumentException("Course pre-requisites not met.");}
	}

	public void addMatricula(Matricula e) {matriculas.put(e.getPeriod(), e);}

	public Matricula createMatricula(MatriculaPeriod p) {
		Matricula m = new Matricula(p);
		return m;
	}

	public boolean verifyPrereqs(Course e) {
		int counter = 0;
		
		for (int j = 0; j < e.getPrereq().size(); j++) {
				if (coursesTaken.contains(e.getPrereq().get(j))) {counter++;}
		}
		return counter == e.getPrereq().size();
	}

	public boolean verifyCoreqs(Course e) {
		int counter = 0;
		for (int j = 0; j < e.getCoreq().size(); j++) {
			if (coursesTaken.contains(e.getCoreq().get(j))) {counter++;}
		}
		return counter == e.getCoreq().size();
	}
	
	public void addCourseTaken(Course e) {coursesTaken.add(e);} 

	public void addPriority(Course e) {priorities.add(e);}

	public Course removePriority(int i) {return priorities.remove(i);}

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
