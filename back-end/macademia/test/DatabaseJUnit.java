package macademia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.internal.org.objectweb.asm.Handle;
import macademia.auth.User;
import macademia.db.DBHandler;

class DatabaseJUnit {

	public static DBHandler Handler;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Creating new macademia database at MacademiaTest.DB");
		Handler = new DBHandler("MacademiaTest.DB",true);
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void UserTest() {
		User UserBeforeSave = new User("Igtampe","1234");
		
		
	}
	
	@Test
	void StudentsTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void MatriculasTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void DepartmentsTest() {
		fail("Not yet implemented");
	}

	
	@Test
	void CoursesTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void SectionsTest() {
		fail("Not yet implemented");
	}

}
