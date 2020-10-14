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
	private List<Course> prereq;
	private List<Course> coreq;
	private List<Section> sections;
	
	//-[Constructor]-----------------------------------------
	
	public Course(String name, String dept, int code, List<Course> prereq, List<Course> coreq) {
		this.name = name;
		this.dept = dept;
		this.code = code;
		this.prereq = prereq;
		this.coreq = coreq;
	}
	
	//-[Getters]---------------------------------------------
	
	public String getName() {
		return this.name;
	}
	
	public String getDept() {
		return this.dept;
	}
	public int getCode() {
		return this.code;
	}
	public List<Course> getPrereq(){
		return this.prereq;
	}
	public List<Course> getCoreq() {
		return this.coreq;
	}
	
	//-[Methods]--------------------------------------------
	
	public void addPrereq(Course course) {
		this.prereq.add(course);
	}
	public void addCoreq(Course course) {
		this.coreq.add(course);
	}
	

}
