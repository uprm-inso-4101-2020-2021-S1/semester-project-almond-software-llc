package macademia.db;

import java.sql.Connection;  
import java.sql.Statement;
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class Creator {
	
    public static void createNewMacademiaDatabase(String fileName) {  
    	   
        String url = "jdbc:sqlite:" + fileName;  
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn == null) { return; } //Make sure to catch this if it happens.
            Statement State = conn.createStatement();
            
            System.out.println("Creating Users table.");            
            //Username and password. Are we going to encrypt this? 
            State.execute("CREATE TABLE IF NOT EXISTS Users (Username VarChar(50), Password VarChar(50));");

            System.out.println("Creating Students Table.");
            //ID (STUDENT ID), TIEDUSER (Username of user tied to the account), DEPARTMENT (Short name of dep), MATRICULAS (Comma separated list of IDs of Matriculas), PriorityCourses (Comma separated list of Course IDs (IE ICOM4101) that are priority)
            State.execute("CREATE TABLE IF NOT EXISTS Students (ID Char(9), TiedUser VarChar(50), Department Char(4), Matriculas VarChar(" + Integer.MAX_VALUE + "), PriorityCourses VarChar(" + Integer.MAX_VALUE + "));"); 

            System.out.println("Creating Matriculas Table.");
            //ID (Unique ID for this Matricula), SECTIONS (Comma separated list of course sections (IE ICOM4101-20)).
            State.execute("CREATE TABLE IF NOT EXISTS Matriculas (ID int, Sections VarChar(" + Integer.MAX_VALUE + "));");
            
            System.out.println("Creating Courses Table.");
            //ID (INSO4101), L (Boolean for Lab), NAME (Intro to Soft...), CREDITS (3), PREREQ (Comma separated list of class IDs), COREQ (See Prereq), Sections (Comma Separated list of Sections (IE 20,30,40,50))
            State.execute("CREATE TABLE IF NOT EXISTS Courses (ID Char(8), L bool , Name VarChar(75), Credits int, Prereq VarChar(" + Integer.MAX_VALUE + "), CoReq VarChar(" + Integer.MAX_VALUE + "), Sections VarChar(" + Integer.MAX_VALUE + "));");

            //We don't necessarily need to save department as a separate thing. The loader can trim out the frist 4 characters and use it as an ID for the department
            
            System.out.println("Creating Sections Table.");
            //ID (INSO4101-020), L (Bool for lab), DAYS (MWF), TIME (3:30 to 4:30), LOCATION (STEF 401), PROF (Someone), CurCap (Current Capacity), MaxCap (Maximum Capacity)
            State.execute("CREATE TABLE IF NOT EXISTS Sections (ID Char(12), L Bool, DAYS VarChar(7), TIME VarChar(20), LOCATION VarChar(20), PROF VarChar(50) , CurCap int, MaxCap int);");
            
            //No need to store the course. That can be grabbed from the first 8 characters and L.
            
            //I think with that we have all needed tables.
   
        } catch (SQLException e) {System.out.println(e.getMessage());}  
    }  
  
    public static void main(String[] args) {  createNewMacademiaDatabase("Macademia.db");}  
}
