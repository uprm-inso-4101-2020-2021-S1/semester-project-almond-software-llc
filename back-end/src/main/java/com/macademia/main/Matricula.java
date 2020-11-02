package com.macademia.main;

import java.util.ArrayList;
import java.util.List;

public class Matricula {

	// -[Fields]----------------------------------------------
	private List<Section> sections;
	private int totalCredits;
	private MatriculaPeriod period;
	private int ID = -1;

	// -[Constructor]-----------------------------------------
	public Matricula(MatriculaPeriod period) {
		this.sections = new ArrayList<Section>();
		this.totalCredits = 0;
		this.period = period;
	}

	public Matricula(List<Section> sections, MatriculaPeriod period) {
		this.sections = sections;
		this.totalCredits = 0;
		this.period = period;
	}

	// -[Add-Remove]]---------------------------------------------

	// had to include both section and course whenever adding a new section into a matricula 
	// in order to keep track of sections and courses taken
	public void addSections(Section e) {
		this.totalCredits += e.getCredits();
		e.increasePopulation();
		this.sections.add(e);		
	}

	public void removeSections(Section e) {
		this.totalCredits -= e.getCredits();
		e.decreasePopulation();
		this.sections.remove(e);
	}


	// -[Getters]---------------------------------------------
	public List<Section> getSections() {return sections;}
	public int getTotalCredits() {return totalCredits;}
	public MatriculaPeriod getPeriod() {return period;}
	public int getID() {return ID;}

	public void setSections(List<Section> sections) {this.sections = sections;}
	public void setTotalCredits(int totalCredits) {this.totalCredits = totalCredits;}
	public void setPeriod(MatriculaPeriod period) {this.period = period;}
	public void setID(int ID) {this.ID=ID;}

	
	/**
	 * Returns a displayable string for this Matricula
	 * 
	 * @return CourseNumber Course(s) (Credits Credit(s)) during Period (IE "2
	 *         Course(s) totaling 6 Credit(s) during FALL")
	 */
	public String toString() {return sections.size() + " Course(s) totaling " + getTotalCredits() + " Credit(s) during " + getPeriod();}

}
