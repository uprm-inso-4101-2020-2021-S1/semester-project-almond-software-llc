package macademia.test;

import macademia.db.*;

public class DatabaseTest {

	public static void main(String[] args) {
		Creator.createNewMacademiaDatabase("A:/MacademiaTest.db", true);
		Creator.DummyData("A:/MacademiaTest.db");
		
		//Eventual Save/load test here.
		
	}
	
}