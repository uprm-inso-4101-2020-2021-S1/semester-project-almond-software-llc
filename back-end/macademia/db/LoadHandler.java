package macademia.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import macademia.Course;
import macademia.Department;
import macademia.Matricula;
import macademia.Section;
import macademia.Student;
import macademia.auth.User;

/**
 * Handles loading anything from the database
 * @author igtampe
 */
public class LoadHandler {

	/*
	 * Holds a map of all departments
	 */
	private Map<String, Department> DepartmentMap;
	
	private Connection SQLConn;
	
	/**
	 * Initializes the department map and connection to the SQL database
	 * @throws SQLException if a connection could not be created.
	 */
	public LoadHandler(String FileName) throws SQLException {
		DepartmentMap = new HashMap<String, Department>();
		SQLConn = DriverManager.getConnection("jdbc:sqlite:"+FileName);
	}
	
	/**
	 * Gets the department map so that it can be saved
	 * @return
	 */
	public Map<String, Department> getDepartmentMap(){return DepartmentMap;}
	
	/**
	 * Gets the SQL Connection for the save handler
	 * @return
	 */
	public Connection getConnection() {return SQLConn;}
	
	//-[Publicly facing gets]-----------------------------------------------------------------------------
	
	/**
	 * Gets a user from the database.
	 * @param Username
	 * @return
	 * @throws SQLException 
	 */
	public User getUser(String Username) throws SQLException {
		ResultSet RS= selectUser(Username);
		if(!RS.next()) {RS.close(); return null;}
		
		String username = RS.getString("Username");
		String Password = RS.getString("Password");
		RS.close();
		return new User(username,Password);
	}
	
	/**
	 * Gets a student from the database by finding TiedUsername
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public Student getStudent(User user) throws SQLException {
		ResultSet RS= selectStudentFromUsername(user.getUsername());
		if(!RS.next()) {RS.close(); return null;}
		
		String Name = RS.getString("Name");
		String ID = RS.getString("ID");

		//TODO: Change this to an array of Matriculas once this happens.
		Matricula Mat = getMatricula(Integer.parseInt(RS.getString("Matriculas").split(",")[0]));
		
		Department Dep = getDepartment(RS.getString("Department"));

		RS.close(); //We need to close the connection
		return new Student(user, Name, ID, Mat, Dep);
	}
	
	/**
	 * Gets a student from the database by finding Student Number
	 * @param StudentNumber
	 * @return
	 * @throws SQLException 
	 */
	public Student getStudent(String StudentNumber) throws SQLException {
		ResultSet RS= selectStudentFromID(StudentNumber);
		if(!RS.next()) {RS.close(); return null;}
		
		User TiedUser=getUser(RS.getString("TiedUser"));
		String Name = RS.getString("Name");
		String ID = RS.getString("ID");

		//TODO: Change this to an array of Matriculas once this happens.
		Matricula Mat = getMatricula(Integer.parseInt(RS.getString("Matriculas").split(",")[0]));
		
		Department Dep = getDepartment(RS.getString("Department"));

		RS.close(); //We need to close the connection
		return new Student(TiedUser, Name, ID, Mat, Dep);
	}

	/**
	 * Gets a matricula from the database
	 * @param ID
	 * @return
	 * @throws SQLException 
	 */
	public Matricula getMatricula(int ID) throws SQLException {
		ResultSet RS= selectMatricula(ID);
		if(!RS.next()) {RS.close(); return null;}
		
		int IDFromDatabase = RS.getInt("ID");
		String[] Sections = RS.getString("Sections").split(",");
		String Period = RS.getString("Period");
		int Year = RS.getInt("Year");
		
		RS.close();
		
		ArrayList<Section> SectionsList = new ArrayList<Section>(Sections.length);
		
		//get an arraylist of all the sections:
		for (String Section : Sections) {SectionsList.add(getSection(Section));}
		
		return new Matricula(SectionsList, 0, Period);
		
	}

	/**
	 * Gets a list of all departments in the database. If they have not been loaded, they will be loaded.
	 * @return
	 * @throws SQLException 
	 */
	public List<Department> getDepartments() throws SQLException {
		ResultSet RS = selectDepartments();
		ArrayList<Department> Departments = new ArrayList<Department>();
		
		//I know we access the database like twice to get this data but this allows the handler to kick in. Otherwise this'd be a mess.
		while(RS.next()) {Departments.add(getDepartment(RS.getString("ID")));} 
		RS.close();
		return Departments;
	}
	
