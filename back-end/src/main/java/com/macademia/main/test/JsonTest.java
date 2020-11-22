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

    //--[Real Value]---------------------------------------------------------------------------------------------------------------

    public MatriculaPeriod testPeriod1 = new MatriculaPeriod(2021, "FALL");
    public MatriculaPeriod testPeriod2 = new MatriculaPeriod(2021, "SPRING");
    public MatriculaPeriod testPeriod3 = new MatriculaPeriod(2022, "FALL");
    public List<Section> testListNew = new ArrayList<Section>();
    public Matricula testMatricula2 = new Matricula(testPeriod2);
    public Matricula testMatricula3 = new Matricula(testPeriod3);

    //---[Departments]-----------------------------------------------------------------------------------------------------------

    public Department testDepartment1 = new Department("Department of Computer Science and Engineering", "CIIC", "#bb8fce ");
    public Department testDepartment2 = new Department("Department of Software Engineering", "INSO", "#85c1e9");
    public Department testDepartment3 = new Department("Department of Engineering", "INGE", "#f4d03f ");
    public Department testDepartment4 = new Department("Department of Mathematics", "MATE", "#f1948a");

    //---[User Info]-------------------------------------------------------------------------------------------------------------

    public User testUser1 = new User("JohnSmitch82", "JS841178204");
    public Student testStudent1 = new Student(testUser1, "John Smitch", "841-17-8204", testDepartment1);

    //---[Courses]---------------------------------------------------------------------------------------------------------------

    public Course testCourse1A = new Course("Intro. to Programming", testDepartment1, "3015", 3);
    public Course testCourse1B = new Course("Intro. to Programming Lab.", testDepartment1, "3015L", 1);
    public Course testCourse1C = new Course("Foundations of Computing", testDepartment1, "3075", 3);
    public Course testCourse1D = new Course("Advanced Programming", testDepartment1, "4010", 4);
    public Course testCourse1E = new Course("Advanced Programming Lab.", testDepartment1, "4010", 0);
    public Course testCourse1F = new Course("Data Structures", testDepartment1, "4020", 4);
    public Course testCourse1G = new Course("Data Structures", testDepartment1, "4020", 0);
    public Course testCourse1H = new Course("Programming Languages", testDepartment1, "4030", 3);
    public Course testCourse1I = new Course("Operating Systems", testDepartment1, "4050", 4);
    public Course testCourse1J = new Course("Operating Systems Lab.", testDepartment1, "4050", 0);
    public Course testCourse1K = new Course("Database Systems", testDepartment1, "4060", 3);
    public Course testCourse1L = new Course("Computer Networks", testDepartment1, "4070", 3);
    public Course testCourse1M = new Course("Computer Architecture I", testDepartment1, "3081", 3);
    public Course testCourse1N = new Course("Computer Architecture II", testDepartment1, "4082", 3);

    public Course testCourse2A = new Course("Intro. to Software Engineering",          testDepartment2, "4101", 3);
    public Course testCourse2B = new Course("Software Requirements",                   testDepartment2, "4115", 3);
    public Course testCourse2C = new Course("Software Design",                         testDepartment2, "4116", 3);
    public Course testCourse2D = new Course("Software Testing",                        testDepartment2, "4117", 3);
    public Course testCourse2E = new Course("Software Engineering Project (Capstone)", testDepartment2, "4151", 3);

    public Course testCourse3A  = new Course("Engineering Graphics",             testDepartment3, "5110", 4);
    public Course testCourse3B = new Course("Engineering Mechanics",            testDepartment3, "6130", 3);
    public Course testCourse3C = new Course("Electrical Engineering Materials", testDepartment3, "7140", 2);
    public Course testCourse3D = new Course("Test Course L",                    testDepartment3, "8125", 1);

    public Course testCourse4A = new Course("Pre-calculus I",                      testDepartment4, "3171", 4);
    public Course testCourse4B = new Course("Pre-calculus II",                     testDepartment4, "3172", 3);
    public Course testCourse4C = new Course("Calculus I",                          testDepartment4, "3031", 2);
    public Course testCourse4D = new Course("Calculus II",                         testDepartment4, "3032", 1);
    public Course testCourse4E = new Course("Calculus III",                        testDepartment4, "3063", 4);
    public Course testCourse4F = new Course("Differential Eq. and Linear Algebra", testDepartment4, "4145", 4);

    //---[Sections]--------------------------------------------------------------------------------------------------------------

    public Section testSection1A1 = new Section("096", "MJ", "3:30PM-4:45PM", "Heidy Sierra Gil", "S424",   testCourse1A, 1, 100);

    public Section testSection1B1 = new Section("070", "W", "1:30PM-3:20PM", "Estefania Alfaro", "S-121",   testCourse1B, 1, 28);
    public Section testSection1B2 = new Section("071", "W", "1:30PM-3:20PM", "Maria Ramos", "S-105c",   testCourse1B, 1, 28);
    public Section testSection1B3 = new Section("090", "W", "3:30PM-5:20PM", "Estefania Alfaro", "S-121", testCourse1B, 1, 28);
    public Section testSection1B4 = new Section("091", "LWV", "3:30PM-5:20PM", "Maria Ramos", "S-105c", testCourse1B, 1, 28);

    public Section testSection1C1 = new Section("030", "LWV", "9:30AM-10:20AM", "Kejie Lu", "S-114a", testCourse1C, 1, 15);
    public Section testSection1C2 = new Section("040", "LWV", "10:30AM-11:20AM", "Kejie Lu", "S-113", testCourse1C, 1, 15);
    public Section testSection1C3 = new Section("050", "LWV", "11:30AM-12:20PM", "Kejie Lu", "S-114a",  testCourse1C, 1, 15);
    public Section testSection1C4 = new Section("070", "LWV", "1:30PM-2:20PM", "Kejie Lu", "S-114a",  testCourse1C, 1, 15);
    public Section testSection1C5 = new Section("100", "LW", "4:30PM-5:45PM", "Dong Wang", "S-114a",  testCourse1C, 1, 15);

    public Section testSection1D1 = new Section("100", "LW", "4:30PM-5:45PM", "Jose Cruz", "S-113", testCourse1D, 1, 50);
    public Section testSection1D2 = new Section("100H", "LW", "4:30PM-5:45PM", "Jose Cruz", "S-113",  testCourse1D, 1, 50);

    public Section testSection1E1 = new Section("030L", "V", "9:30AM-11:20AM", "Jose Cruz", "S-121", testCourse1E, 1, 16);
    public Section testSection1E2 = new Section("031L", "V", "9:30AM-11:20AM",  "Jose Cruz", "S-105c", testCourse1E, 1, 16);
    public Section testSection1E3 = new Section("050L", "V", "11:30AM-1:20PM",   "Jose Cruz", "S-121", testCourse1E, 1, 16);
    public Section testSection1E4 = new Section("051L", "V", "11:30AM-1:20PM",   "Jose Cruz", "S-105c", testCourse1E, 1, 16);
    public Section testSection1E5 = new Section("070L", "V", "1:30PM-3:20PM",   "Jose Cruz", "S-121", testCourse1E, 1, 16);
    public Section testSection1E6 = new Section("070L", "V", "1:30PM-3:20PM",   "Jose Cruz", "S-105c", testCourse1E, 1, 16);

    public Section testSection1F1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourse1F, 1, 50);
    public Section testSection1F2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Too Mai", "SH322", testCourse1F, 1, 50);
    public Section testSection1F3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Too Mai", "SH323", testCourse1F, 1, 50);
    public Section testSection1F4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Too Mai", "SH324", testCourse1F, 1, 50);

    public Section testSection1G1 = new Section("01", "LWV", "7:30AM-9:20AM",  "Dr. Hugh Mungus", "Ch691", testCourse1G, 1, 50);
    public Section testSection1G2 = new Section("02", "LWV", "9:30AM-11:20AM", "Dr. Hugh Mungus", "Ch692", testCourse1G, 1, 50);
    public Section testSection1G3 = new Section("03", "LWV", "11:30AM-1:20PM", "Dr. Hugh Mungus", "Ch693", testCourse1G, 1, 50);
    public Section testSection1G4 = new Section("04", "LWV", "1:30PM-3:20PM",  "Dr. Hugh Mungus", "Ch694", testCourse1G, 1, 50);

    public Section testSection1H1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse1H, 1, 50);
    public Section testSection1H2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Brock O. Lee", "ADEM778", testCourse1H, 1, 50);
    public Section testSection1H3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Brock O. Lee", "ADEM779", testCourse1H, 1, 50);
    public Section testSection1H4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Brock O. Lee", "ADEM775", testCourse1H, 1, 50);

    public Section testSection1I1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourse1I, 1, 50);
    public Section testSection1I2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Juan N. Onlee", "S423", testCourse1I, 1, 50);
    public Section testSection1I3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Juan N. Onlee", "S422", testCourse1I, 1, 50);
    public Section testSection1I4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Juan N. Onlee", "S421", testCourse1I, 1, 50);

    public Section testSection1J1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourse1J, 1, 50);
    public Section testSection1J2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Too Mai", "SH322", testCourse1J, 1, 50);
    public Section testSection1J3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Too Mai", "SH323", testCourse1J, 1, 50);
    public Section testSection1J4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Too Mai", "SH324", testCourse1J, 1, 50);

    public Section testSection1K1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourse1K, 1, 50);
    public Section testSection1K2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Hugh Mungus", "Ch692", testCourse1K, 1, 50);
    public Section testSection1K3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Hugh Mungus", "Ch693", testCourse1K, 1, 50);
    public Section testSection1K4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Hugh Mungus", "Ch694", testCourse1K, 1, 50);

    public Section testSection2A1 = new Section("01", "LWV", "7:00AM-7:50AM", "Dr. Juan N. Onlee", "S424",   testCourse2A, 1, 50);
    public Section testSection2A2 = new Section("02", "LWV", "8:30AM-9:20AM", "Dr. Juan N. Onlee", "S423",   testCourse2A, 1, 50);
    public Section testSection2A3 = new Section("03", "LWV", "9:00AM-9:50AM", "Dr. Juan N. Onlee", "S422",   testCourse2A, 1, 50);
    public Section testSection2A4 = new Section("04", "LWV", "10:30AM-11:20AM", "Dr. Juan N. Onlee", "S421", testCourse2A, 1, 50);

    public Section testSection2B1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Late", "SH321", testCourse2B, 1, 50);
    public Section testSection2B2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Late", "SH322",  testCourse2B, 1, 50);
    public Section testSection2B3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Late", "SH323",   testCourse2B, 1, 50);
    public Section testSection2B4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Late", "SH324",   testCourse2B, 1, 50);

    public Section testSection2C1 = new Section("01", "LWV", "12:00PM-1:20PM", "Dr. Hugh Mungus", "Ch691", testCourse2C, 1, 50);
    public Section testSection2C2 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourse2C, 1, 50);
    public Section testSection2C3 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693",  testCourse2C, 1, 50);
    public Section testSection2C4 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694",  testCourse2C, 1, 50);

    public Section testSection2D1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse2D, 1, 50);
    public Section testSection2D2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778",  testCourse2D, 1, 50);
    public Section testSection2D3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779",   testCourse2D, 1, 50);
    public Section testSection2D4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775",   testCourse2D, 1, 50);

    public Section testSection2E1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourse2E, 1, 50);
    public Section testSection2E2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Juan N. Onlee", "S423", testCourse2E, 1, 50);
    public Section testSection2E3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Juan N. Onlee", "S422", testCourse2E, 1, 50);
    public Section testSection2E4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Juan N. Onlee", "S421", testCourse2E, 1, 50);
    
    public Section testSection3A1 = new Section("01", "LWV", "7:00AM-7:50AM", "Dr. Juan N. Onlee", "S424",   testCourse3A, 1, 50);
    public Section testSection3A2 = new Section("02", "LWV", "8:30AM-9:20AM", "Dr. Juan N. Onlee", "S423",   testCourse3A, 1, 50);
    public Section testSection3A3 = new Section("03", "LWV", "9:00AM-9:50AM", "Dr. Juan N. Onlee", "S422",   testCourse3A, 1, 50);
    public Section testSection3A4 = new Section("04", "LWV", "10:30AM-11:20AM", "Dr. Juan N. Onlee", "S421", testCourse3A, 1, 50);

    public Section testSection3B1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Late", "SH321", testCourse3B, 1, 50);
    public Section testSection3B2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Late", "SH322",  testCourse3B, 1, 50);
    public Section testSection3B3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Late", "SH323",   testCourse3B, 1, 50);
    public Section testSection3B4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Late", "SH324",   testCourse3B, 1, 50);

    public Section testSection3C1 = new Section("01", "LWV", "12:00PM-1:20PM", "Dr. Hugh Mungus", "Ch691", testCourse3C, 1, 50);
    public Section testSection3C2 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourse3C, 1, 50);
    public Section testSection3C3 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693",  testCourse3C, 1, 50);
    public Section testSection3C4 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694",  testCourse3C, 1, 50);

    public Section testSection3D1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse3D, 1, 50);
    public Section testSection3D2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778",  testCourse3D, 1, 50);
    public Section testSection3D3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779",   testCourse3D, 1, 50);
    public Section testSection3D4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775",   testCourse3D, 1, 50);

    public Section testSection4A1 = new Section("01", "LWV", "7:00AM-7:50AM", "Dr. Juan N. Onlee", "S424",   testCourse4A, 1, 50);
    public Section testSection4A2 = new Section("02", "LWV", "8:30AM-9:20AM", "Dr. Juan N. Onlee", "S423",   testCourse4A, 1, 50);
    public Section testSection4A3 = new Section("03", "LWV", "9:00AM-9:50AM", "Dr. Juan N. Onlee", "S422",   testCourse4A, 1, 50);
    public Section testSection4A4 = new Section("04", "LWV", "10:30AM-11:20AM", "Dr. Juan N. Onlee", "S421", testCourse4A, 1, 50);

    public Section testSection4B1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Late", "SH321", testCourse4B, 1, 50);
    public Section testSection4B2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Late", "SH322",  testCourse4B, 1, 50);
    public Section testSection4B3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Late", "SH323",   testCourse4B, 1, 50);
    public Section testSection4B4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Late", "SH324",   testCourse4B, 1, 50);

    public Section testSection4C1 = new Section("01", "LWV", "12:00PM-1:20PM", "Dr. Hugh Mungus", "Ch691", testCourse4C, 1, 50);
    public Section testSection4C2 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourse4C, 1, 50);
    public Section testSection4C3 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693",  testCourse4C, 1, 50);
    public Section testSection4C4 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694",  testCourse4C, 1, 50);

    public Section testSection4D1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Brock O. Lee", "ADEM777", testCourse4D, 1, 50);
    public Section testSection4D2 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Brock O. Lee", "ADEM778",  testCourse4D, 1, 50);
    public Section testSection4D3 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Brock O. Lee", "ADEM779",   testCourse4D, 1, 50);
    public Section testSection4D4 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Brock O. Lee", "ADEM775",   testCourse4D, 1, 50);
 
    public Section testSection4E1 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourse4E, 1, 50);
    public Section testSection4E2 = new Section("02", "LWV", "12:30PM-1:20PM",  "Dr. Juan N. Onlee", "S423", testCourse4E, 1, 50);
    public Section testSection4E3 = new Section("03", "LWV", "1:00PM-1:50PM",   "Dr. Juan N. Onlee", "S422", testCourse4E, 1, 50);
    public Section testSection4E4 = new Section("04", "LWV", "1:30PM-2:20PM",   "Dr. Juan N. Onlee", "S421", testCourse4E, 1, 50);

    public Section testSection4F1 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Mai", "SH321", testCourse4F, 1, 50);
    public Section testSection4F2 = new Section("02", "MJ", "12:30PM-1:20PM",  "Dr. Too Mai", "SH322", testCourse4F, 1, 50);
    public Section testSection4F3 = new Section("03", "MJ", "1:00PM-1:50PM",   "Dr. Too Mai", "SH323", testCourse4F, 1, 50);
    public Section testSection4F4 = new Section("04", "MJ", "1:30PM-2:20PM",   "Dr. Too Mai", "SH324", testCourse4F, 1, 50);


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
  
        testList.add(testSection1A1);
        testList.add(testSection1B1);
        testList.add(testSection1C1);
        testList.add(testSection1D1);

        testStudent1.addMatricula(testMatricula2);
        testStudent1.addMatricula(testMatricula3);
        testStudent1.SetTurn(new Turn("12/25/2020 15:00-12/25/2020 15:30"));

        testMatricula2.addSection(testSection1A1,testCourse1A);
        testMatricula2.addSection(testSection1B2,testCourse1B);
        testMatricula2.addSection(testSection1C2,testCourse1C);
        testMatricula2.addSection(testSection1D2,testCourse1D);

        testMatricula3.addSection(testSection1A1,testCourse1A);
        testMatricula3.addSection(testSection1B3,testCourse1B);
        testMatricula3.addSection(testSection1C3,testCourse1C);
        testMatricula3.addSection(testSection1D1,testCourse1D);

        testStudent1.addPriority(testCourse2A);
        testStudent1.addPriority(testCourse2B);
        testStudent1.addPriority(testCourse2C);
        testStudent1.addPriority(testCourse2D);

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
