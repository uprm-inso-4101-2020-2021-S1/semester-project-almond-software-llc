package com.macademia.main.test;

import java.util.ArrayList;
import java.util.Random;

import com.macademia.main.Course;
import com.macademia.main.Department;
import com.macademia.main.Matricula;
import com.macademia.main.Section;
import com.macademia.main.Student;
import com.macademia.main.auth.User;

public class GeneralTest {

	public static void main(String[] args) {
	
		//Lets create a few department
		Department FunLand = new Department("The Department of Comedy", "FUNY");
		Department Drama = new Department("The Department of Drama","DRAM");
		
		//Create some courses
		Course COM = new Course("Intro to Comedy", FunLand, 3101, 3); //creating a course with a department links it back to the department.
		Course CL1 = new Course("Clowning I", FunLand, 3401, 3);
		Course CL2 = new Course("Clowning II", FunLand, 3402, 3);
		Course DRK = new Course("Dark Comedy",FunLand,5102,4);
				
		Course DRAM1 = new Course("Acting 1",Drama,3001,3);
		Course DRAM2 = new Course("Acting 2",Drama,3002,3);
		
		Course[] AllClasses = {COM,CL1,CL2,DRK,DRAM1,DRAM2};
		
		//Prerequesite time.
		DRAM2.addPrereq(DRAM1);
		CL1.addPrereq(DRAM2);
		CL1.addPrereq(COM);
		CL2.addPrereq(CL1);
		DRK.addPrereq(CL2);
		
		//Lets create some sections for these courses
		Random rand = new Random();
		for (Course course : AllClasses) {
			new Section(rand.nextInt(90)+"", "MWF", "5:30-6:30", course); //Creating a section linked to a course automatically links it back to the course.
			new Section(rand.nextInt(90)+"", "TJ", "5:30-7:00", course);
			new Section(rand.nextInt(90)+"", "MW", "5:30-7:00", course);
		}
		
		//Create a user.
		User Person1 = new User("Person1", "Password");
		User Person2 = new User("Person2", "1234");
		User Person3 = new User("Person3", "This is a password that's very long wow que cool");
		
		//Create some matriculas:
		ArrayList<Course> CourseList1 = new ArrayList<Course>();
		ArrayList<Course> CourseList2 = new ArrayList<Course>();
		ArrayList<Course> CourseList3 = new ArrayList<Course>();
		
		CourseList1.add(COM); CourseList1.add(DRAM1);
		CourseList2.add(COM); CourseList2.add(DRAM2);
		CourseList3.add(DRAM1);

		Matricula Mat1 = new Matricula(CourseList1, "FALL");
		Matricula Mat2 = new Matricula(CourseList2, "FALL");
		Matricula Mat3 = new Matricula(CourseList3, "FALL");
				
		//Create a student.
		Student Stud1 = new Student(Person1, "El Tipillo", "802-55-5555", Mat1, FunLand);
		Student Stud2 = new Student(Person2, "La Tipilla", "802-55-5555", Mat2, FunLand);
		Student Stud3 = new Student(Person3, "Bob", "802-55-5555", Mat3, Drama);
		
		Student[] AllStudents = {Stud1,Stud2,Stud3};
		
		//I think that's everything.
		
		//now lets see something.
		for (Student student : AllStudents) {
			System.out.println(student.toString());
			PrintStudentDetails("", student);
			System.out.println();
			System.out.println();
		}
		
		
	}
	
	public static void PrintStudentDetails(String Prefix, Student student){
		System.out.println(Prefix + " |- USERNAME: " + student.getUsername());
		System.out.println(Prefix + " |- DEPARTMENT: " + student.getDepartment().toString());
		PrintDepartmentDetails(Prefix + " | ", student.getDepartment());
		System.out.println(Prefix + " |- MATRICULA: " + student.getMatricula().toString());
		PrintMatriculaDetails(Prefix + " | ", student.getMatricula());
		System.out.println(Prefix + " =");
	}
	
	public static void PrintMatriculaDetails(String Prefix, Matricula matricula) {
		for (Course course : matricula.getCourses()) {PrintCourseDetails(Prefix ,course);}
		System.out.println(Prefix + " =");
	}
	
	public static void PrintDepartmentDetails(String Prefix, Department department) {
		System.out.println(Prefix + " |- SHORT: " + department.getShortName());
		for (Course course : department.getCatalog().values()) {PrintCourseDetails(Prefix ,course);}
		System.out.println(Prefix + " =");
	}

	public static void PrintCourseDetails(String Prefix, Course course) {
		System.out.println(Prefix + " |- COURSE: " + course.toString());
		System.out.println(Prefix + " |  |- " + course.getSections().size()  + " SECTION(S)");
		for (Section section : course.getSections()) {PrintSectionDetails(Prefix+ " |  | ", section);}
		System.out.println(Prefix + " |  | " + course.getPrereq().size()  + " PREREQUESITE(S)");
		for (Course prereq : course.getPrereq()) {PrintCourseDetails(Prefix + " |  | " ,prereq);}
		System.out.println(Prefix + " |  =");
		System.out.println(Prefix + " =");
	}
	
	public static void PrintSectionDetails(String Prefix, Section section) {
		System.out.println(Prefix + " |-" + section.toString());
	}
	
	
}