	/**
	 * Gets a specified department
	 * @param DepartmentID
	 * @return
	 * @throws SQLException 
	 */
	public Department getDepartment(String ShortNameID) throws SQLException {
		//Check if the department exists on the department map, and if so, return that.
		if(DepartmentMap.containsKey(ShortNameID)) {return DepartmentMap.get(ShortNameID);}
		
		//If not, let's load it.
		ResultSet RS = selectDepartment(ShortNameID);
		if(!RS.next()) {RS.close(); return null;}
		
		//Get Name/ShortName
		String ShortName = RS.getString("ID");
		String Name = RS.getString("Name");
		
		RS.close();
		
		Department Dep = new Department(Name,ShortName);
		DepartmentMap.put(Dep.getShortName(), Dep);
		return Dep;
	}
	
	/**
	 * Gets a list of all courses in the database.
	 * @param department
	 * @return
	 * @throws SQLException 
	 */
	public List<Course> getAllCourses() throws SQLException {
		ResultSet RS = selectAllCourses();
		ArrayList<Course> Courses = new ArrayList<Course>();
		while(RS.next()) {
			Courses.add(getCourse(RS.getString("ID")));
		} 
		RS.close();
		return Courses;
	}
	
	/**
	 * Gets a list of courses from a department.
	 * @param department
	 * @return
	 * @throws SQLException 
	 */
	public List<Course> getCourses(Department department) throws SQLException {
		ResultSet RS = selectCourses(department.getShortName());
		ArrayList<Course> Courses = new ArrayList<Course>();
		while(RS.next()) {
			Courses.add(getCourse(RS.getString("ID")));
		} 
		RS.close();
		return Courses;
	}
	
	/**
	 * Gets a course by course ID
	 * @param CourseID "INSO4101"
	 * @return
	 * @throws SQLException 
	 */
	public Course getCourse(String Course) throws SQLException {
		//Split the course into Department ShortName and Course ID
		String DepartmentID = Course.substring(0,4);
		String CourseID = Course.substring(4);
		Boolean RequestedL=Course.endsWith("L");
		
		//See if it already exists:
		Department dep = getDepartment(DepartmentID);
		if(dep.getCatalog().containsKey(CourseID)) {return dep.getCatalog().get(CourseID);}
		
		//Load it:
		ResultSet RS = selectCourse(Course);
		if(!RS.next()) {RS.close(); return null;}
		if(RS.getBoolean("L")!=RequestedL) {if(!RS.next()) {RS.close(); return null;}} //If L doesn't match, RS.NEXT. If Not RS.NEXT, RS.CLOSE.
		
		String CourseName = RS.getString("Name");
		int CourseCredits = RS.getInt("Credits");
		String[] Prereq = RS.getString("Prereq").split(",");
		String[] Coreq = RS.getString("Coreq").split(",");
		
		Course TheCourse = new Course(CourseName, dep, Integer.parseInt(CourseID), CourseCredits);
		
		//Load Prerequesites
		for (String prereq : Prereq) {
			if(prereq.length()!=0) {TheCourse.addPrereq(getCourse(prereq));} //If because empty prereqs still returns "" 
		}
		
		//Load CoRequesites
		for (String coreq : Coreq) {
			if(coreq.length()!=0) {TheCourse.addPrereq(getCourse(coreq));}
		} //TODO: Switch to addCoreq once it is created.
		
		return TheCourse;
	}
	
	/**
	 * Gets a list of all sections in the database
	 * @param course
	 * @return
	 * @throws SQLException 
	 */
	public List<Section> getAllSections() throws SQLException {
		ResultSet RS = selectAllSections();
		ArrayList<Section> Sections = new ArrayList<Section>();
		while(RS.next()) {Sections.add(getSection(RS.getString("ID")));} 
		RS.close();
		return Sections;
	}
	
