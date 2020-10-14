package macademia;
import java.util.List;

public class Matricula {
	
	//-[Fields]----------------------------------------------
	private List<Course> courses;
	private int totalCredits; 
	private String period; 

	//-[Constructor]-----------------------------------------
	public Matricula(List<Course> courses, int totalCredits, String period) {
		this.courses = courses;
		this.totalCredits = totalCredits;
		this.period = period; 		
	}
	
	//-[Getters]---------------------------------------------
	public List<Course> getCourses() {
		return courses;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public String getPeriod() {
		return period;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Returns a displayable string for this Matricula
	 * @return CourseNumber Course(s) (Credits Credit(s)) during Period (IE "2 Course(s) totaling 6 Credit(s) during FALL")
	*/
	public String toString() {return courses.size() + " Course(s) totaling " + getTotalCredits() + " Credit(s) during " + getPeriod();}

}
