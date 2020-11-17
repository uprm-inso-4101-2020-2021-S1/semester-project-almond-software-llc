package com.macademia.main.test;

import com.macademia.main.*;

enum per {
    SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL;
}

public class JsonTest {

    public MatriculaPeriod testPeriod = new MatriculaPeriod(2020, "SPRING");
    public Department testDepartment = new Department("The Department of Testing", "TEST","Green");
    public Matricula testMatriculaA = new Matricula(testPeriod);
    public Matricula testMatriculaB = new Matricula(testPeriod);

    public Course testPrereqCourseA = new Course("Test Prerequisite Course A", testDepartment, "4001", 1);
    public Course testPrereqCourseB = new Course("Test Prerequisite Course B", testDepartment, "3002", 2);
    public Course testPrereqCourseC = new Course("Test Prerequisite Course C", testDepartment, "2003", 3);
    public Course testPrereqCourseD = new Course("Test Prerequisite Course D", testDepartment, "1004", 4);

    public Course testCoreqCourseA = new Course("Test Corequisite Course A", testDepartment, "4004", 1);
    public Course testCoreqCourseB = new Course("Test Corequisite Course B", testDepartment, "3003", 2);
    public Course testCoreqCourseC = new Course("Test Corequisite Course C", testDepartment, "2002", 3);
    public Course testCoreqCourseD = new Course("Test Corequisite Course D", testDepartment, "1001", 4);

    public Course testCourseA = new Course("Test Course A", testDepartment, "4000", 1);
    public Course testCourseB = new Course("Test Course B", testDepartment, "3000", 2);
    public Course testCourseC = new Course("Test Course C", testDepartment, "2000", 3);
    public Course testCourseD = new Course("Test Course D", testDepartment, "1000", 4);

    public Section testSectionA01 = new Section("01", "LWV", "12:00pm", "Dr. Juan N. Onlee", "S424", testCourseA, 1, 50);
    public Section testSectionA02 = new Section("02", "LWV", "12:30pm", "Dr. Juan N. Onlee", "S423", testCourseA, 1, 50);
    public Section testSectionA03 = new Section("03", "LWV", "1:00pm", "Dr. Juan N. Onlee", "S422", testCourseA, 1, 50);
    public Section testSectionA04 = new Section("04", "LWV", "1:30pm", "Dr. Juan N. Onlee", "S421", testCourseA, 1, 50);

    public Section testSectionB01 = new Section("01", "MJ", "12:00pm", "Dr. Too Mai", "SH321", testCourseB, 1,50);
    public Section testSectionB02 = new Section("02", "MJ", "12:30pm", "Dr. Too Mai", "SH322", testCourseB, 1,50);
    public Section testSectionB03 = new Section("03", "MJ", "1:00pm", "Dr. Too Mai", "SH323", testCourseB, 1,50);
    public Section testSectionB04 = new Section("04", "MJ", "1:30pm", "Dr. Too Mai", "SH324", testCourseB, 1,50);

    public Section testSectionC01 = new Section("01", "LWV", "12:00pm", "Dr. Hugh Mungus", "Ch691", testCourseC, 1,50);
    public Section testSectionC02 = new Section("02", "LWV", "12:30pm", "Dr. Hugh Mungus", "Ch692", testCourseC, 1,50);
    public Section testSectionC03 = new Section("03", "LWV", "1:00pm", "Dr. Hugh Mungus", "Ch693", testCourseC, 1,50);
    public Section testSectionC04 = new Section("04", "LWV", "1:30pm", "Dr. Hugh Mungus", "Ch694", testCourseC, 1,50);

    public Section testSectionD01 = new Section("01", "MJ", "12:00pm", "Dr. Brock O. Lee", "ADEM777", testCourseD, 1,50);
    public Section testSectionD02 = new Section("02", "MJ", "12:30pm", "Dr. Brock O. Lee", "ADEM778", testCourseD, 1,50);
    public Section testSectionD03 = new Section("03", "MJ", "1:00pm", "Dr. Brock O. Lee", "ADEM779", testCourseD, 1,50);
    public Section testSectionD04 = new Section("04", "MJ", "1:30pm", "Dr. Brock O. Lee", "ADEM775", testCourseD, 1,50);

    public JsonTest() {

        testCourseA.addPrereq(testPrereqCourseA);
        testCourseA.addPrereq(testPrereqCourseB);
        testCourseA.addPrereq(testPrereqCourseC);
        testCourseA.addPrereq(testPrereqCourseD);

        testCourseA.addCoreq(testCoreqCourseA);
        testCourseA.addCoreq(testCoreqCourseB);
        testCourseA.addCoreq(testCoreqCourseC);
        testCourseA.addCoreq(testCoreqCourseD);
        
        testMatriculaA.addSection(testSectionA01,testCourseA);
        testMatriculaA.addSection(testSectionB02,testCourseB);
        testMatriculaA.addSection(testSectionC03,testCourseC);
        testMatriculaA.addSection(testSectionD04,testCourseD);
    }

}
