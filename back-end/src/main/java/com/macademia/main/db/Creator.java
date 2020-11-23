package com.macademia.main.db;

import java.sql.Connection;  
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.io.File;

/**
 * Holder for Creating Macademia Databases. Run it to create a new Macademia.DB in the current folder.
 * @author igtampe
 */
public class Creator {
	
	/**
	 * Creates a Macademia Database at the specified filename. If overwrite is true, and it finds a db, it deletes it.
	 * @param fileName
	 * @param Overwrite
	 */
    public static void createNewMacademiaDatabase(String fileName, boolean Overwrite) {  
    	   
        String url = "jdbc:sqlite:" + fileName;  
   
        if(new File(fileName).exists() && Overwrite) {new File(fileName).delete();}
        
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn == null) { return; } //Make sure to catch this if it happens.
            Statement State = conn.createStatement();
            
            System.out.println("Creating Users table.");            
            /*
             * Username
             * Password (Encryption?)
             */
            State.execute("CREATE TABLE IF NOT EXISTS Users (Username VarChar(50), Password VarChar(50));");

            System.out.println("Creating Students Table.");
            /*
             * ID (STUDENT ID), 
             * NAME (Name of the student)
             * TIEDUSER (Username of user tied to the account), 
             * DEPARTMENT (Short name of dep), 
             * MATRICULAS (Comma separated list of IDs of Matriculas), 
             * PriorityCourses (Comma separated list of Course IDs (IE ICOM4101) that are priority)
             * CoursesTaken (Comma Separated list of Courses taken)
             * TURN (parsable string for a turn)
             */
            State.execute("CREATE TABLE IF NOT EXISTS Students (ID Char(11), Name VarChar(100), TiedUser VarChar(50), Department Char(4), Matriculas VarChar(" + Integer.MAX_VALUE + "), PriorityCourses VarChar(" + Integer.MAX_VALUE + "), CoursesTaken VarChar("+Integer.MAX_VALUE+"), Turn VarChar(" + Integer.MAX_VALUE + "));"); 

            System.out.println("Creating Matriculas Table.");
            /*
             * ID (Unique ID for this Matricula)
             * SECTIONS (Comma separated list of course sections (IE ICOM4101-20))
             * PERIOD (FALL, SPRING, SUMMER1,SUMMER2, EXTENDED_SUMMER)
             * YEAR (2020)
             * READONLY
             */
            State.execute("CREATE TABLE IF NOT EXISTS Matriculas (ID int, Sections VarChar(" + Integer.MAX_VALUE + "),Period VarChar(20), Year int, ReadOnly bool);");

            System.out.println("Creating Departments table.");            
            /*
             * ID (INSO), 
             * Name (Department of Software Engineering)
             */
            State.execute("CREATE TABLE IF NOT EXISTS Departments (ID Char(4), Name VarChar(75), Color VarChar(75));");
            
            System.out.println("Creating Courses Table.");
            /*
             * ID (INSO4101), 
             * L (Boolean for Lab), 
             * NAME (Intro to Soft...), 
             * CREDITS (3), 
             * PREREQ (Comma separated list of class IDs), 
             * COREQ (See Prereq)
             * DESCRIPTION (Description of the course)
             * AVAILABILITY (Semesters/Years this course is available during)
             */
            State.execute("CREATE TABLE IF NOT EXISTS Courses (ID Char(8), L bool , Name VarChar(75), Credits int, Prereq VarChar(" + Integer.MAX_VALUE + "), CoReq VarChar(" + Integer.MAX_VALUE + "), Description VarChar(" + Integer.MAX_VALUE + "), Availability VarChar(" + Integer.MAX_VALUE + "));");
            
