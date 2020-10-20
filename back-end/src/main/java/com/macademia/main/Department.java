package com.macademia.main;

import java.util.Hashtable;
import java.util.Map;

/**
 * Department class which holds its name, its short name and a table with all of
 * its courses.
 * 
 * @author igtampe
 */
public class Department {

	// -[Variables]----------------------------------------------------------------------

	private Map<Integer, Course> CourseCatalog; // It's a map for *easy lookup*. I suggest the Data structure to store a table with all departments.
	private final String Name;
	private final String ShortName;

	// -[Constructors]----------------------------------------------------------------------

	/**
	 * Creates a department with the specified name and Short Name. Also initializes
	 * 
	 * @param Name      Name of the department (IE "Department of Computer
	 *                  Engineering")
	 * @param ShortName Short name of the department (IE "ICOM")
	 */
	public Department(String Name, String ShortName) {
		this.Name = Name; // Set name
		this.ShortName = ShortName;
		CourseCatalog = new Hashtable<Integer, Course>(); // Initialize the Course
		// Directory.
	}

	/**
	 * Creates a department with the specified name, Short Name, and Course
	 * Directory
	 * 
	 * @param Name         Name of the department (IE "Department of Computer
	 *                     Engineering")
	 * @param ShortName    Short name of the department (IE "ICOM")
	 * @param CourseCatlog Catalog of courses, where the key is the course number
	 *                     (IE 3011) and the value is the course.
	 */
	public Department(String Name, String ShortName, Map<Integer, Course> CourseCatalog) {
		this(Name, ShortName);
		this.CourseCatalog = CourseCatalog;
	}

	// -[Getters]----------------------------------------------------------------------

	/**
	 * Returns the name of this department
	 * 
	 * @return
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Returns the short name of this department
	 * 
	 * @return
	 */
	public String getShortName() {
		return ShortName;
	}

	/**
	 * Returns the Course Catalog of this department.
	 * 
	 * @return A map where the integer is the Course ID, and Value is the course
	 *         itself.
	 */
	public Map<Integer, Course> getCatalog() {
		return CourseCatalog;
	}

	// -[Functions]----------------------------------------------------------------------

	/**
	 * Adds/updates a course to the course directory.
	 */
	public void AddCourse(Course course) {
		CourseCatalog.put(course.getCode(), course);
	}

	// -[Overrides]----------------------------------------------------------------------

	/**
	 * Returns a displayable string for this department.
	 * 
	 * @return NAME (CATALOG.COUNT Course(s))
	 */
	public String toString() {
		return Name + " (" + CourseCatalog.size() + "course(s))";
	}

	/**
	 * Checks if an object is equal to this Department
	 * 
	 * @param obj
	 * @return True if and only if the object is not null, is an instance of
	 *         Department, and has the same Short Name.
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Department) {
			Department OtherDepartment = (Department) obj;
			return OtherDepartment.ShortName == ShortName;
		}
		return false;
	}

}
