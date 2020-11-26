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

    public Course testPrereqCourseA = new Course("Test Prerequisite Course A", testPrereqDepartment, "4001", 1, "FALL-SPRING-SUMMER");
    public Course testPrereqCourseB = new Course("Test Prerequisite Course B", testPrereqDepartment, "3002", 2, "FALL-SPRING-SUMMER");
    public Course testPrereqCourseC = new Course("Test Prerequisite Course C", testPrereqDepartment, "2003", 3, "FALL-SPRING-SUMMER");
    public Course testPrereqCourseD = new Course("Test Prerequisite Course D", testPrereqDepartment, "1004", 4, "FALL-SPRING-SUMMER");

    public Course testCoreqCourseA = new Course("Test Corequisite Course A", testCoreqDepartment, "4004", 1, "FALL-SPRING-SUMMER");
    public Course testCoreqCourseB = new Course("Test Corequisite Course B", testCoreqDepartment, "3003", 2, "FALL-SPRING-SUMMER");
    public Course testCoreqCourseC = new Course("Test Corequisite Course C", testCoreqDepartment, "2002", 3, "FALL-SPRING-SUMMER");
    public Course testCoreqCourseD = new Course("Test Corequisite Course D", testCoreqDepartment, "1001", 4, "FALL-SPRING-SUMMER");

    public Course testCourseTakenA = new Course("Test Course Taken A", testCoursesTakenDepartment, "7001", 3, "FALL-SPRING-SUMMER");
    public Course testCourseTakenB = new Course("Test Course Taken B", testCoursesTakenDepartment, "7002", 3, "FALL-SPRING-SUMMER");
    public Course testCourseTakenC = new Course("Test Course Taken C", testCoursesTakenDepartment, "7003", 3, "FALL-SPRING-SUMMER");
    public Course testCourseTakenD = new Course("Test Course Taken D", testCoursesTakenDepartment, "7004", 3, "FALL-SPRING-SUMMER");

    public Course testCourseA = new Course("Test Course A", testDepartmentA, "4023", 1, "FALL-SPRING-SUMMER");
    public Course testCourseB = new Course("Test Course B", testDepartmentA, "3024", 2, "FALL-SPRING-SUMMER");
    public Course testCourseC = new Course("Test Course C", testDepartmentA, "2025", 3, "FALL-SPRING-SUMMER");
    public Course testCourseD = new Course("Test Course D", testDepartmentA, "1026", 4, "FALL-SPRING-SUMMER");

    public Course testCourseE = new Course("Test Course E", testDepartmentD, "8100", 4, "FALL-SPRING-SUMMER");
    public Course testCourseF = new Course("Test Course F", testDepartmentD, "7100", 3, "FALL-SPRING-SUMMER");
    public Course testCourseG = new Course("Test Course G", testDepartmentD, "6100", 2, "FALL-SPRING-SUMMER");
    public Course testCourseH = new Course("Test Course H", testDepartmentD, "5100", 1, "FALL-SPRING-SUMMER");

    public Course testCourseI = new Course("Test Course I", testDepartmentB, "5110", 4, "FALL-SPRING-SUMMER");
    public Course testCourseJ = new Course("Test Course J", testDepartmentB, "6130", 3, "FALL-SPRING-SUMMER");
    public Course testCourseK = new Course("Test Course K", testDepartmentB, "7140", 2, "FALL-SPRING-SUMMER");
    public Course testCourseL = new Course("Test Course L", testDepartmentB, "8125", 1, "FALL-SPRING-SUMMER");

    public Course testCourseM = new Course("Test Course M", testDepartmentC, "8123", 4, "FALL-SPRING-SUMMER");
    public Course testCourseN = new Course("Test Course N", testDepartmentC, "7142", 3, "FALL-SPRING-SUMMER");
    public Course testCourseO = new Course("Test Course O", testDepartmentC, "6131", 2, "FALL-SPRING-SUMMER");
    public Course testCourseP = new Course("Test Course P", testDepartmentC, "5115", 1, "FALL-SPRING-SUMMER");

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
    public Department testDepartment3 = new Department("Department of Engineering", "INGE", "#f1948a");
    public Department testDepartment4 = new Department("Department of Industrial Engineering", "ININ", "#f4d03f");
    public Department testDepartment5 = new Department("Department of English", "INGL", "#ffd5cd");

    //---[User Info]-------------------------------------------------------------------------------------------------------------

    public User testUser1 = new User("JohnSmitch82", "1234");
    public Student testStudent1 = new Student(testUser1, "John Smitch", "841-17-8204", testDepartment1);

    //---[Courses]---------------------------------------------------------------------------------------------------------------

    public Course testCourse1A = new Course("Intro. to Programming", testDepartment1, "3015", 3, "FALL, SPRING, SUMMER");
    public Course testCourse1B = new Course("Intro. to Programming Lab.", testDepartment1, "3015L", 1, "FALL, SPRING, SUMMER");
    public Course testCourse1C = new Course("Foundations of Computing", testDepartment1, "3075", 3, "FALL, SPRING");
    public Course testCourse1D = new Course("Advanced Programming", testDepartment1, "4010", 4, "FALL, SPRING");
    public Course testCourse1E = new Course("Advanced Programming Lab.", testDepartment1, "4010L", 0, "FALL, SPRING");
    public Course testCourse1F = new Course("Data Structures", testDepartment1, "4020", 4, "FALL, SPRING");
    public Course testCourse1G = new Course("Data Structures Lab.", testDepartment1, "4020L", 0, "FALL, SPRING");
    public Course testCourse1H = new Course("Programming Languages", testDepartment1, "4030", 3, "FALL, SPRING");
    public Course testCourse1I = new Course("Operating Systems", testDepartment1, "4050", 4, "FALL, SPRING");
    public Course testCourse1J = new Course("Operating Systems Lab.", testDepartment1, "4050L", 0, "FALL, SPRING");
    public Course testCourse1K = new Course("Database Systems", testDepartment1, "4060", 3, "SPRING");
    public Course testCourse1L = new Course("Computer Networks", testDepartment1, "4070", 3, "SPRING");
    public Course testCourse1M = new Course("Computer Architecture I", testDepartment1, "3081", 3, "FALL");
    public Course testCourse1N = new Course("Computer Architecture II", testDepartment1, "4082", 3, "SPRING");

    public Course testCourse2A = new Course("Intro. to Software Engineering",          testDepartment2, "4101", 3, "FALL, SPRING");
    public Course testCourse2B = new Course("Software Requirements",                   testDepartment2, "4115", 3, "SPRING");
    public Course testCourse2C = new Course("Software Design",                         testDepartment2, "4116", 3, "FALL");
    public Course testCourse2D = new Course("Software Testing",                        testDepartment2, "4117", 3, "SPRING");
    public Course testCourse2E = new Course("Software Engineering Project (Capstone)", testDepartment2, "4151", 3, "FALL, SPRING");

    public Course testCourse3A  = new Course("Engineering Graphics",             testDepartment3, "3011", 4, "FALL, SPRING");
    public Course testCourse3B = new Course("Engineering Mechanics",            testDepartment3, "3035", 3, "FALL, SPRING, SUMMER");
    public Course testCourse3C = new Course("Electrical Engineering Materials", testDepartment3, "3045", 2, "FALL, SPRING");

    public Course testCourse4A = new Course("Engineering Probability and Statistics", testDepartment4, "4010", 4, "FALL, SPRING, SUMMER");
    public Course testCourse4B = new Course("Engineering Economics",                  testDepartment4, "4015", 3, "FALL, SPRING, SUMMER");

    public Course testCourse5A = new Course("Advanced English 1", testDepartment5, "3211", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5B = new Course("Advanced English 2", testDepartment5, "3212", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5C = new Course("Basic English 1", testDepartment5, "3101", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5D = new Course("Basic English 2", testDepartment5, "3102", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5E = new Course("Intermediate English 1", testDepartment5, "3103", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5F = new Course("Intermediate English 2", testDepartment5, "3014", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5G = new Course("Conversational English", testDepartment5, "3289", 3, "FALL, SPRING, SUMMER");
    public Course testCourse5H = new Course("Movie Themes", testDepartment5, "3345", 3, "FALL, SPRING, SUMMER");
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

    public Section testSection1F1 = new Section("01", "MJ", "5:00PM-6:15PM", "Manuel Rodriguez", "S-113", testCourse1F, 1, 70);

    public Section testSection1G1 = new Section("030L", "L", "9:30AM-11:20AM",  "Chhaya Katiyar", "S-121", testCourse1G, 1, 16);
    public Section testSection1G2 = new Section("050L", "L", "11:30AM-1:20PM", "Manuel Rodriguez", "S-121", testCourse1G, 1, 16);
    public Section testSection1G3 = new Section("051L", "L", "11:30AM-1:20PM", "Chhaya Katiyar", "S-121", testCourse1G, 1, 16);
    public Section testSection1G5 = new Section("070L", "L", "1:30PM-3:20PM",  "Gretchen Bonilla", "S-121", testCourse1G, 1, 16);
    public Section testSection1G6 = new Section("071L", "L", "1:30PM-3:20PM",  "Manuel Rodriguez", "S-105c", testCourse1G, 1, 16);

    public Section testSection1H1 = new Section("036", "MJ", "9:00AM-10:15AM", "Wilson Rivera", "S-113", testCourse1H, 1, 60);
    
    public Section testSection1I1 = new Section("086", "MJ", "2:00PM-3:15PM", "Emmanuel Arzuaga", "S-113", testCourse1I, 1, 60);
   
    public Section testSection1J1 = new Section("010L", "W", "7:30AM-10:20AM", "David Tatis", "S-121", testCourse1J, 1, 16);
    public Section testSection1J2 = new Section("011L", "W", "7:30AM-10:20AM",  "Carlos Velez", "S-105c", testCourse1J, 1, 16);
    public Section testSection1J3 = new Section("040L", "W", "10:30AM-1:20PM",   "David Tatis", "S-121", testCourse1J, 1, 16);
    public Section testSection1J4 = new Section("041L", "W", "10:30AM-1:20PM",   "Carlos Velez", "S-105c", testCourse1J, 1, 16);
    
    public Section testSection1M1 = new Section("096", "MJ", "3:30PM-4:45PM", "Jose Navarro", "S-114a", testCourse1M, 1, 70);
    
    public Section testSection2A1 = new Section("080", "LWV", "2:30PM-3:20PM", "Marko Schutz", "S-113",   testCourse2A, 1, 80);

    public Section testSection2C1 = new Section("070", "LWV", "1:30PM-2:20PM", "Marko Schutz", "S-113", testCourse2C, 1, 80);
    
    public Section testSection3A1 = new Section("030H", "LW", "9:30AM-11:20AM", "Carmen Castaneyra", "S-316",   testCourse3A, 1, 30);
    public Section testSection3A2 = new Section("050H", "LW", "11:30AM-1:20PM", "Beatriz Camacho", "S-316",   testCourse3A, 1, 30);
    public Section testSection3A3 = new Section("090H", "LW", "3:30PM-5:20PM", "Carmen Castaneyra", "S-316",   testCourse3A, 1, 30);

    public Section testSection3B1 = new Section("010", "LWV", "7:30AM-8:20AM", "Marek Rysz", "S-308", testCourse3B, 1, 30);
    public Section testSection3B2 = new Section("020", "LWV", "8:30AM-9:20AM", "Marek Rysz", "S-308",  testCourse3B, 1, 30);
    public Section testSection3B3 = new Section("060", "LWV", "12:30PM-1:20PM", "Marek Rysz", "S-308",   testCourse3B, 1, 30);
    public Section testSection3B4 = new Section("070", "LWV", "1:30PM-2:20PM", "Marek Rysz", "S-308",   testCourse3B, 1, 30);

    public Section testSection3C1 = new Section("030H", "LWV", "9:30AM-10:20AM", "Agnes Padovani", "S-307", testCourse3C, 1, 30);
    public Section testSection3C2 = new Section("040H", "LWV", "10:30AM-11:20AM", "Agnes Padovani", "S-307", testCourse3C, 1, 30);
    public Section testSection3C3 = new Section("066", "MJ", "12:30PM-1:45PM", "Yang Li", "S-307",  testCourse3C, 1, 30);
    public Section testSection3C4 = new Section("086", "MJ", "2:00PM-3:15PM", "Yang Li", "S-307",  testCourse3C, 1, 30);
    public Section testSection3C5 = new Section("096", "MJ", "3:30PM-4:45PM", "Yang Li", "S-307",  testCourse3C, 1, 30);

    public Section testSection4A1 = new Section("010", "LW", "7:30AM-9:20AM", "Noel Artiles", "II-114",   testCourse4A, 1, 50);
    public Section testSection4A2 = new Section("026", "MJ", "8:30AM-10:20AM", "Hector Colon", "II-114",   testCourse4A, 1, 50);
    public Section testSection4A3 = new Section("030", "LW", "9:30AM-11:20AM", "Noel Artiles", "II-114",   testCourse4A, 1, 50);
    public Section testSection4A4 = new Section("060", "LW", "12:30PM-2:20PM", "Saylisse Davila", "II-114", testCourse4A, 1, 50);
    public Section testSection4A5 = new Section("066", "MJ", "12:30PM-2:20PM", "Hector Colon", "II-114", testCourse4A, 1, 50);
    public Section testSection4A6 = new Section("090", "LW", "3:30PM-5:20PM", "Saylisse Davila", "II-114", testCourse4A, 1, 50);

    public Section testSection4B1 = new Section("016", "MJ", "7:30AM-8:45AM", "Mayra Mendez", "II-201", testCourse4B, 1, 35);
    public Section testSection4B2 = new Section("020", "LWV", "8:30AM-9:20AM", "Vancy Mendez", "II-201",  testCourse4B, 1, 35);
    public Section testSection4B3 = new Section("030", "LWV", "9:30AM-10:20AM", "Griselle Toro", "II-201",   testCourse4B, 1, 35);
    public Section testSection4B4 = new Section("036", "MJ", "9:00AM-10:15AM", "Mayra Mendez", "II-201",   testCourse4B, 1, 35);
    public Section testSection4B5 = new Section("040", "LWV", "10:30AM-11:20AM", "Nancy Mendez", "II-201",   testCourse4B, 1, 35);
    public Section testSection4B6 = new Section("070", "LWV", "1:30PM-2:30PM", "Griselle Toro", "II-201", testCourse4B,1, 35);

    
    public Section testSection5A1 = new Section("066", "MJ", "12:30PM-1:45PM", "Maria C. Quintero", "CH-224", testCourse5A, 1, 33);
    public Section testSection5A2 = new Section("086", "MJ", "2:00PM-3:15PM",  "Maria C. Quintero", "CH-005",testCourse5A, 1, 32);
    public Section testSection5A3 = new Section("096", "MJ", "3:30PM-4:45PM",   "Lawrence Chott", "CH-005", testCourse5A, 1, 31);
    public Section testSection5A4 = new Section("100", "LW", "4:30PM-5:45PM",   "Stephania Uwakweh Evuleocha", "CH-319", testCourse5A, 1, 30);
    public Section testSection5A5 = new Section("101", "LW", "4:30PM-5:45PM",   "Lawrence Chott", "CH-125", testCourse5A, 1, 32);
    public Section testSection5A6 = new Section("116", "MJ", "5:00PM-6:15PM", "Lawrence Chott", "CH-005", testCourse5A, 1,31);
    public Section testSection5A7 = new Section("120", "LW", "6:00PM-7:15PM", "Lawrence Chott", "CH-125", testCourse5A,1, 32);
    
    public Section testSection5B1 = new Section("120", "LW", "6:00PM-7:15PM", "Stephania Uwakweh Evuleocha", "CH-325", testCourse5B, 1, 31);

    public Section testSection5C1 = new Section("010", "LMV", "7:30AM-8:20AM", "Laura Buitrago Garcia", "CH-224", testCourse5C, 1, 30);
    public Section testSection5C2 = new Section("016", "MJ", "7:30AM-8:20AM", "Myrna Rivera Montijo", "CH-318", testCourse5C, 1, 30);
    public Section testSection5C3 = new Section("017", "MJ", "7:30AM-8:20AM", "Waleska Morciglio Quintana", "CH-221", testCourse5C, 1, 30);
    public Section testSection5C4 = new Section("018", "MJ", "7:30AM-8:20AM", "Iris Toro Manzano", "CH-123", testCourse5C, 1, 30);
    public Section testSection5C5 = new Section("020", "LWV", "8:30AM-9:20AM", "Laura Buitrago Garcia", "CH-224", testCourse5C, 1, 30);
    public Section testSection5C6 = new Section("030", "LWV", "9:30AM-10:20AM", "Maria Orejarena Torres", "CH-224", testCourse5C, 1, 30);
    public Section testSection5C7 = new Section("036", "MJ", "9:00AM-10:15AM", "Myrna Rivera Montijo", "CH-318", testCourse5C, 1, 30);
    public Section testSection5C8 = new Section("037", "MJ", "9:00AM-10:15AM", "Waleska Morciglio Quintana", "CH-221", testCourse5C, 1, 30);
    public Section testSection5C9 = new Section("038", "MJ", "9:00AM-10:15AM", "Iris Toro Manzano", "CH-123", testCourse5C, 1, 30);
    public Section testSection5C10 = new Section("040", "LWV", "10:30AM-11:20AM", "Maria Orejarena Torres", "CH-224", testCourse5C, 1, 30);
    public Section testSection5C11 = new Section("041", "LWV", "10:30AM-11:20AM", "Rosita Rivera", "CH-324", testCourse5C, 1, 30);
    public Section testSection5C12 = new Section("050", "LWV", "11:30AM-12:20PM", "William Carrero Vale", "CH-224", testCourse5C, 1, 30);
    public Section testSection5C13 = new Section("051", "LWV", "11:30AM-12:20PM", "Rosita Rivera", "CH-324", testCourse5C, 1, 30);
    public Section testSection5C14 = new Section("060", "LWV", "12:30PM-1:20PM", "William Carrero Vale", "CH-224", testCourse5C, 1, 30);
    public Section testSection5C15 = new Section("061", "LWV", "12:30PM-1:20PM", "Ambar Rivera Beede", "CH-324", testCourse1E, 1, 30);
    public Section testSection5C16 = new Section("070", "LWV", "1:30PM-2:20PM", "Ambar Rivera Beede", "CH-224", testCourse1E, 1, 30);
    public Section testSection5C17 = new Section("086", "MJ", "2:00PM-3:15PM", "Myrna Rivera Montijo", "CH-318", testCourse5C, 1, 30);
    public Section testSection5C18 = new Section("096", "MJ", "3:30PM-4:45PM", "Myrna Rivera Montijo", "CH-318", testCourse5C, 1, 30);
    public Section testSection5C19 = new Section("100", "LW", "4:30PM-5:45PM", "Iris Toro Manzano", "CH-221", testCourse5C, 1, 30);
    public Section testSection5C20 = new Section("100L", "V", "4:30PM-5:20PM", "Rosita Rivera", "CH-325", testCourse5C, 1, 30);
    public Section testSection5C21 = new Section("116", "MJ", "5:00PM-6:15PM", "Iris Toro Manzano", "CH-222", testCourse5C, 1, 30);
    public Section testSection5C22 = new Section("117", "MJ", "5:00PM-6:15PM", "Javier I Fabre Quiñones", "CH-223", testCourse5C, 1, 30);
    public Section testSection5C23 = new Section("120", "LW", "6:00PM-7:15PM", "Javier I Fabre Quiñones", "CH-221", testCourse5C, 1, 30);
    public Section testSection5C24 = new Section("130L", "V", "7:30PM-8:20PM", "Rosita Rivera", "CH-221", testCourse5C, 1, 30);


    public Section testSection5D1 = new Section("010", "LWV", "12:30PM-1:45PM", "Javier I Fabre Quiñones", "CH-223", testCourse5D, 1, 30);
    public Section testSection5D2 = new Section("020", "LWV", "2:00PM-3:15PM", "Javier I Fabre Quiñones", "CH-221", testCourse5D, 1, 30);
    public Section testSection5D3 = new Section("060", "V", "3:30PM-4:45PM", "Rosita Rivera", "CH-221", testCourse5D, 1, 60);


    public Section testSection5F1 = new Section("020", "LWV", "8:30AM-9:20AM", "Diego Zaragoza Padilla", "CH-222", testCourse5F, 1, 31);
    public Section testSection5F2 = new Section("030", "LWV", "9:30AM-10:20AM", "Diego Zaragoza Padilla", "CH-222", testCourse5F, 1, 30);



    public Section testSection5G1 = new Section("070", "LWV", "1:30PM-2:20PM", "Dariana Alicea Torres", "CH-324", testCourse5G, 1, 30);
    public Section testSection5G2 = new Section("096", "MJ", "3:30PM-4:45PM", "Dariana Alicea Torres", "CH-319", testCourse5G, 1, 30);



    public Section testSection5H1 = new Section("070", "LWV", "1:30PM-2:20PM", "Gabriel E. Romaguera Rodriguez", "CH-005", testCourse5H, 1, 31);
    public Section testSection5H2 = new Section("080", "LWV", "2:30PM-3:20PM", "Nicholas Haydock", "CH-005", testCourse5H, 1, 30);
    public Section testSection5H3 = new Section("100", "LW", "4:30PM-5:45PM", "Linda Rodriguez", "CH-124", testCourse5H, 1, 66);
    public Section testSection5H4 = new Section("116", "MJ", "5:00PM-6:15PM", "Gabriel E. Romaguera Rodriguez", "CH-324", testCourse5H, 1, 45);
    public Section testSection5H5 = new Section("120", "LW", "6:00PM-7:15PM", "Linda Rodriguez", "CH-124", testCourse5H, 1, 64);
        

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
        // testMatricula3.addSection(testSection1D1,testCourse1D);

        // testStudent1.addPriority(testCourse1B);
        testStudent1.addPriority(testCourse2A);
        testStudent1.addPriority(testCourse3A);
        testStudent1.addPriority(testCourse4A);

        try {

            db = new DBHandler("sql-dabatase", true);
            
            db.SaveDepartment(testDepartment1);
            db.SaveDepartment(testDepartment2);
            db.SaveDepartment(testDepartment3);
            db.SaveDepartment(testDepartment4);
            db.SaveDepartment(testDepartment5);
            
            db.SaveUser(testUser1);
            db.SaveStudent(testStudent1);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
