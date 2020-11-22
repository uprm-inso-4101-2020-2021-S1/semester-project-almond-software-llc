package com.macademia.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.macademia.main.Course;
import com.macademia.main.Department;
import com.macademia.main.Matricula;
import com.macademia.main.MatriculaPeriod;
import com.macademia.main.Section;
import com.macademia.main.Student;
import com.macademia.main.Turn;
import com.macademia.main.auth.User;
import com.macademia.main.db.DBHandler;

@TestMethodOrder(OrderAnnotation.class)
class DatabaseJUnit {

	/**
	 * Handler that will be tested
	 */
	public static DBHandler Handler;
	
	//Static values that will be used for testing:
	static User UserBeforeSave = new User("Igtampe","1234"); //Prepare a user
	static MatriculaPeriod MatPeriodBeforeSave = new MatriculaPeriod(2020, "FALL");
	static Matricula MatriculaBeforeSave = new Matricula(MatPeriodBeforeSave);
	static Department DepartmentBeforeSave = new Department("Drama Department", "DRAM","Red");
	static Course ActingI = new Course("Acting I", DepartmentBeforeSave, "3001", 3);
	static Course ActingII = new Course("Acting II", DepartmentBeforeSave, "3002", 3);
	static Course ActingIII = new Course("Acting III", DepartmentBeforeSave, "3003", 3);
	static Course ActingIV = new Course("Acting IV", DepartmentBeforeSave, "3004", 3);
	static Course Magic = new Course("Acting Magic", DepartmentBeforeSave, "4004", 3);
	static Course MagicLab = new Course("Acting Magic Lab",DepartmentBeforeSave,"4004L",1);
	static Section SectionBeforeSave = new Section("020", "MWF", "8:30 - 9:30", "Yang Lee", "STEF302", ActingII, 1,30);
	static Student StudentBeforeSave = new Student(UserBeforeSave, "Paul", "802-16-4444", DepartmentBeforeSave);
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Creating new macademia database at MacademiaTest.DB");
		Handler = new DBHandler("MacademiaTest.DB",true);
		
		//make sure everything is linked here
		MatriculaBeforeSave.addSection(SectionBeforeSave, ActingII);
		Magic.addCoreq(MagicLab);
		Magic.addPrereq(ActingIV); 
		ActingII.addPrereq(ActingI);
		ActingIII.addPrereq(ActingII);
		ActingIV.addPrereq(ActingIII);
		StudentBeforeSave.addPriority(MagicLab);

		ActingI.setDescription("Introduction to acting");
		ActingI.setAvailability("Every year, First Semester");
		
		ActingII.setDescription("Advanced Acting Techniques. The art of Crying on Command");
		ActingII.setAvailability("Every year, Second Semester");
		
		ActingIII.setDescription("Acting like A gender you're not. Love scenes");
		ActingIII.setAvailability("Every year, First Semester");
		
		ActingIV.setDescription("Unnatural Acting");
		ActingIV.setAvailability("Every year, Second Semester");
		
		Magic.setDescription("Hocus Pocus One o One-us");
		Magic.setAvailability("Even Years, First Semester");
		
		MagicLab.setDescription("This is where you do things the college will be sued for");
		MagicLab.setAvailability("Even Years, First Semester");
		
		StudentBeforeSave.SetTurn(new Turn("1/1/2001 1:00-2/2/2002 2:00"));
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Order(6)
	void UserTest() throws Exception {
		Handler.SaveUser(UserBeforeSave); //Save the user
		assert(Handler.UserExists(UserBeforeSave.getUsername())); //Verify that the user now exists in the database
		
		User UserAfterSave = Handler.getUser(UserBeforeSave.getUsername()); //Load the user
		
		//Verify username and password are the same
		assertEquals(UserBeforeSave.getUsername(), UserAfterSave.getUsername()); 
		assertEquals(UserBeforeSave.getPassword(), UserAfterSave.getPassword());
	}
	
	@Test
	@Order(7)
	void StudentsTest() throws Exception {
		Handler.SaveStudent(StudentBeforeSave); //Save the student
		assert(Handler.StudentExists(StudentBeforeSave.getStudentNumber())); //Assert the student exists in the database.
		
		Student StudentAfterSave = Handler.getStudent(StudentBeforeSave.getStudentNumber()); //Load the student
		
		//Verify they are the same
		assertEquals(StudentBeforeSave.getUsername(), StudentAfterSave.getUsername());
		assertEquals(StudentBeforeSave.getPassword(), StudentAfterSave.getPassword());
		assertEquals(StudentBeforeSave.getName(), StudentAfterSave.getName());
		assertEquals(StudentBeforeSave.getStudentNumber(), StudentAfterSave.getStudentNumber());
		
		assertEquals(StudentBeforeSave.getPriority().size(), StudentAfterSave.getPriority().size());
		
		for (int i = 0; i < StudentBeforeSave.getPriority().size(); i++) {
			assertEquals(StudentBeforeSave.getPriority().get(i).getCode(), StudentBeforeSave.getPriority().get(i).getCode());
		}
		
		assertEquals(StudentBeforeSave.getMatriculas().size(), StudentAfterSave.getMatriculas().size());
		assertEquals(StudentBeforeSave.getTurn(), StudentAfterSave.getTurn());
		
	}
	
