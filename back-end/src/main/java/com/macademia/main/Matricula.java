package com.macademia.main;

import java.util.ArrayList;
import java.util.List;

public class Matricula {

	// -[Fields]----------------------------------------------
	private List<Section> sections;
	private List<Course> coursesTaken;
	private int totalCredits;
	private String period;

	// -[Constructor]-----------------------------------------
	public Matricula(String period) {
		this.sections = new ArrayList<Section>();
		this.coursesTaken = new ArrayList<Course>();
		this.totalCredits = 0;
		this.period = period;
	}

	public Matricula(List<Section> sections, String period) {
		this.sections = sections;
		this.totalCredits = 0;
		this.period = period;
	}

	// -[Add-Remove]]---------------------------------------------

	// had to include both section and course whenever adding a new section into a matricula 
	// in order to keep track of sections and courses taken
	public void addSections(Section e, Course f) {
		this.totalCredits += e.getCredits();
		this.sections.add(e);
		this.coursesTaken.add(f);
	}

	public void removeSections(Section e) {
		this.totalCredits -= e.getCredits();
		this.sections.remove(e);
		this.coursesTaken.remove(this.findCourse(e));
	}

	private Course findCourse(Section e) {
		for (Course c : this.coursesTaken) {
			if (e.getCourseCode().equals(c.getDept() + c.getCode()))
				return c;
		}
		return null;
	}

	// -[Getters]---------------------------------------------
	public List<Section> getSections() {
		return sections;
	}

	public List<Course> getCoursesTaken() {
		return coursesTaken;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public String getPeriod() {
		return period;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * Returns a displayable string for this Matricula
	 * 
	 * @return CourseNumber Course(s) (Credits Credit(s)) during Period (IE "2
	 *         Course(s) totaling 6 Credit(s) during FALL")
	 */
	public String toString() {
		return sections.size() + " Course(s) totaling " + getTotalCredits() + " Credit(s) during " + getPeriod();
	}

}
