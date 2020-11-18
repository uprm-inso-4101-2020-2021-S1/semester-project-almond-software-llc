package com.macademia.main;

import java.util.ArrayList;
import java.util.List;

/*
 * Contains information for a Course
 * @author Kurcell
 */
public class Course {

	// -[Fields]----------------------------------------------

	private String name;
	private String dept;
	private String code;
	private String courseCode;
	private String Color;
	private int credits;
	private List<Course> prereq;
	private List<Course> coreq;
	private final List<Section> sections;

	// -[Constructor]-----------------------------------------

	public Course(String name, Department dept, String code, int credits) {
		this(name, dept, code, credits, null, null);
	}

	public Course(String name, Department dept, String code, int credits, List<Course> prereq, List<Course> coreq) {
		this.name = name;
		this.dept = dept.getShortName();
		this.code = code;
		this.courseCode = dept.getShortName() + code;
		this.credits = credits;
		if (prereq == null) {this.prereq = new ArrayList<Course>();} else {this.prereq = prereq;} // If there isn't a specified list, create the list
		if (coreq == null) {this.coreq = new ArrayList<Course>();} else {this.coreq = coreq;}
		this.sections = new ArrayList<Section>(); // Create the list for later.

		// Link this course's department to this course
		dept.AddCourse(this);
		
		//Pass down color from Department
		this.Color=dept.GetColor();
	}

	// -[Getters]---------------------------------------------

	public String getName() {return name;}
	
	/**
	 * Gets the Department ShortName of this course
	 * @return IE INSO
	 */
	public String getDept() {return dept;}
	
	/**
	 * Gets the number portion of the course code
	 * @return IE 3101
	 */
	public String getCode() {return code;}
	
	/**
	 * Gets the Course Code of this course.
	 * @return IE ININ4101
	 */
	public String getCourseCode() {return courseCode;}
	public int getCredits() {return credits;}
	public List<Course> getPrereq() {return prereq;}
	public List<Course> getCoreq() {return prereq;}
	public List<Section> getSections() {return sections;}
	public String getColor() {return Color;}

	// -[Setters]---------------------------------------------

	public void setName(String name) {this.name = name; UpdateSections();}
	public void setDept(Department dept) {this.dept = dept.getShortName(); UpdateSections();}
	public void setDept(String dept) {this.dept=dept; UpdateSections();}
	public void setCode(String code) {this.code = code; UpdateSections();}
	public void setCourseCode(String courseCode) {this.courseCode = courseCode; UpdateSections();}
	public void setCredits(int credits) {this.credits = credits; UpdateSections();}
	public void setPrereq(List<Course> prereq) {this.prereq = prereq;}
	public void setCoreq(List<Course> coreq) {this.coreq = coreq;}

	/**
	 * Sets this Course's department color. THIS SHOULD ONLY BE RUN FROM THE DEPARTMENT CLASS.
	 * @param Color
	 */
	public void setColor(String Color) {this.Color=Color; UpdateSections();}
	
	// -[Methods]--------------------------------------------

	public void addPrereq(Course course) {this.prereq.add(course);}
	public void addCoreq(Course course) {this.coreq.add(course);}
	public void addSection(Section sect) {this.sections.add(sect);}

	/**
	 * Updates info in each section of this course
	 */
	private void UpdateSections() {for (Section section : sections) {section.UpdateCourseInfo(this);}}
	
	/**
	 * Determines whether this course is equal to the provided object
	 * @return TRUE if and only if the object is not null, if the object is an instance of Course, and if the Course Code is the same.
	 */
	public boolean equals(Object obj) {
		if(obj==null) {return false;}
		if(obj instanceof Course) {
			Course otherCourse = (Course) obj;
			return otherCourse.courseCode.contentEquals(courseCode);
		}
		return false;
	}
	
	/**
	 * Returns a displayable string for this course
	 * 
	 * @return CourseName (DeptShortNameCourseCode) Credits Credit(s) (IE "Acting 1
	 *         (DRAM3001) 3 Credit(s)")
	 */
	public String toString() {return getName() + " (" + getDept() + getCode() + ") " + getCredits() + " Credit(s)";}

}
