package macademia;

import java.util.List;
import macademia.Section;

/*
 * Contains information for a Course
 * @author Kurcell
 */

public class Course {
	
	//-[Fields]----------------------------------------------
	
	private String name;
	private String dept;
	private int code;
	private int credits;
	private List<Course> prereq;
	private List<Section> sections;
	
	//-[Constructor]-----------------------------------------
	
	public Course(String name, String dept, int code, int credits, List<Course> prereq) {
		this.name = name;
		this.dept = dept;
		this.code = code;
		this.credits = credits;
		this.prereq = prereq;
	}
	
	//-[Getters]---------------------------------------------

	public String getName() {
		return name;
	}
	public String getDept() {
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
	public List<Section> getSections() {
		return sections;
	}
	
	//-[Setters]---------------------------------------------
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDept(String dept) {
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
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	//-[Methods]--------------------------------------------
	
	public void addPrereq(Course course) {
		this.prereq.add(course);
	}
}