            System.out.println("Creating Sections Table.");
            /*
             * ID (INSO4101-020), 
             * L (Bool for lab), 
             * DAYS (MWF), 
             * TIME (3:30 to 4:30), 
             * LOCATION (STEF 401), 
             * PROF (Someone), 
             * CurCap (Current Capacity), 
             * MaxCap (Maximum Capacity)
             */
            State.execute("CREATE TABLE IF NOT EXISTS Sections (ID Char(12), L Bool, DAYS VarChar(7), TIME VarChar(20), LOCATION VarChar(20), PROF VarChar(50) , CurCap int, MaxCap int);");
            
   
        } catch (SQLException e) {System.out.println(e.getMessage());}  
    }
    
    @Deprecated
    /**
     * Adds dummy data to a pre-existing Macademia Database
     * @param fileName
     */
    public static void DummyData(String fileName) {
    	if(!new File(fileName).exists()) {
    		System.out.println("Filename does not exist! Creating Macademia database there \n\n");
    		createNewMacademiaDatabase(fileName, false);
    		System.out.println("\n\n OK Done! Now onto adding the database:");
    	}
    	
    	String url = "jdbc:sqlite:" + fileName;
    	
    	//This is for new records. We need to use UPDATE to save students already in the database
    	String Department = "INSERT INTO Departments(ID, Name) VALUES(?,?)";
    	String Course = "INSERT INTO Courses(ID, L, Name, Credits, Prereq, Coreq) VALUES(?,?,?,?,?,?)";
    	String Section =  "INSERT INTO Sections(ID, L, Days, Time, Location, Prof, CurCap, MaxCap) VALUES(?,?,?,?,?,?,?,?)";
    	String User = "INSERT INTO Users(Username, Password) VALUES(?,?)";
    	String Student = "INSERT INTO Students(ID, Name, TiedUser, Department, Matriculas, PriorityCourses) VALUES(?,?,?,?,?,?)";
    	String Matricula = "INSERT INTO Matriculas(ID, Sections, Period, Year) VALUES(?,?,?,?)";
    	   
        try{  
            Connection conn = DriverManager.getConnection(url);
            
            //add Drama
            System.out.println("Adding Drama department");
            PreparedStatement pstmt = conn.prepareStatement(Department);  
            pstmt.setString(1, "DRAM");  //Short Name
            pstmt.setString(2, "Department of Drama"); //Name  
            pstmt.executeUpdate();  

            //add Drama Courses
            System.out.println("Adding Acting I");
            pstmt = conn.prepareStatement(Course);
            pstmt.setString(1, "DRAM3001"); //ID
            pstmt.setBoolean(2, false); //Lab
            pstmt.setString(3, "Acting I"); //Name
            pstmt.setInt(4, 3); //Credits
            pstmt.setString(5, ""); //Prereqs
            pstmt.setString(6, ""); //Coreqs
            pstmt.executeUpdate();

            System.out.println("Adding Acting II");
            pstmt = conn.prepareStatement(Course);
            pstmt.setString(1, "DRAM3002");
            pstmt.setBoolean(2, false);
            pstmt.setString(3, "Acting II");
            pstmt.setInt(4, 3);
            pstmt.setString(5, "DRAM3001");
            pstmt.setString(6, "");
            pstmt.executeUpdate();
            
            //Add Drama Section
            System.out.println("Adding DRAM3001-020");
            pstmt = conn.prepareStatement(Section);
            pstmt.setString(1, "DRAM3001-020"); //ID
            pstmt.setBoolean(2, false); //L
            pstmt.setString(3, "MWF"); //Days
            pstmt.setString(4, "8:30-9:30"); //Time
            pstmt.setString(5, "STEF512A"); //Location
            pstmt.setString(7, "Mr. Caesar"); //Prof
            pstmt.setInt(8, 1); //CurCap
            pstmt.setInt(8, 30); //MaxCap
            pstmt.executeUpdate();
            
            //Add User:
            System.out.println("Adding Person3");
            pstmt = conn.prepareStatement(User);
            pstmt.setString(1, "Person3"); //Username
            pstmt.setString(2, "This is a password that's very long wow que cool"); //Password (maybe encrypted)
            pstmt.executeUpdate();
            
            //Add Student
            System.out.println("Robert Robertson Robington");
            pstmt = conn.prepareStatement(Student);
            pstmt.setString(1, "802-555-5555"); //ID
            pstmt.setString(2, "Robert Robertson Robington"); //Name
            pstmt.setString(3, "Person3"); //TiedUser
            pstmt.setString(4, "DRAM"); //Department
            pstmt.setString(5, "1"); //Matriculas
            pstmt.setString(6, "DRAM3002"); //PriorityCourses
            pstmt.executeUpdate();
            
            //Add Matricula
            System.out.println("Adding Matricula 1");
            pstmt = conn.prepareStatement(Matricula);
            pstmt.setInt(1, 1);//ID
            pstmt.setString(2, "DRAM3001-020");//SECTIONS
            pstmt.setString(3, "FALL");//PERIOD
            pstmt.setInt(4,2020);//YEAR
            pstmt.executeUpdate();
            
        } catch (SQLException e) {System.out.println(e.getMessage());}  
    }
  
    public static void main(String[] args) {  createNewMacademiaDatabase("Macademia.db",true);}  
}