	/**
	 * Gets a list of sections from a course
	 * @param course
	 * @return
	 * @throws SQLException 
	 */
	public List<Section> getSections(Course course) throws SQLException {
		ResultSet RS = selectSections(course.getDept().getShortName() + course.getCode());
		ArrayList<Section> Sections = new ArrayList<Section>();
		while(RS.next()) {Sections.add(getSection(RS.getString("ID")));} 
		RS.close();
		return Sections;
	}

	/**
	 * Gets a section 
	 * @param SectionID
	 * @return
	 * @throws SQLException 
	 */
	public Section getSection(String SectionID) throws SQLException {
		//Split the ID into the relevant parts:
		String[] sectionSplit = SectionID.split("-"); //ICOM4050-20
		Course course = getCourse(sectionSplit[0]);
		
		//See if the section already exists:
		//TODO Probably switch this to a map
		for (Section section : course.getSections()) {if(section.getSecNum()==sectionSplit[1]) {return section;}}
		
		//If we're here then the section doesn't exist. Time to find it in the database.
		ResultSet RS = selectSection(SectionID);
		RS.next();

		//TODO: Once course gets the L flag
		//if(RS.getBoolean("L")!=course.isLab()) {RS.next();}
		
		//TODO: Make a parser for the enum for Days
		String day = RS.getString("Days");
		String time = RS.getString("Time");
		
		String Location = RS.getString("Location");
		String Prof = RS.getString("Prof");
		int CurCap = RS.getInt("CurCap");
		int MaxCap = RS.getInt("MaxCap");
		
		return new Section(sectionSplit[1], day, time, course); //Creating a section automatically links it to a course.
	}
	
	//-[privately facing gets]-----------------------------------------------------------------------------
	
	/**
	 * Handles getting a result set from a given table where the column matches the value
	 * @return SELECT * FROM (TABLE) WHERE (COLUMN) = '(VALUE)';
	 * @throws SQLException 
	 */
	private ResultSet GetFromWhere(String Table, String Column, String Value) throws SQLException {return SQLConn.createStatement().executeQuery("SELECT * FROM " + Table + " WHERE " + Column + " = '" + Value + "';");}

	/**
	 * Handles getting a result from a given table, where the column is *like* the value
	 * @return SELECT * FROM (TABLE) WHERE (COLUM) LIKE '(VALUE)'
	 * @throws SQLException
	 */
	private ResultSet GetFromWhereLike(String Table, String Column, String Value) throws SQLException {return SQLConn.createStatement().executeQuery("SELECT * FROM " + Table + " WHERE " + Column + " LIKE '" + Value + "';");}
	
	/**
	 * Handles getting all values from a table
	 * @param Table SELECT * FROM (TABLE);
	 * @return
	 * @throws SQLException
	 */
	private ResultSet GetEverythingFrom(String Table) throws SQLException{return SQLConn.createStatement().executeQuery("SELECT * FROM " + Table + ";");}
	
	private ResultSet selectUser(String Username) throws SQLException {return GetFromWhere("Users","Username",Username);}
	
	private ResultSet selectStudentFromUsername(String Username) throws SQLException {return GetFromWhere("Students","TiedUser",Username);}
	private ResultSet selectStudentFromID(String StudentID) throws SQLException {return GetFromWhere("Students","ID",StudentID);}
	
	private ResultSet selectMatricula(int ID) throws SQLException {return GetFromWhere("Matriculas","ID",ID+"");}
	
	private ResultSet selectDepartments() throws SQLException {return GetEverythingFrom("Departments");}
	private ResultSet selectDepartment(String ShortName) throws SQLException {return GetFromWhere("Departments", "ID", ShortName);}
	
	private ResultSet selectAllCourses() throws SQLException {return GetEverythingFrom("Courses");}
	private ResultSet selectCourses(String Department) throws SQLException {return GetFromWhereLike("Courses", "ID", Department + "%");}
	private ResultSet selectCourse(String ID) throws SQLException {return GetFromWhere("Courses", "ID", ID.substring(0,8));}
	
	private ResultSet selectAllSections() throws SQLException {return GetEverythingFrom("Sections");}
	private ResultSet selectSections(String Course) throws SQLException {return GetFromWhereLike("Sections", "ID", Course + "%");}
	private ResultSet selectSection(String ID) throws SQLException {return GetFromWhere("Sections", "ID", ID);}
	
	
}
