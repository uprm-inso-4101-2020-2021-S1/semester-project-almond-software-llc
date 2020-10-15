package com.macademia.main.test;


import com.macademia.main.db.*;

public class DatabaseTest {

	public static void main(String[] args) {
		Creator.createNewMacademiaDatabase("A:/MacademiaTest.db", true);
		Creator.DummyData("A:/MacademiaTest.db");
		
		//Eventual Save/load test here.
		
	}
	
}
