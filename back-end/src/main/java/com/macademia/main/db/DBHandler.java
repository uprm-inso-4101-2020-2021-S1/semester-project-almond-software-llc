package com.macademia.main.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.macademia.main.Course;
import com.macademia.main.Department;
import com.macademia.main.Matricula;
import com.macademia.main.MatriculaPeriod;
import com.macademia.main.Section;
import com.macademia.main.Student;
import com.macademia.main.auth.User;

/**
 * Handles loading and saving anything from and to the database
 * @author igtampe
 */
public class DBHandler {

	/*
	 * Holds a map of all departments
	 */
	private Map<String, Department> DepartmentMap;
	
	/**
	 * Holds connection to the database
	 */
	private Connection SQLConn;
	
	/**
	 * Creates a DBHandler without overwriting the specified file
	 * @param FileName
	 * @throws SQLException
	 */
	public DBHandler(String FileName) throws SQLException {this(FileName,false);}
	
	/**
	 * Initializes the department map and connection to the SQL database \n\n
	 * If a file does not exist at the specified location, or if the overwrite flag is set to true, it will create a new Macademia DB at that location. 
	 * @throws SQLException if a connection could not be created.
	 */
	public DBHandler(String FileName, Boolean Overwrite) throws SQLException {
		DepartmentMap = new HashMap<String, Department>();
		
		//Time to make this thing create databases if it doesn't find one. haha.
		Creator.createNewMacademiaDatabase(FileName, Overwrite); //Creator doesn't overwrite tables if they already exist so this is safe
		
		SQLConn = DriverManager.getConnection("jdbc:sqlite:"+FileName);
		
		//Sabes que lazy loading everything is probably not a good idea.
		//Deps, Courses, and Sections should be loaded as soon as the de-esta cosa is istantiated.
		
		LoadEverything();
		
		//Remove these lines of code to have the DBHandler *not* load Deps, Courses, and Sections upon instantiation.
		
	}

	//-[Publicly facing gets]-----------------------------------------------------------------------------
	
	/**
	 * Does what it says: Loads everything \n\n
	 * Loads every Department, Course, and Section from the database.
	 * @throws SQLException
	 */
	public void LoadEverything() throws SQLException {
		getDepartments();
		getAllCourses();
		getAllSections();		
	}
	
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

		Department Dep = getDepartment(RS.getString("Department"));
		Student ReturnStudent = new Student(user, Name, ID, Dep);
		
		//Get all matriculas
		for (String MatID : RS.getString("Matriculas").split(",")) {ReturnStudent.addMatricula(getMatricula(Integer.parseInt(MatID)));}
		
		//Get Priority Courses
		for (String PriorityCourse : RS.getString("PriorityCourses").split(",")) {if(!PriorityCourse.isBlank()) {ReturnStudent.addPriority(getCourse(PriorityCourse));}}
		
		//Get Courses Taken
		for (String CourseTaken : RS.getString("CoursesTaken").split(",")) {if(!CourseTaken.isBlank()) {ReturnStudent.addCourseTaken(getCourse(CourseTaken));}}		
		
		RS.close(); //We need to close the connection
		
		return ReturnStudent;
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
		Department Dep = getDepartment(RS.getString("Department"));
		Student ReturnStudent = new Student(TiedUser, Name, ID, Dep);
		
		//Get all matriculas
		for (String MatID : RS.getString("Matriculas").split(",")) {if(!MatID.isBlank()) {ReturnStudent.addMatricula(getMatricula(Integer.parseInt(MatID)));}}
		
		//Get Priority Courses
		for (String PriorityCourse : RS.getString("PriorityCourses").split(",")) {if(!PriorityCourse.isBlank()) {ReturnStudent.addPriority(getCourse(PriorityCourse));}}
		
		//Get Courses Taken
		for (String CourseTaken : RS.getString("CoursesTaken").split(",")) {if(!CourseTaken.isBlank()) {ReturnStudent.addCourseTaken(getCourse(CourseTaken));}}		
		
		RS.close(); //We need to close the connection
		
		return ReturnStudent;
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
		for (String Section : Sections) {if(Section.length()>0) {SectionsList.add(getSection(Section));}}
		
		Matricula mat =new Matricula(SectionsList, new MatriculaPeriod(Year, Period)); 
		mat.setID(IDFromDatabase);
		