	@Test
	@Order(8)
	void MatriculasTest()  throws Exception {
		int ID = Handler.SaveMatricula(MatriculaBeforeSave); //Save the matricula
		
		assert(Handler.MatriculaExists(ID)); //Assert the matricula exists.
		
		Matricula MatriculaAfterSave = Handler.getMatricula(ID); //Load the matricula
		
		//Verify they are the same
		assertEquals(MatriculaBeforeSave.getPeriod(), MatriculaAfterSave.getPeriod());
		assertEquals(MatriculaBeforeSave.getID(), MatriculaAfterSave.getID()); //this will fail if the ID isn't updated on the original ref.
		
		assertEquals(MatriculaBeforeSave.getSections().size(), MatriculaAfterSave.getSections().size());
		
		for (int i = 0; i < MatriculaBeforeSave.getSections().size(); i++) {
			assertEquals(MatriculaBeforeSave.getSections().get(i).toString(), MatriculaAfterSave.getSections().get(i).toString());
		}

		for (int i = 0; i < MatriculaBeforeSave.getCourses().size(); i++) {
			assertEquals(MatriculaBeforeSave.getCourses().get(i).toString(), MatriculaAfterSave.getCourses().get(i).toString());
		}

		assertEquals(MatriculaBeforeSave.getReadOnly(), MatriculaAfterSave.getReadOnly());
	}
	
	@Test
	@Order(1)
	void DepartmentsTest()  throws Exception {
		Handler.SaveDepartment(DepartmentBeforeSave); //Save the department
		
		assert(Handler.DepartmentExists(DepartmentBeforeSave.getShortName())); //Verify the department exists
		
		Department DepartmentAfterSave = Handler.getDepartment(DepartmentBeforeSave.getShortName()); //Load the department
		
		//Verify that they are the same
		assertEquals(DepartmentBeforeSave.getShortName(), DepartmentAfterSave.getShortName());
		assertEquals(DepartmentBeforeSave.getName(), DepartmentAfterSave.getName());
		assertEquals(DepartmentBeforeSave.GetColor(), DepartmentAfterSave.GetColor());
		
	}


	@Test
	@Order(2)
	void NoPrereqCourseTest()  throws Exception {CourseTester(ActingI);}
	
	@Test
	@Order(3)
	void PrereqCourseTest()  throws Exception {CourseTester(Magic);}
	
	@Test
	@Order(4)
	void LabCourseTest()  throws Exception {CourseTester(MagicLab);}
	
	void CourseTester(Course CourseBeforeSaving) throws Exception{
		Handler.SaveCourse(CourseBeforeSaving); //Save the course
		
		String CourseID = CourseBeforeSaving.getDept()+CourseBeforeSaving.getCode();
		
		assert(Handler.CourseExists(CourseID)); //verify the course exists
		
		Course CourseAfterSaving = Handler.getCourse(CourseID); //Load the course
		
		//Verify that its the same:
		assertEquals(CourseBeforeSaving.getCode(), CourseAfterSaving.getCode());
		assertEquals(CourseBeforeSaving.getDept(), CourseAfterSaving.getDept());
		assertEquals(CourseBeforeSaving.getCredits(), CourseAfterSaving.getCredits());
		
		assertEquals(CourseBeforeSaving.getPrereq().size(), CourseBeforeSaving.getPrereq().size());
		for (int i = 0; i < CourseBeforeSaving.getPrereq().size(); i++) {
			assertEquals(CourseBeforeSaving.getPrereq().get(i).getCode(), CourseAfterSaving.getPrereq().get(i).getCode());
		}
		
		for (int i = 0; i < CourseBeforeSaving.getCoreq().size(); i++) {
			assertEquals(CourseBeforeSaving.getCoreq().get(i).getCode(), CourseAfterSaving.getCoreq().get(i).getCode());
		}

		
		assertEquals(CourseBeforeSaving.getSections().size(), CourseAfterSaving.getSections().size());
		for (int i = 0; i < CourseBeforeSaving.getSections().size(); i++) {
			assertEquals(CourseBeforeSaving.getSections().get(i).getSecNum(), CourseAfterSaving.getSections().get(i).getSecNum());
		}
		
		assertEquals(CourseBeforeSaving.getColor(), CourseAfterSaving.getColor());
		assertEquals(CourseBeforeSaving.getDescription(), CourseAfterSaving.getDescription());
		assertEquals(CourseBeforeSaving.getAvailability(), CourseAfterSaving.getAvailability());
		
	}
	
	@Test
	@Order(5)
	void SectionsTest() throws Exception {
		Handler.SaveSeciton(SectionBeforeSave); //Save section
		String SectionID = SectionBeforeSave.getCourseCode()+"-"+SectionBeforeSave.getSecNum();
		
		assert(Handler.SectionExists(SectionID)); //Assert the section exists
		
		Section SectionAfterSave = Handler.getSection(SectionID); //Load the section
		
		//Verify that its the same.
		assertEquals(SectionBeforeSave.getDay(), SectionAfterSave.getDay());
		assertEquals(SectionBeforeSave.getSecNum(), SectionAfterSave.getSecNum());
		assertEquals(SectionBeforeSave.getTime(), SectionAfterSave.getTime()); //No need to test period, since its generated from Time.
		assertEquals(SectionBeforeSave.getCourseCode(), SectionAfterSave.getCourseCode());
		assertEquals(SectionBeforeSave.getLocation(), SectionAfterSave.getLocation());
		assertEquals(SectionBeforeSave.getProfessor(), SectionAfterSave.getProfessor());
		assertEquals(SectionBeforeSave.getPopulation(), SectionAfterSave.getPopulation());
		assertEquals(SectionBeforeSave.getCapacity(), SectionAfterSave.getCapacity());
		assertEquals(SectionBeforeSave.getColor(), SectionAfterSave.getColor());
	}

}
