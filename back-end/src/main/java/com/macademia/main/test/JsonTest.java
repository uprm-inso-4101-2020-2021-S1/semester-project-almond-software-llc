package com.macademia.main.test;

import com.macademia.main.*;

public class JsonTest {

    public Department testDepartment = new Department("The Department of Testing", "TEST");
    public Matricula testMatricula = new Matricula("2020");

    public Course testPrereqCourseA = new Course("Test Prerequisite Course A", testDepartment, 4001, 1);
    public Course testPrereqCourseB = new Course("Test Prerequisite Course B", testDepartment, 3002, 2);
    public Course testPrereqCourseC = new Course("Test Prerequisite Course C", testDepartment, 2003, 3);
    public Course testPrereqCourseD = new Course("Test Prerequisite Course D", testDepartment, 1004, 4);

    public Course testCoreqCourseA = new Course("Test Corequisite Course A", testDepartment, 4004, 1);
    public Course testCoreqCourseB = new Course("Test Corequisite Course B", testDepartment, 3003, 2);
    public Course testCoreqCourseC = new Course("Test Corequisite Course C", testDepartment, 2002, 3);
    public Course testCoreqCourseD = new Course("Test Corequisite Course D", testDepartment, 1001, 4);

    public Course testCourseA = new Course("Test Course A", testDepartment, 4000, 1);
    public Course testCourseB = new Course("Test Course B", testDepartment, 3000, 2);
    public Course testCourseC = new Course("Test Course C", testDepartment, 2000, 3);
    public Course testCourseD = new Course("Test Course D", testDepartment, 1000, 4);

    public Section testSectionA = new Section("001", "LWV", "12:00pm", testCourseA);
    public Section testSectionB = new Section("002", "LWV", "12:30pm", testCourseA);
    public Section testSectionC = new Section("003", "LWV", "1:00pm", testCourseA);
    public Section testSectionD = new Section("004", "LWV", "1:30pm", testCourseA);

    public JsonTest() {

        testCourseA.addPrereq(testPrereqCourseA);
        testCourseA.addPrereq(testPrereqCourseB);
        testCourseA.addPrereq(testPrereqCourseC);
        testCourseA.addPrereq(testPrereqCourseD);

        testCourseA.addCoreq(testCoreqCourseA);
        testCourseA.addCoreq(testCoreqCourseB);
        testCourseA.addCoreq(testCoreqCourseC);
        testCourseA.addCoreq(testCoreqCourseD);

        testCourseA.addSection(testSectionA);
        testCourseA.addSection(testSectionB);
        testCourseA.addSection(testSectionC);
        testCourseA.addSection(testSectionD);

        testMatricula.addCourse(testCourseA);
        testMatricula.addCourse(testCourseB);
        testMatricula.addCourse(testCourseC);
        testMatricula.addCourse(testCourseD);

    }

}