		return mat;
		
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
		if(dep==null) {return null;} //If the department doesn't exist, then obviously neither does the course.
		if(dep.getCatalog().containsKey(CourseID)) {return dep.getCatalog().get(CourseID);}
		
		//Load it:
		ResultSet RS = selectCourse(Course);
		if(!RS.next()) {RS.close(); return null;}
		if(RS.getBoolean("L")!=RequestedL) {if(!RS.next()) {RS.close(); return null;}} //If L doesn't match, RS.NEXT. If Not RS.NEXT, RS.CLOSE.
		
		String CourseName = RS.getString("Name");
		int CourseCredits = RS.getInt("Credits");
		String[] Prereq = RS.getString("Prereq").split(",");
		String[] Coreq = RS.getString("Coreq").split(",");
		
		Course TheCourse = new Course(CourseName, dep, CourseID, CourseCredits);
		
		//Load Prerequesites
		for (String prereq : Prereq) {
			if(prereq.length()!=0) {TheCourse.addPrereq(getCourse(prereq));} //If because empty prereqs still returns "" 
		}
		
		//Load CoRequesites
		for (String coreq : Coreq) {
			if(coreq.length()!=0) {TheCourse.addCoreq(getCourse(coreq));}
		}
		
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
		ResultSet RS = selectSections(course.getDept() + course.getCode());
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
		if(course==null) {return null;} //if the course doesn't exist, neither will the section.		
		
		//See if the section already exists:
		//TODO Probably switch this to a map
		for (Section section : course.getSections()) {if(section.getSecNum()==sectionSplit[1]) {return section;}}
		
		//If we're here then the section doesn't exist. Time to find it in the database.
		ResultSet RS = selectSection(SectionID);
		if(!RS.next()) {RS.close(); return null;}
		
		//TODO: Convert this to period
		String day = RS.getString("Days");
		String time = RS.getString("Time");
		
		String Location = RS.getString("Location");
		String Prof = RS.getString("Prof");
		int CurCap = RS.getInt("CurCap");
		int MaxCap = RS.getInt("MaxCap");
		
