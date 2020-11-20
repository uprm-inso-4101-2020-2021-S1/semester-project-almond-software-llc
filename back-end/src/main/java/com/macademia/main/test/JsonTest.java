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

    public Section testSectionA01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Juan N. Onlee", "S424", testCourseA, 1, 50);
    public Section testSectionA02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Juan N. Onlee", "S423", testCourseA, 1, 50);
    public Section testSectionA03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Juan N. Onlee", "S422", testCourseA, 1, 50);
    public Section testSectionA04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Juan N. Onlee", "S421", testCourseA, 1, 50);

    public Section testSectionB01 = new Section("01", "MJ", "12:00PM-12:50PM", "Dr. Too Late", "SH321", testCourseB, 1, 50);
    public Section testSectionB02 = new Section("02", "MJ", "12:30PM-1:20PM", "Dr. Too Late", "SH322", testCourseB, 1, 50);
    public Section testSectionB03 = new Section("03", "MJ", "1:00PM-1:50PM", "Dr. Too Late", "SH323", testCourseB, 1, 50);
    public Section testSectionB04 = new Section("04", "MJ", "1:30PM-2:20PM", "Dr. Too Late", "SH324", testCourseB, 1, 50);

    public Section testSectionC01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourseC, 1, 50);
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

    public Section testSectionG01 = new Section("01", "LWV", "12:00PM-12:50PM", "Dr. Hugh Mungus", "Ch691", testCourseG, 1, 50);
    public Section testSectionG02 = new Section("02", "LWV", "12:30PM-1:20PM", "Dr. Hugh Mungus", "Ch692", testCourseG, 1, 50);
    public Section testSectionG03 = new Section("03", "LWV", "1:00PM-1:50PM", "Dr. Hugh Mungus", "Ch693", testCourseG, 1, 50);
    public Section testSectionG04 = new Section("04", "LWV", "1:30PM-2:20PM", "Dr. Hugh Mungus", "Ch694", testCourseG, 1, 50);

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

        try {

            db = new DBHandler("sql-dabatase", true);
            
            db.SaveDepartment(testDepartmentA);
            db.SaveDepartment(testDepartmentB);
            db.SaveDepartment(testDepartmentC);
            db.SaveDepartment(testDepartmentD);

            db.SaveUser(testUserA);
            db.SaveStudent(testStudentA);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
