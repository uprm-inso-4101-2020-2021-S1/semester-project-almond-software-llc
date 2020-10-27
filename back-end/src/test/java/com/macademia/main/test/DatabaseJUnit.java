package com.macademia.main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.macademia.main.Course;
import com.macademia.main.Department;
import com.macademia.main.Matricula;
import com.macademia.main.Section;
import com.macademia.main.Student;
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
	static Matricula MatriculaBeforeSave = new Matricula(new ArrayList<Section>(), 3, "FALL");
	static Department DepartmentBeforeSave = new Department("Drama Department", "DRAM");
	static Course ActingI = new Course("Acting I", DepartmentBeforeSave, "3001", 3);
	static Course ActingII = new Course("Acting II", DepartmentBeforeSave, "3002", 3);
	static Course ActingIII = new Course("Acting III", DepartmentBeforeSave, "3003", 3);
	static Course ActingIV = new Course("Acting IV", DepartmentBeforeSave, "3004", 3);
	static Course Magic = new Course("Acting Magic", DepartmentBeforeSave, "4004", 3);
	static Course MagicLab = new Course("Acting Magic Lab",DepartmentBeforeSave,"4004L",1);
	static Section SectionBeforeSave = new Section("20", "MWF", "8:30-9:30", ActingI);
	static Student StudentBeforeSave = new Student(UserBeforeSave, "Paul", "802-16-4444", MatriculaBeforeSave, DepartmentBeforeSave);
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Creating new macademia database at MacademiaTest.DB");
		Handler = new DBHandler("MacademiaTest.DB",true);
		
		//make sure everything is linked here
		MatriculaBeforeSave.getSections().add(SectionBeforeSave);
		Magic.addPrereq(MagicLab);//TODO: Change this to a coreq later, and make it a priority course for the student.
		Magic.addPrereq(ActingIV); 
		ActingII.addPrereq(ActingI);
		ActingIII.addPrereq(ActingII);
		ActingIV.addPrereq(ActingIII);
		
		//TODO: Make sure that everything is linked up properly after Francis's refactoring of course, section
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Order(1)
	void UserTest() throws Exception {
		Handler.SaveUser(UserBeforeSave); //Save the user
		assert(Handler.UserExists(UserBeforeSave.getUsername())); //Verify that the user now exists in the database
		
		User UserAfterSave = Handler.getUser(UserBeforeSave.getUsername()); //Load the user
		
		//Verify username and password are the same
		assertEquals(UserBeforeSave.getUsername(), UserAfterSave.getUsername()); 
		assertEquals(UserBeforeSave.getPassword(), UserAfterSave.getPassword());
	}
	
	@Test
	@Order(2)
	void StudentsTest() throws Exception {
		Handler.SaveStudent(StudentBeforeSave); //Save the student
		assert(Handler.StudentExists(StudentBeforeSave.getStudentNumber())); //Assert the student exists in the database.
		
		Student StudentAfterSave = Handler.getStudent(StudentBeforeSave.getStudentNumber()); //Load the student
		
		//Verify they are the same
		assertEquals(StudentBeforeSave.getUsername(), StudentAfterSave.getUsername());
		assertEquals(StudentBeforeSave.getPassword(), StudentAfterSave.getPassword());
		assertEquals(StudentBeforeSave.getName(), StudentAfterSave.getName());
		assertEquals(StudentBeforeSave.getStudentNumber(), StudentAfterSave.getStudentNumber());
		
		//TODO: Check Priority Courses when they are added.
		//TODO: Check list of matriculas is the same (at least IDs. Checking matriculas save is not the responsibility of this test)
		
		
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
		
		
		//TODO: Verify Year once added
		
	}
	
	@Test
	@Order(3)
	void DepartmentsTest()  throws Exception {
		Handler.SaveDepartment(DepartmentBeforeSave); //Save the department
		
		assert(Handler.DepartmentExists(DepartmentBeforeSave.getShortName())); //Verify the department exists
		
		Department DepartmentAfterSave = Handler.getDepartment(DepartmentBeforeSave.getShortName()); //Load the department
		
		//Verify that they are the same
		assertEquals(DepartmentBeforeSave.getShortName(), DepartmentAfterSave.getShortName());
		assertEquals(DepartmentBeforeSave.getName(), DepartmentAfterSave.getName());
		
	}


	@Test
	@Order(4)
	void NoPrereqCourseTest()  throws Exception {CourseTester(ActingI);}
	
	@Test
	@Order(5)
	void PrereqCourseTest()  throws Exception {CourseTester(Magic);}
	
	@Test
	@Order(6)
	void LabCourseTest()  throws Exception {CourseTester(MagicLab);}
	
	void CourseTester(Course CourseBeforeSaving) throws Exception{
		Handler.SaveCourse(CourseBeforeSaving); //Save the course
		
		String CourseID = CourseBeforeSaving.getDept().getShortName()+CourseBeforeSaving.getCode(); //TODO: Update this to the new department shortstring accessor.
		
		assert(Handler.CourseExists(CourseID)); //verify the course exists
		
		Course CourseAfterSaving = Handler.getCourse(CourseID); //Load the course
		
		//Verify that its the same:
		assertEquals(CourseBeforeSaving.getCode(), CourseAfterSaving.getCode());
		assertEquals(CourseBeforeSaving.getDept().getShortName(), CourseAfterSaving.getDept().getShortName());
		assertEquals(CourseBeforeSaving.getCredits(), CourseAfterSaving.getCredits());
		
		assertEquals(CourseBeforeSaving.getPrereq().size(), CourseBeforeSaving.getPrereq().size());
		for (int i = 0; i < CourseBeforeSaving.getPrereq().size(); i++) {
			assertEquals(CourseBeforeSaving.getPrereq().get(i).getCode(), CourseAfterSaving.getPrereq().get(i).getCode());
		}//TODO: do the same for Coreq
		
		assertEquals(CourseBeforeSaving.getSections().size(), CourseAfterSaving.getSections().size());
		for (int i = 0; i < CourseBeforeSaving.getSections().size(); i++) {
			assertEquals(CourseBeforeSaving.getSections().get(i).getSecNum(), CourseAfterSaving.getSections().get(i).getSecNum());
		}
		
	}
	
	@Test
	@Order(7)
	void SectionsTest() throws Exception {
		Handler.SaveSeciton(SectionBeforeSave); //Save section
		String SectionID = SectionBeforeSave.getCourse().getDept().getShortName()+SectionBeforeSave.getCourse().getCode()+"-"+SectionBeforeSave.getSecNum();
		
		assert(Handler.SectionExists(SectionID)); //Assert the section exists
		
		Section SectionAfterSave = Handler.getSection(SectionID); //Load the section
		
		//Verify that its the same.
		assertEquals(SectionBeforeSave.getDay(), SectionAfterSave.getDay());
		assertEquals(SectionBeforeSave.getSecNum(), SectionAfterSave.getSecNum());
		assertEquals(SectionBeforeSave.getTime(), SectionAfterSave.getTime()); //TODO: Switch to period once its done
		assertEquals(SectionBeforeSave.getCourse().getCode(), SectionAfterSave.getCourse().getCode());
		
		//TODO: Assert Location, Prof, CurCap, and MaxCap once added
		
		
		
		
	}

}
