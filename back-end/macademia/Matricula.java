package macademia;
import java.util.List;

import macademia.auth.MatriculaPeriod;

public class Matricula {
	//-[Fields]----------------------------------------------
	private List<Course> courses;
	private int totalCredits;
	private MatriculaPeriod period; 

	//-[Constructor]-----------------------------------------
	public Matricula(List<Course> courses, int totalCredits, MatriculaPeriod period) {
		this.courses = courses;
		this.totalCredits = getCredits();
		this.period = period; 		
	}

	public int getCredits() {
		int cred = 0;
		if (this.courses.isEmpty()) return cred;
		for (Course s : courses) {cred = cred + s.getCredits();}
		return cred;
	}
	
	//-[Getters]---------------------------------------------
	public List<Course> getCourses() {
		return courses;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public MatriculaPeriod getPeriod() {
		return period;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	public void setPeriod(MatriculaPeriod period) {
		this.period = period;
	}
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	/**
	 * Returns a displayable string for this Matricula
	 * @return CourseNumber Course(s) (Credits Credit(s)) during Period (IE "2 Course(s) totaling 6 Credit(s) during FALL")
	*/
	public String toString() {return courses.size() + " Course(s) totaling " + getTotalCredits() + " Credit(s) during " + getPeriod();}

}


