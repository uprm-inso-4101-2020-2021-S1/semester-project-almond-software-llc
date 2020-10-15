package com.example.macademia;

import java.util.ArrayList;
import java.util.List;

/*
 * Contains information for a Course
 * @author Kurcell
 */

public class Course {

	// -[Fields]----------------------------------------------

	private String name;
	private Department dept;
	private int code;
	private int credits;
	private List<Course> prereq;
	private List<Course> coreq;
	private List<Section> sections;

	// -[Constructor]-----------------------------------------

	public Course(String name, Department dept, int code, int credits) {
		this(name, dept, code, credits, null, null);
	}

	public Course(String name, Department dept, int code, int credits, List<Course> prereq, List<Course> coreq) {
		this.name = name;
		this.dept = dept;
		this.code = code;
		this.credits = credits;
		if (prereq == null) {
			this.prereq = new ArrayList<Course>();
		} else {
			this.prereq = prereq;
		} // If there isn't a specified list, create the list
		if (coreq == null) {
			this.coreq = new ArrayList<Course>();
		} else {
			this.coreq = coreq;
		}
		this.sections = new ArrayList<Section>(); // Create the list for later.

		// Link this course's department to this course
		dept.AddCourse(this);
	}

	// -[Getters]---------------------------------------------

	public String getName() {
		return name;
	}

	public Department getDept() {
		return dept;
	}

	public int getCode() {
		return code;
	}

	public int getCredits() {
		return credits;
	}

	public List<Course> getPrereq() {
		return prereq;
	}

	public List<Course> getCoreq() {
		return prereq;
	}

	public List<Section> getSections() {
		return sections;
	}

	// -[Setters]---------------------------------------------

	public void setName(String name) {
		this.name = name;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setPrereq(List<Course> prereq) {
		this.prereq = prereq;
	}

	public void setCoreq(List<Course> coreq) {
		this.coreq = coreq;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	// -[Methods]--------------------------------------------

	public void addPrereq(Course course) {
		this.prereq.add(course);
	}

	public void addCoreq(Course course) {
		this.coreq.add(course);
	}

	public void addSection(Section sect) {
		this.sections.add(sect);
	}

	/**
	 * Returns a displayable string for this course
	 * 
	 * @return CourseName (DeptShortNameCourseCode) Credits Credit(s) (IE "Acting 1
	 *         (DRAM3001) 3 Credit(s)")
	 */
	public String toString() {
		return getName() + " (" + getDept().getShortName() + getCode() + ") " + getCredits() + " Credit(s)";
	}

}
