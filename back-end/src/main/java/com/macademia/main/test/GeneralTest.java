package com.macademia.main.test;

import java.util.ArrayList;
import java.util.Random;

import com.macademia.main.Course;
import com.macademia.main.Department;
import com.macademia.main.Matricula;
import com.macademia.main.MatriculaPeriod;
import com.macademia.main.Section;
import com.macademia.main.Student;
import com.macademia.main.auth.User;

public class GeneralTest {

	public static void main(String[] args) {
	
		//Lets create a few department
		Department FunLand = new Department("The Department of Comedy", "FUNY","Yellow");
		Department Drama = new Department("The Department of Drama","DRAM","Black");
		
		//Create some courses
		Course COM = new Course("Intro to Comedy", FunLand, "3101", 3); //creating a course with a department links it back to the department.
		Course CL1 = new Course("Clowning I", FunLand, "3401", 3);
		Course CL2 = new Course("Clowning II", FunLand, "3402", 3);
		Course DRK = new Course("Dark Comedy",FunLand,"5102",4);
				
		Course DRAM1 = new Course("Acting 1",Drama,"3001",3);
		Course DRAM2 = new Course("Acting 2",Drama,"3002",3);
		
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
			new Section(rand.nextInt(90)+"", "MWF", "5:30-6:30", "Dr. Test", "S001", course, 1,50); //Creating a section linked to a course automatically links it back to the course.
			new Section(rand.nextInt(90)+"", "TJ", "5:30-7:00", "Dr. Test", "S002", course, 1,50);
			new Section(rand.nextInt(90)+"", "MW", "5:30-7:00", "Dr. Test", "S003", course, 1,50);
		}
		
		//Create a user.
		User Person1 = new User("Person1", "Password");
		User Person2 = new User("Person2", "1234");
		User Person3 = new User("Person3", "This is a password that's very long wow que cool");
		
		//Create some matriculas:
		ArrayList<Section> SectionList1 = new ArrayList<Section>();
		ArrayList<Section> SectionList2 = new ArrayList<Section>();
		ArrayList<Section> SectionList3 = new ArrayList<Section>();
		
		SectionList1.add(COM.getSections().get(0)); SectionList1.add(DRAM1.getSections().get(0));
		SectionList2.add(COM.getSections().get(0)); SectionList2.add(DRAM2.getSections().get(0));
		SectionList3.add(DRAM1.getSections().get(0));

		MatriculaPeriod MatTest = new MatriculaPeriod(2020, "FALL");
		
		Matricula Mat1 = new Matricula(SectionList1, MatTest);
		Matricula Mat2 = new Matricula(SectionList2, MatTest);
		Matricula Mat3 = new Matricula(SectionList3, MatTest);
						
		//Create a student.
		Student Stud1 = new Student(Person1, "El Tipillo", "802-55-5555", FunLand);
		Student Stud2 = new Student(Person2, "La Tipilla", "802-55-5555", FunLand);
		Student Stud3 = new Student(Person3, "Bob", "802-55-5555", Drama);

		Stud1.addMatricula(Mat1);
		Stud2.addMatricula(Mat2);
		Stud3.addMatricula(Mat3);
		
		
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
		System.out.println(Prefix + " |- " + student.getMatriculas().size() + " Matricula(s)");
		for (Matricula Mat : student.getMatriculas()) {
			System.out.println(Prefix + " |  |- MATRICULA: " + Mat.toString());
			PrintMatriculaDetails(Prefix + " |  | ", Mat);			
		}
		System.out.println(Prefix + " =");
	}
	
	public static void PrintMatriculaDetails(String Prefix, Matricula matricula) {
		for (Section s : matricula.getSections()) {PrintSectionDetails(Prefix, s);;}
		System.out.println(Prefix + " =");
	}
	
	// public static void PrintDepartmentDetails(String Prefix, Department department) {
	// 	System.out.println(Prefix + " |- SHORT: " + department.getShortName());
	// 	for (Course course : department.getCatalog().values()) {PrintCourseDetails(Prefix ,course);}
	// 	System.out.println(Prefix + " =");
	// }

	public static void PrintDepartmentDetails(String Prefix, Department department) {
		System.out.println(Prefix + " |- SHORT: " + department.getShortName());
		// for (Course course : department.getCatalog().values()) {PrintCourseDetails(Prefix ,course);}
		// System.out.println(Prefix + " =");
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
