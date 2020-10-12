package macademia.test;

import java.sql.SQLException;

import macademia.Matricula;
import macademia.Student;
import macademia.auth.User;
import macademia.db.*;

public class DatabaseTest {

	public static void main(String[] args) {
		Creator.createNewMacademiaDatabase("A:/MacademiaTest.db", true);
		Creator.DummyData("A:/MacademiaTest.db");
		
		//Eventual Save/load test here.
		try {
			LoadHandler Handler = new LoadHandler("A:/MacademiaTest.db");
			
			//These three lines test everything in the handler.
			
			System.out.println("Getting Person3"); //Loads a user
			User Person3 = Handler.getUser("Person3");
			
			System.out.println("Getting Student from Person3"); //Loads a student, which also loads their department.
			Student Rob = Handler.getStudent(Person3);
			
			System.out.println("Getting Matricula 1"); //Loads a Matricula, which loads a section (which loads a course)
			Matricula Mat1 = Handler.getMatricula(1);
			
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
}
