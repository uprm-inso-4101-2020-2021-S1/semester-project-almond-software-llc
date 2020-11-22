package com.macademia.main.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.macademia.main.*;
import com.macademia.main.auth.User;
import com.macademia.main.db.DBHandler;

enum per {
    SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL;
}

public class JsonTest {

    public DBHandler db;

    public MatriculaPeriod testPeriodA = new MatriculaPeriod(2021, "FALL");
    public MatriculaPeriod testPeriodB = new MatriculaPeriod(2021, "SPRING");
    public MatriculaPeriod testPeriodC = new MatriculaPeriod(2022, "FALL");
    public List<Section> testList = new ArrayList<Section>();
    public Matricula testMatriculaB = new Matricula(testPeriodB);
    public Matricula testMatriculaC = new Matricula(testPeriodC);
    public Department testPrereqDepartment = new Department("The Department of Testing Prerequisites", "TPRQ", "Black");
    public Department testCoreqDepartment = new Department("The Department of Testing Corequisites", "TCRQ", "Gray");
    public Department testCoursesTakenDepartment = new Department("The Department of Testing Courses Taken", "TTKN", "Cyan");
    public Department testDepartmentA = new Department("The Department of Testing A", "TSTA", "Green");
    public Department testDepartmentB = new Department("The Department of Testing B", "TSTB", "Purple");
    public Department testDepartmentC = new Department("The Department of Testing C", "TSTC", "Red");
    public Department testDepartmentD = new Department("The Department of Testing D", "TSTD", "Blue");

    public User testUserA = new User("testA", "6969");
    public Student testStudentA = new Student(testUserA, "Test McTesterson", "420-77-6969", testDepartmentA);

    public Course testPrereqCourseA = new Course("Test Prerequisite Course A", testPrereqDepartment, "4001", 1);
    public Course testPrereqCourseB = new Course("Test Prerequisite Course B", testPrereqDepartment, "3002", 2);
    public Course testPrereqCourseC = new Course("Test Prerequisite Course C", testPrereqDepartment, "2003", 3);
    public Course testPrereqCourseD = new Course("Test Prerequisite Course D", testPrereqDepartment, "1004", 4);

    public Course testCoreqCourseA = new Course("Test Corequisite Course A", testCoreqDepartment, "4004", 1);
    public Course testCoreqCourseB = new Course("Test Corequisite Course B", testCoreqDepartment, "3003", 2);
    public Course testCoreqCourseC = new Course("Test Corequisite Course C", testCoreqDepartment, "2002", 3);
    public Course testCoreqCourseD = new Course("Test Corequisite Course D", testCoreqDepartment, "1001", 4);

    public Course testCourseTakenA = new Course("Test Course Taken A", testCoursesTakenDepartment, "7001", 3);
    public Course testCourseTakenB = new Course("Test Course Taken B", testCoursesTakenDepartment, "7002", 3);
    public Course testCourseTakenC = new Course("Test Course Taken C", testCoursesTakenDepartment, "7003", 3);
    public Course testCourseTakenD = new Course("Test Course Taken D", testCoursesTakenDepartment, "7004", 3);

    public Course testCourseA = new Course("Test Course A", testDepartmentA, "4023", 1);
    public Course testCourseB = new Course("Test Course B", testDepartmentA, "3024", 2);
    public Course testCourseC = new Course("Test Course C", testDepartmentA, "2025", 3);
    public Course testCourseD = new Course("Test Course D", testDepartmentA, "1026", 4);

    public Course testCourseE = new Course("Test Course E", testDepartmentD, "8100", 4);
    public Course testCourseF = new Course("Test Course F", testDepartmentD, "7100", 3);
    public Course testCourseG = new Course("Test Course G", testDepartmentD, "6100", 2);
    public Course testCourseH = new Course("Test Course H", testDepartmentD, "5100", 1);

    public Course testCourseI = new Course("Test Course I", testDepartmentB, "5110", 4);
    public Course testCourseJ = new Course("Test Course J", testDepartmentB, "6130", 3);
    public Course testCourseK = new Course("Test Course K", testDepartmentB, "7140", 2);
    public Course testCourseL = new Course("Test Course L", testDepartmentB, "8125", 1);

    public Course testCourseM = new Course("Test Course M", testDepartmentC, "8123", 4);
    public Course testCourseN = new Course("Test Course N", testDepartmentC, "7142", 3);
    public Course testCourseO = new Course("Test Course O", testDepartmentC, "6131", 2);
    public Course testCourseP = new Course("Test Course P", testDepartmentC, "5115", 1);