		return new Section(sectionSplit[1], day, time, Prof, Location, course, CurCap, MaxCap); //Creating a section automatically links it to a course.
	}
	
	//-[Check Exists]-----------------------------------------------------------------------------
	
	//These could probably be made more efficient but oh well
	public boolean UserExists(String Username) throws SQLException {return getUser(Username)!=null;}
	public boolean StudentExists(String StudentNumber) throws SQLException {return getStudent(StudentNumber)!=null;}
	public boolean MatriculaExists(int ID) throws SQLException {return getMatricula(ID)!=null;}
	public boolean DepartmentExists(String ShortNameID) throws SQLException {return getDepartment(ShortNameID)!=null;}
	public boolean CourseExists(String Course) throws SQLException {return getCourse(Course)!=null;}
	public boolean SectionExists(String SectionID) throws SQLException {return getSection(SectionID)!=null;}

	//-[Publicly facing Saves]-----------------------------------------------------------------------------
	
	/**
	 * Does what it says: Saves everything \n\n
	 * Saves every department, and within it saves every course, and within it saves every section.
	 */
	public void SaveEverything() throws SQLException {for (Department Dep : DepartmentMap.values()) {SaveDepartment(Dep);}}

	/**
	 * Saves a user to the SQL Database
	 * @param user
	 */
	public void SaveUser(User user) throws SQLException {
		if(UserExists(user.getUsername())) {UpdateUsers(user.getUsername(),user.getPassword());}
		else {InsertIntoUsers(user.getUsername(), user.getPassword());}
	}
	
	/**
	 * Saves a student to the SQL Database, including saving every Matricula 
	 */
	public void SaveStudent(Student stud) throws SQLException {
		
		//Verify the TiedUser already exists in the system
		if(!UserExists(stud.getUsername())) {
			//The tiedUser is not in the system, but we can actually just *a d d    i t      o u r s e l v e s * :woah:
			SaveUser(stud); //And since Student Extends User we can just do this. *AMAZING*
		}
		
		String Matriculas = ""; 
		Matriculas = ListOfMatriculasToString(stud.getMatriculas());
		
		String PriorityCourses=""; 
		PriorityCourses = ListOfCoursesToString(stud.getPriority()); 
		
		String CoursesTaken = "";
		CoursesTaken=ListOfCoursesToString(stud.getCoursesTaken());
		
		//Then save the user
		if(StudentExists(stud.getStudentNumber())) {UpdateStudents(stud.getStudentNumber(), stud.getName(), stud.getUsername(), stud.getDepartment().getShortName(), Matriculas, PriorityCourses,CoursesTaken);}
		else {InsertIntoStudents(stud.getStudentNumber(), stud.getName(), stud.getUsername(), stud.getDepartment().getShortName(), Matriculas, PriorityCourses,CoursesTaken);}
		
		//Save the Matriculas
		for (Matricula Mat : stud.getMatriculas()) {SaveMatricula(Mat);}
		
	}
	
	/**
	 * Saves a Matricula to the SQL Database
	 * @param Mat
	 * @return Returns the ID of the saved matricula (For the SaveStudent function)
	 */
	public int SaveMatricula(Matricula Mat) throws SQLException {
		String Sections=ListOfSectionsToString(Mat.getSections());
		
		int Year = Mat.getPeriod().getMatyear(); 
		String Period = Mat.getPeriod().getSemesterAsString(); 
				
		
		if(Mat.getID()==-1) {
			//This is a new matricula. We need to add it
			int NewID;
			Random rand = new Random();
			do {NewID=rand.nextInt();}while(MatriculaExists(NewID)); //Generate a new ID while there exists a matricula with that ID
			
			Mat.setID(NewID); //We now have a new unique ID. Save it with that ID
			
			InsertIntoMatriculas(Mat.getID(),Sections, Period, Year);
		} else {
			//This is an edited matricula. We need to update it			
			UpdateMatriculas(Mat.getID(), Sections, Period, Year);
		}
		
		return Mat.getID();
	}
	
	/**
	 * Saves the specified department to the SQL Database, including saving every course within, and every section within those courses.
	 * @param dep
	 */
	public void SaveDepartment(Department dep) throws SQLException{
		//Save the department itself
		if(DepartmentExists(dep.getShortName())) {UpdateDepartments(dep.getShortName(), dep.getName());}
		else {InsertIntoDepartments(dep.getShortName(), dep.getName());}
		
		//Save the course
		for (Course course : dep.getCatalog().values()) {SaveCourse(course);}
	}
	
	/**
	 * Saves the specified course to the SQL Database, including saving every department within
	 * @param course
	 */
	public void SaveCourse(Course course) throws SQLException {
		
		//Verify department exists
		if(!DepartmentExists(course.getDept())) {throw new IllegalArgumentException("Department is not in the database! Register it *BEFORE* adding this course");}
		
		//Save the course
		String CourseID = course.getDept()+course.getCode(); 
		boolean L = CourseID.endsWith("L");
		
		//Prepare Prereqs
		String Prereqs = ListOfCoursesToString(course.getPrereq());
		
		//Prepare coreqs
		String Coreqs = ListOfCoursesToString(course.getCoreq());
		
				
		if(CourseExists(CourseID)) {UpdateCourses(CourseID.substring(0,8), L, course.getName(), course.getCredits(), Prereqs, Coreqs);}
		else {InsertIntoCourses(CourseID.substring(0,8), L, course.getName(), course.getCredits(), Prereqs, Coreqs);}
		
		//Save each section
		for (Section sect : course.getSections()) {SaveSeciton(sect);}
		
	}
	
	/**
	 * Saves the specifed section to the SQL Database
	 * @param sect
	 */
	public void SaveSeciton(Section sect) throws SQLException {
		
		//Verify Course exists
		if(!CourseExists(sect.getCourseCode())) {throw new IllegalArgumentException("Course is not in the database! Register it *BEFORE* adding this course");}
		
		
		String SectionID = sect.getCourseCode() + "-" + sect.getSecNum(); 
		boolean L = sect.getCourseCode().endsWith("L");
		
		String Time=sect.getTime(); //TODO: Switch to Period for formatting
		String Location=sect.getLocation();
		String Prof = sect.getProfessor();
		int CurCap = sect.getPopulation();
		int MaxCap = sect.getCapacity();
		
		if(SectionExists(SectionID)) {UpdateSections(SectionID, L, sect.getDay(), Time, Location, Prof, CurCap, MaxCap);}
		else {InsertIntoSections(SectionID, L, sect.getDay(), Time, Location, Prof, CurCap, MaxCap);}		
		
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
	
	//-[privately facing INSERTs]-----------------------------------------------------------------------------
	
	/**
	 * INSERTS a user
	 * @param Username of the user
	 * @param Password of the user
	 * @throws SQLException
	 */
	private void InsertIntoUsers(String Username, String Password) throws SQLException {
    	String SQLString = "INSERT INTO Users(Username, Password) VALUES(?,?)";
        PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);  
        pstmt.setString(1, Username); //Username
        pstmt.setString(2, Password); //Password (maybe encrypted)
        pstmt.executeUpdate();
        pstmt.close();
	}
	
	/**
	 * INSERTS into students
	 * @param ID Student ID (IE: 802-55-5555)
	 * @param Name Name of the student
	 * @param TiedUsername Username tied to this Student
	 * @param Department Department shortname of this student (IE: INSO)
	 * @param Matriculas Comma separated list of Matricula IDs (IE: 1,2,3,4)
	 * @param PriorityCourses Comma separated list of Priority Courses (IE: DRAM3001, DRAM3002, DRAM3003)
	 * @throws SQLException
	 */
	private void InsertIntoStudents(String ID, String Name, String TiedUsername, String Department, String Matriculas, String PriorityCourses, String CoursesTaken) throws SQLException {
    	String SQLString = "INSERT INTO Students(ID, Name, TiedUser, Department, Matriculas, PriorityCourses, CoursesTaken) VALUES(?,?,?,?,?,?,?)";
    	PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
        pstmt.setString(1, ID); //ID
        pstmt.setString(2, Name); //Name
        pstmt.setString(3, TiedUsername); //TiedUser
        pstmt.setString(4, Department); //Department
        pstmt.setString(5, Matriculas); //Matriculas
        pstmt.setString(6, PriorityCourses); //PriorityCourses
        pstmt.setString(7, CoursesTaken); //Courses Taken	
        pstmt.executeUpdate();
        pstmt.close();
	}
	 	
	/**
	 * INSERTS into Matriculas
	 * @param ID UNIQUE NUMERICAL ID FOR THIS MATRICULA
	 * @param Sections Comma separated list of Section IDs (IE: DRAM3001-020, DRAM3002-020)
	 * @param Period Period of this matricula (One of the following: SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL)
	 * @param Year Year of this Matricula
	 * @throws SQLException
	 */
	private void InsertIntoMatriculas(int ID, String Sections, String Period, int Year) throws SQLException {
		String SQLString = "INSERT INTO Matriculas(ID, Sections, Period, Year) VALUES(?,?,?,?)";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
        pstmt.setInt(1, ID);//ID
        pstmt.setString(2, Sections);//SECTIONS
        pstmt.setString(3, Period);//PERIOD
        pstmt.setInt(4,Year);//YEAR
        pstmt.executeUpdate();
        pstmt.close();
	}

	/**
	 * INSERTS into Departments
	 * @param ShortName Department ShortName (IE: INSO)
	 * @param Name Name of this department (IE: Department of Software Engineering)
	 * @throws SQLException
	 */
	private void InsertIntoDepartments(String ShortName, String Name) throws SQLException {
		String SQLString = "INSERT INTO Departments(ID, Name) VALUES(?,?)";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
        pstmt.setString(1, ShortName);  //Short Name
        pstmt.setString(2, Name); //Name  
        pstmt.executeUpdate();  
	}
	
	/**
	 * INSERTS into courses
	 * @param ID ID of this course (IE: DRAM3001)
	 * @param L L Flag (If this course is a lab)
	 * @param Name Name of this course (IE: Acting I)
	 * @param Credits Credits of this course
	 * @param Prereqs Comma separated list of Course IDs that are Prerequesites (IE: DRAM3000, ENGL3001)
	 * @param Coreqs Comma separated list of  Course IDs that are Corequesites (IE: DRAM3003, ENGL3003)
	 * @throws SQLException
	 */
	private void InsertIntoCourses(String ID, boolean L, String Name, int Credits, String Prereqs, String Coreqs ) throws SQLException {
    	String SQLString = "INSERT INTO Courses(ID, L, Name, Credits, Prereq, Coreq) VALUES(?,?,?,?,?,?)";
    	PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
        pstmt.setString(1, ID); //ID
        pstmt.setBoolean(2, L); //Lab
        pstmt.setString(3, Name); //Name
        pstmt.setInt(4, Credits); //Credits
        pstmt.setString(5, Prereqs); //Prereqs
        pstmt.setString(6, Coreqs); //Coreqs
        pstmt.executeUpdate();
        pstmt.close();
	}
	
	/**
	 * INSERTS into Sections
	 * @param ID ID of this Section (IE: DRAM3001-020)
	 * @param L L Flag (If this course is a lab)
	 * @param Days Days this section meets (IE: MWF)
	 * @param Time Times of this course in MILITARY TIME. Split by a DASH (IE: 8:30-9:30)
	 * @param Location Location of this section (IE: STEF512A)
	 * @param Prof Professor of this section (IE: Mr. Caesar)
	 * @param CurCap Current number of students in this section
	 * @param MaxCap Maximum number of students in this section
	 * @throws SQLException
	 */
	private void InsertIntoSections(String ID, boolean L, String Days, String Time, String Location, String Prof, int CurCap, int MaxCap) throws SQLException {
    	String SQLString =  "INSERT INTO Sections(ID, L, Days, Time, Location, Prof, CurCap, MaxCap) VALUES(?,?,?,?,?,?,?,?)";
    	PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
        pstmt.setString(1, ID); //ID
        pstmt.setBoolean(2, L); //L
        pstmt.setString(3, Days); //Days
        pstmt.setString(4, Time); //Time
        pstmt.setString(5, Location); //Location
        pstmt.setString(7, Prof); //Prof
        pstmt.setInt(8, CurCap); //CurCap
        pstmt.setInt(8, MaxCap); //MaxCap
        pstmt.executeUpdate();
        pstmt.close();
	}

	//-[privately facing UPDATEs]-----------------------------------------------------------------------------
	
	/**
	 * UPDATES a record in Users. Searches by Username.
	 * @param Username of the user
	 * @param Password of the user
	 * @throws SQLException
	 */
	private void UpdateUsers(String Username, String Password) throws SQLException {
		String SQLString = "UPDATE USERS SET Password = ? WHERE Username = ?;";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
		
		//Set the things
		pstmt.setString(1, Password);
		pstmt.setString(2, Username);
		
		pstmt.executeUpdate();
		pstmt.close();		
	}
	
	/**
	 * UPDATES a record in Students. Searches by Student ID.
	 * @param ID Student ID (IE: 802-55-5555)
	 * @param Name Name of the student
	 * @param TiedUsername Username tied to this Student
	 * @param Department Department shortname of this student (IE: INSO)
	 * @param Matriculas Comma separated list of Matricula IDs (IE: 1,2,3,4)
	 * @param PriorityCourses Comma separated list of Priority Courses (IE: DRAM3001, DRAM3002, DRAM3003)
	 * @throws SQLException
	 */
	private void UpdateStudents(String ID, String Name, String TiedUsername, String Department, String Matriculas, String PriorityCourses, String CoursesTaken) throws SQLException {
		String SQLString = "UPDATE Students SET Name = ?, TiedUser = ?, Department = ?, Matriculas = ?, PriorityCourses = ?, CoursesTaken = ? WHERE ID = ?;";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
		
		//Set the things
		pstmt.setString(1, Name);
		pstmt.setString(2, TiedUsername);
		pstmt.setString(3, Department);
		pstmt.setString(4, Matriculas);
		pstmt.setString(5, PriorityCourses);
		pstmt.setString(7, ID);
		pstmt.setString(8, CoursesTaken);
		
		pstmt.executeUpdate();
		pstmt.close();		
	}

	/**
	 * UPDATES a record in Matriculas. Searches by Matricula ID.
	 * @param ID UNIQUE NUMERICAL ID FOR THIS MATRICULA
	 * @param Sections Comma separated list of Section IDs (IE: DRAM3001-020, DRAM3002-020)
	 * @param Period Period of this matricula (One of the following: SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL)
	 * @param Year Year of this Matricula
	 * @throws SQLException
	 */
	private void UpdateMatriculas(int ID, String Sections, String Period, int Year) throws SQLException {
		String SQLString = "UPDATE Matriculas SET Sections = ?, Period = ?, Year= ? WHERE ID = ?;";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
		
		//Set the things
		pstmt.setString(1, Sections);
		pstmt.setString(2, Period);
		pstmt.setInt(3, Year);
		pstmt.setInt(4, ID);
		
		pstmt.executeUpdate();
		pstmt.close();		
	}
	
	
	/**
	 * UPDATES a record in Departments. Searches by ShortName
	 * @param ShortName Department ShortName (IE: INSO)
	 * @param Name Name of this department (IE: Department of Software Engineering)
	 * @throws SQLException
	 */
	private void UpdateDepartments(String ShortName, String Name) throws SQLException {
		String SQLString = "UPDATE Departments SET Name = ? WHERE ID = ?;";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
		
		//Set the things
		pstmt.setString(1, Name);
		pstmt.setString(2, ShortName);
		
		pstmt.executeUpdate();
		pstmt.close();		
	}
	
	/**
	 * UPDATES a record in Courses. Searches by ID and L Flag
	 * @param ID ID of this course (IE: DRAM3001)
	 * @param L L Flag (If this course is a lab)
	 * @param Name Name of this course (IE: Acting I)
	 * @param Credits Credits of this course
	 * @param Prereqs Comma separated list of Course IDs that are Prerequesites (IE: DRAM3000, ENGL3001)
	 * @param Coreqs Comma separated list of  Course IDs that are Corequesites (IE: DRAM3003, ENGL3003)
	 * @throws SQLException
	 */
	private void UpdateCourses(String ID, boolean L, String Name, int Credits, String Prereqs, String Coreqs ) throws SQLException {
		String SQLString = "UPDATE Courses SET Name = ?, Credits = ?, PreReq = ?, CoReq = ? WHERE ID = ? AND L = ?;";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
		
		//Set the things
		pstmt.setString(1, Name);
		pstmt.setInt(2, Credits);
		pstmt.setString(3, Prereqs);
		pstmt.setString(4, Coreqs);
		pstmt.setString(5, ID);
		pstmt.setBoolean(6, L);
		
		pstmt.executeUpdate();
		pstmt.close();		
	}
	
	/**
	 * UPDATES a record in Sections. Searches by ID and L flag
	 * @param ID ID of this Section (IE: DRAM3001-020)
	 * @param L L Flag (If this course is a lab)
	 * @param Days Days this section meets (IE: MWF)
	 * @param Time Times of this course in MILITARY TIME. Split by a DASH (IE: 8:30-9:30)
	 * @param Location Location of this section (IE: STEF512A)
	 * @param Prof Professor of this section (IE: Mr. Caesar)
	 * @param CurCap Current number of students in this section
	 * @param MaxCap Maximum number of students in this section
	 * @throws SQLException
	 */
	private void UpdateSections(String ID, boolean L, String Days, String Time, String Location, String Prof, int CurCap, int MaxCap) throws SQLException {
		String SQLString = "UPDATE Sections SET Days = ?, Time = ?, Location = ?, Prof = ?, CurCap = ?, MaxCap = ? WHERE ID = ? AND L = ?;";
		PreparedStatement pstmt = SQLConn.prepareStatement(SQLString);
		
		//Set the things
		pstmt.setString(1, Days);
		pstmt.setString(2, Time);
		pstmt.setString(3, Location);
		pstmt.setString(4, Prof);
		pstmt.setInt(5, CurCap);
		pstmt.setInt(6, MaxCap);
		pstmt.setString(7, ID);
		pstmt.setBoolean(8, L);
		
		pstmt.executeUpdate();
		pstmt.close();		
	}

	//-[Utilities]-----------------------------------------------------------------------------
	
	/**
	 * Utility to turn a list of courses to a comma separated list of Course IDs
	 * @param Courses
	 * @return
	 */
	public static String ListOfCoursesToString(List<Course> Courses) {
		String ListAsString= "";
		for (Course course : Courses) {
			ListAsString+= "," + course.getDept() + course.getCode(); 
		}
		if(ListAsString.length()>0) {ListAsString=ListAsString.substring(1);} //Handles the first comma		
		return ListAsString;
	}
	
	public static String ListOfSectionsToString(List<Section> Sections) {
		String ListAsString= "";
		for (Section section : Sections) {
			ListAsString+= "," + section.getCourseCode() + "-" + section.getSecNum();
		}
		if(ListAsString.length()>0) {ListAsString=ListAsString.substring(1);} //Handles the first comma		
		return ListAsString;
	}
	
	/**
	 * Utility to turn a list of matriculas into a saved list of comma separated Matricula IDs
	 * @param collection
	 * @return
	 * @throws SQLException 
	 */
	private String ListOfMatriculasToString(Collection<Matricula> collection) throws SQLException {
		String Mats = ""; //TODO UNCOMMENT THIS ONCE STUDENTS HAVE A LIST OF MATRICULAS
		for (Matricula mat : collection) {
			Mats+= "," + SaveMatricula(mat);
		}
		if(Mats.length()>0) {Mats=Mats.substring(1);} //Handles the first comma
		return Mats;
	}
	
}
