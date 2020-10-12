package macademia;
import java.util.List;

public class Matricula {
	
	//-[Fields]----------------------------------------------
	private List<Section> Sections;
	private int totalCredits; 
	private String period; 

	//-[Constructor]-----------------------------------------
	public Matricula(List<Section> Sections, int totalCredits, String period) {
		this.Sections = Sections;
		this.totalCredits = totalCredits;
		this.period = period; 		
	}
	
	//-[Getters]---------------------------------------------
	public List<Section> getSections() {
		return Sections;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public String getPeriod() {
		return period;
	}

	public void setSections(List<Section> Sections) {
		this.Sections = Sections;
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
	public String toString() {return Sections.size() + " Course(s) totaling " + getTotalCredits() + " Credit(s) during " + getPeriod();}

}