    public Section testSectionA01 = new Section("01", "LWV", "7:00AM-7:50AM", "Dr. Juan N. Onlee", "S424", testCourseA, 1, 50);
    public Section testSectionA02 = new Section("02", "LWV", "8:30AM-9:20AM", "Dr. Juan N. Onlee", "S423", testCourseA, 1, 50);
    public Section testSectionA03 = new Section("03", "LWV", "9:00AM-9:50AM", "Dr. Juan N. Onlee", "S422", testCourseA, 1, 50);
    public Section testSectionA04 = new Section("04", "LWV", "10:30AM-11:20AM", "Dr. Juan N. Onlee", "S421", testCourseA, 1, 50);

    public Section testSectionB01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Late", "SH321", testCourseB, 1, 50);
    public Section testSectionB02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Late", "SH322", testCourseB, 1, 50);
    public Section testSectionB03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Late", "SH323", testCourseB, 1, 50);
    public Section testSectionB04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Late", "SH324", testCourseB, 1, 50);

    public Section testSectionC01 = new Section("01", "LWV", "12:00PM-1:20PM", "Dr. Hugh Mungus", "Ch691", testCourseC, 1, 50);
    public Section testSectionC02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourseC, 1, 50);
    public Section testSectionC03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693", testCourseC, 1, 50);
    public Section testSectionC04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694", testCourseC, 1, 50);

    public Section testSectionD01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourseD, 1, 50);
    public Section testSectionD02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778", testCourseD, 1, 50);
    public Section testSectionD03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779", testCourseD, 1, 50);
    public Section testSectionD04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775", testCourseD, 1, 50);

    public Section testSectionE01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourseE, 1, 50);
    public Section testSectionE02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Juan N. Onlee", "S423", testCourseE, 1, 50);
    public Section testSectionE03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Juan N. Onlee", "S422", testCourseE, 1, 50);
    public Section testSectionE04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Juan N. Onlee", "S421", testCourseE, 1, 50);

    public Section testSectionF01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourseF, 1, 50);
    public Section testSectionF02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Mai", "SH322", testCourseF, 1, 50);
    public Section testSectionF03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Mai", "SH323", testCourseF, 1, 50);
    public Section testSectionF04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Mai", "SH324", testCourseF, 1, 50);

    public Section testSectionG01 = new Section("01", "LWV", "7:30AM-9:20AM", "Dr. Hugh Mungus", "Ch691", testCourseG, 1, 50);
    public Section testSectionG02 = new Section("02", "LWV", "9:30AM-11:20AM", "Dr. Hugh Mungus", "Ch692", testCourseG, 1, 50);
    public Section testSectionG03 = new Section("03", "LWV", "11:30AM-1:20PM", "Dr. Hugh Mungus", "Ch693", testCourseG, 1, 50);
    public Section testSectionG04 = new Section("04", "LWV", "1:30PM-3:20PM", "Dr. Hugh Mungus", "Ch694", testCourseG, 1, 50);

    public Section testSectionH01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourseH, 1, 50);
    public Section testSectionH02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778", testCourseH, 1, 50);
    public Section testSectionH03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779", testCourseH, 1, 50);
    public Section testSectionH04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775", testCourseH, 1, 50);

    public Section testSectionI01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourseI, 1, 50);
    public Section testSectionI02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Juan N. Onlee", "S423", testCourseI, 1, 50);
    public Section testSectionI03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Juan N. Onlee", "S422", testCourseI, 1, 50);
    public Section testSectionI04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Juan N. Onlee", "S421", testCourseI, 1, 50);

    public Section testSectionJ01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourseJ, 1, 50);
    public Section testSectionJ02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Mai", "SH322", testCourseJ, 1, 50);
    public Section testSectionJ03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Mai", "SH323", testCourseJ, 1, 50);
    public Section testSectionJ04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Mai", "SH324", testCourseJ, 1, 50);

    public Section testSectionK01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourseK, 1, 50);
    public Section testSectionK02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourseK, 1, 50);
    public Section testSectionK03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693", testCourseK, 1, 50);
    public Section testSectionK04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694", testCourseK, 1, 50);

    public Section testSectionL01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourseL, 1, 50);
    public Section testSectionL02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778", testCourseL, 1, 50);
    public Section testSectionL03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779", testCourseL, 1, 50);
    public Section testSectionL04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775", testCourseL, 1, 50);

    public Section testSectionM01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourseM, 1, 50);
    public Section testSectionM02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Juan N. Onlee", "S423", testCourseM, 1, 50);
    public Section testSectionM03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Juan N. Onlee", "S422", testCourseM, 1, 50);
    public Section testSectionM04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Juan N. Onlee", "S421", testCourseM, 1, 50);

    public Section testSectionN01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourseN, 1, 50);
    public Section testSectionN02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Mai", "SH322", testCourseN, 1, 50);
    public Section testSectionN03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Mai", "SH323", testCourseN, 1, 50);
    public Section testSectionN04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Mai", "SH324", testCourseN, 1, 50);

    public Section testSectionO01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourseO, 1, 50);
    public Section testSectionO02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourseO, 1, 50);
    public Section testSectionO03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693", testCourseO, 1, 50);
    public Section testSectionO04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694", testCourseO, 1, 50);

    public Section testSectionP01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourseP, 1, 50);
    public Section testSectionP02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778", testCourseP, 1, 50);
    public Section testSectionP03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779", testCourseP, 1, 50);
    public Section testSectionP04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775", testCourseP, 1, 50);

    // Real values

    public MatriculaPeriod testPeriod1 = new MatriculaPeriod(2021, "FALL");
    public MatriculaPeriod testPeriod2 = new MatriculaPeriod(2021, "SPRING");
    public MatriculaPeriod testPeriod3 = new MatriculaPeriod(2022, "FALL");
    public List<Section> testListNew = new ArrayList<Section>();
    public Matricula testMatricula2 = new Matricula(testPeriod2);
    public Matricula testMatricula3 = new Matricula(testPeriod3);

    public Department testDepartment1 = new Department("Department of Computer Science and Engineering", "CIIC", "Green");
    public Department testDepartment2 = new Department("Department of Software Engineering", "INSO", "Purple");
    public Department testDepartment3 = new Department("Department of Engineering", "INGE", "Red");
    public Department testDepartment4 = new Department("Department of Humanities", "TSTD", "Blue");

    public User testUser1 = new User("JohnSmitch82", "JS841178204");
    public Student testStudent1 = new Student(testUser1, "John Smitch", "841-17-8204", testDepartment1);

    public Course testCourse1 = new Course("Test Course A", testDepartment1, "3015", 1);
    public Course testCourse2 = new Course("Test Course B", testDepartment1, "3015L", 2);
    public Course testCourse3 = new Course("Test Course C", testDepartment1, "2025", 3);
    public Course testCourse4 = new Course("Test Course D", testDepartment1, "1026", 4);

    public Course testCourse5 = new Course("Test Course 5", testDepartment4, "9999", 4);
    public Course testCourse6 = new Course("Test Course 6", testDepartment4, "7100", 3);
    public Course testCourse7 = new Course("Test Course 7", testDepartment4, "6100", 2);
    public Course testCourse8 = new Course("Test Course 8", testDepartment4, "5100", 1);

    public Course testCourse9 = new Course("Test Course I", testDepartment2, "5110", 4);
    public Course testCourse10 = new Course("Test Course J", testDepartment2, "6130", 3);
    public Course testCourse11= new Course("Test Course K", testDepartment2, "7140", 2);
    public Course testCourse12= new Course("Test Course L", testDepartment2, "8125", 1);

    public Course testCourse13= new Course("Test Course M", testDepartment3, "8123", 4);
    public Course testCourse14= new Course("Test Course N", testDepartment3, "7142", 3);
    public Course testCourse15= new Course("Test Course O", testDepartment3, "6131", 2);
    public Course testCourse16= new Course("Test Course P", testDepartment3, "5115", 1);

    public Section testSectionA1 = new Section("01", "LWV", "7:00AM-7:50AM", "Dr. Juan N. Onlee", "S424", testCourse1, 1, 50);
    public Section testSectionA2 = new Section("02", "LWV", "8:30AM-9:20AM", "Dr. Juan N. Onlee", "S423", testCourse1, 1, 50);
    public Section testSectionA3 = new Section("03", "LWV", "9:00AM-9:50AM", "Dr. Juan N. Onlee", "S422", testCourse1, 1, 50);
    public Section testSectionA4 = new Section("04", "LWV", "10:30AM-11:20AM", "Dr. Juan N. Onlee", "S421", testCourse1, 1, 50);

    public Section testSectionB1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Late", "SH321", testCourse2, 1, 50);
    public Section testSectionB2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Late", "SH322", testCourse2, 1, 50);
    public Section testSectionB3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Late", "SH323", testCourse2, 1, 50);
    public Section testSectionB4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Late", "SH324", testCourse2, 1, 50);

    public Section testSectionC1 = new Section("01", "LWV", "12:00PM-1:20PM", "Dr. Hugh Mungus", "Ch691", testCourse3, 1, 50);
    public Section testSectionC2 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourse3, 1, 50);
    public Section testSectionC3 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693", testCourse3, 1, 50);
    public Section testSectionC4 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694", testCourse3, 1, 50);

    public Section testSectionD1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse4, 1, 50);
    public Section testSectionD2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778", testCourse4, 1, 50);
    public Section testSectionD3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779", testCourse4, 1, 50);
    public Section testSectionD4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775", testCourse4, 1, 50);

    public Section testSectionE1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourse5, 1, 50);
    public Section testSectionE2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Juan N. Onlee", "S423", testCourse5, 1, 50);
    public Section testSectionE3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Juan N. Onlee", "S422", testCourse5, 1, 50);
    public Section testSectionE4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Juan N. Onlee", "S421", testCourse5, 1, 50);

    public Section testSectionF1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourse6, 1, 50);
    public Section testSectionF2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Too Mai", "SH322", testCourse6, 1, 50);
    public Section testSectionF3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Too Mai", "SH323", testCourse6, 1, 50);
    public Section testSectionF4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Too Mai", "SH324", testCourse6, 1, 50);

    public Section testSectionG1 = new Section("01", "LWV", "7:30AM-9:20AM",  "Dr. Hugh Mungus", "Ch691", testCourse7, 1, 50);
    public Section testSectionG2 = new Section("02", "LWV", "9:30AM-11:20AM", "Dr. Hugh Mungus", "Ch692", testCourse7, 1, 50);
    public Section testSectionG3 = new Section("03", "LWV", "11:30AM-1:20PM", "Dr. Hugh Mungus", "Ch693", testCourse7, 1, 50);
    public Section testSectionG4 = new Section("04", "LWV", "1:30PM-3:20PM",  "Dr. Hugh Mungus", "Ch694", testCourse7, 1, 50);

    public Section testSectionH1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse8, 1, 50);
    public Section testSectionH2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Brock O. Lee", "ADEM778", testCourse8, 1, 50);
    public Section testSectionH3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Brock O. Lee", "ADEM779", testCourse8, 1, 50);
    public Section testSectionH4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Brock O. Lee", "ADEM775", testCourse8, 1, 50);

    public Section testSectionI1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourse9, 1, 50);
    public Section testSectionI2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Juan N. Onlee", "S423", testCourse9, 1, 50);
    public Section testSectionI3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Juan N. Onlee", "S422", testCourse9, 1, 50);
    public Section testSectionI4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Juan N. Onlee", "S421", testCourse9, 1, 50);

    public Section testSectionJ1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourse10, 1, 50);
    public Section testSectionJ2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Too Mai", "SH322", testCourse10, 1, 50);
    public Section testSectionJ3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Too Mai", "SH323", testCourse10, 1, 50);
    public Section testSectionJ4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Too Mai", "SH324", testCourse10, 1, 50);

    public Section testSectionK1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourse11, 1, 50);
    public Section testSectionK2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Hugh Mungus", "Ch692", testCourse11, 1, 50);
    public Section testSectionK3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Hugh Mungus", "Ch693", testCourse11, 1, 50);
    public Section testSectionK4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Hugh Mungus", "Ch694", testCourse11, 1, 50);

    public Section testSectionL1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse12, 1, 50);
    public Section testSectionL2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Brock O. Lee", "ADEM778", testCourse12, 1, 50);
    public Section testSectionL3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Brock O. Lee", "ADEM779", testCourse12, 1, 50);
    public Section testSectionL4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Brock O. Lee", "ADEM775", testCourse12, 1, 50);

    public Section testSectionM1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourse13, 1, 50);
    public Section testSectionM2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Juan N. Onlee", "S423", testCourse13, 1, 50);
    public Section testSectionM3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Juan N. Onlee", "S422", testCourse13, 1, 50);
    public Section testSectionM4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Juan N. Onlee", "S421", testCourse13, 1, 50);

    public Section testSectionN1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourse14, 1, 50);
    public Section testSectionN2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Too Mai", "SH322", testCourse14, 1, 50);
    public Section testSectionN3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Too Mai", "SH323", testCourse14, 1, 50);
    public Section testSectionN4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Too Mai", "SH324", testCourse14, 1, 50);

    public Section testSectionO1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourse15, 1, 50);
    public Section testSectionO2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Hugh Mungus", "Ch692", testCourse15, 1, 50);
    public Section testSectionO3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Hugh Mungus", "Ch693", testCourse15, 1, 50);
    public Section testSectionO4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Hugh Mungus", "Ch694", testCourse15, 1, 50);

    public Section testSectionP1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse16, 1, 50);
    public Section testSectionP2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Brock O. Lee", "ADEM778", testCourse16, 1, 50);
    public Section testSectionP3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Brock O. Lee", "ADEM779", testCourse16, 1, 50);
    public Section testSectionP4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Brock O. Lee", "ADEM775", testCourse16, 1, 50);

    public JsonTest() {

        testCourseA.addPrereq(testPrereqCourseA);
        testCourseA.addPrereq(testPrereqCourseB);
        testCourseA.addPrereq(testPrereqCourseC);
        testCourseA.addPrereq(testPrereqCourseD);

        testCourseA.addCoreq(testCoreqCourseA);
        testCourseA.addCoreq(testCoreqCourseB);
        testCourseA.addCoreq(testCoreqCourseC);
        testCourseA.addCoreq(testCoreqCourseD);
  
        testList.add(testSectionA04);
        testList.add(testSectionB03);
        testList.add(testSectionC02);
        testList.add(testSectionD01);

        testStudentA.addMatricula(testMatriculaB);
        testStudentA.addMatricula(testMatriculaC);
        testStudentA.SetTurn(new Turn("12/25/2020 15:00-12/25/2020 15:30"));

        testMatriculaB.addSection(testSectionI01,testCourseI);
        testMatriculaB.addSection(testSectionJ01,testCourseJ);
        testMatriculaB.addSection(testSectionK01,testCourseK);
        testMatriculaB.addSection(testSectionL01,testCourseL);

        testMatriculaC.addSection(testSectionM01,testCourseM);
        testMatriculaC.addSection(testSectionN01,testCourseN);
        testMatriculaC.addSection(testSectionO01,testCourseO);
        testMatriculaC.addSection(testSectionP01,testCourseP);

        testStudentA.addCourseTaken(testCourseTakenA);
        testStudentA.addCourseTaken(testCourseTakenB);
        testStudentA.addCourseTaken(testCourseTakenC);
        testStudentA.addCourseTaken(testCourseTakenD);

        testStudentA.addPriority(testCourseE);
        testStudentA.addPriority(testCourseF);
        testStudentA.addPriority(testCourseG);
        testStudentA.addPriority(testCourseH);

        // Real Values
  
        testList.add(testSectionA4);
        testList.add(testSectionB3);
        testList.add(testSectionC2);
        testList.add(testSectionD1);

        testStudent1.addMatricula(testMatricula2);
        testStudent1.addMatricula(testMatricula3);
        testStudent1.SetTurn(new Turn("12/25/2020 15:00-12/25/2020 15:30"));

        testMatricula2.addSection(testSectionI1,testCourse9);
        testMatricula2.addSection(testSectionJ1,testCourse10);
        testMatricula2.addSection(testSectionK1,testCourse11);
        testMatricula2.addSection(testSectionL1,testCourse12);

        testMatricula2.addSection(testSectionM1,testCourse13);
        testMatricula2.addSection(testSectionN1,testCourse14);
        testMatricula2.addSection(testSectionO1,testCourse15);
        testMatricula2.addSection(testSectionP1,testCourse16);

        testStudent1.addPriority(testCourse5);
        testStudent1.addPriority(testCourse6);
        testStudent1.addPriority(testCourse7);
        testStudent1.addPriority(testCourse8);

        try {

            db = new DBHandler("sql-dabatase", true);
            
            db.SaveDepartment(testDepartment1);
            db.SaveDepartment(testDepartment2);
            db.SaveDepartment(testDepartment3);
            db.SaveDepartment(testDepartment4);
            
            db.SaveUser(testUser1);
            db.SaveStudent(testStudent1);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
