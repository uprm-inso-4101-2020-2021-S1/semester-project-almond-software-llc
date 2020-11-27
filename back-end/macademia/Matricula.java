package macademia;
import java.util.List;

public class Matricula {
	
	//-[Fields]----------------------------------------------
	private List<Section> Sections;
	private int totalCredits; 
	private String period; 
	private int ID=-1;
	private boolean ReadOnly;

	//-[Constructor]-----------------------------------------
	public Matricula(List<Section> Sections, int totalCredits, String period) {
		this.Sections = Sections;
		this.totalCredits = totalCredits;
		this.period = period;
		this.ReadOnly=true;
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
	public boolean getReadOnly() { return ReadOnly; }

	public void setSections(List<Section> Sections) {
		if(!this.ReadOnly)this.Sections = Sections;
	}
	public void setTotalCredits(int totalCredits) {
		if(!this.ReadOnly)this.totalCredits = totalCredits;
	}
	public void setPeriod(String period) {
		if(!this.ReadOnly)this.period = period;
	}
	public void setReadOnly(boolean ReadOnly) {  if(!this.ReadOnly)this.ReadOnly=ReadOnly; }
	
	public int getID() {return ID;}
	public void setID(int ID) {if(!this.ReadOnly)this.ID=ID;}
	
	/**
	 * Returns a displayable string for this Matricula
	 * @return CourseNumber Course(s) (Credits Credit(s)) during Period (IE "2 Course(s) totaling 6 Credit(s) during FALL")
	*/
	public String toString() {return Sections.size() + " Course(s) totaling " + getTotalCredits() + " Credit(s) during " + getPeriod();}

}
