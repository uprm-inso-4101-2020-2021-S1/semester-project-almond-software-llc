package macademia.test;

import java.sql.SQLException;

import macademia.Student;
import macademia.db.*;

public class DatabaseTest {

	public static void main(String[] args) {
		Creator.createNewMacademiaDatabase("A:/MacademiaTest.db", true);
		Creator.DummyData("A:/MacademiaTest.db");
		
		//Eventual Save/load test here.
		try {
			DBHandler Handler = LoadEverything("A:/MacademiaTest.db");
			
			//These three lines test everything in the handler.
			
			System.out.println("\n\nGetting Student from Person3\n"); //Loads a student, which also loads their department, and their matriculas (which load sections and a course)
			Student Rob = Handler.getStudent(Handler.getUser("Person3"));
			System.out.println(Rob.toString());
			GeneralTest.PrintStudentDetails("", Rob);
			
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
	public static DBHandler LoadEverything(String Filename) throws SQLException {
		DBHandler Handler = new DBHandler(Filename);
		System.out.println("Loading everything");
		Handler.getDepartments();
		Handler.getAllCourses();
		Handler.getAllSections();
		return Handler;
	}
	
}
