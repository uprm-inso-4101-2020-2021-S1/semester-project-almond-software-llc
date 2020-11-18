package com.macademia.restservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macademia.main.*;
import com.macademia.main.test.JsonTest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MacademiaController {

	//private static final String template = "Hello, %s!";
	//private final AtomicLong counter = new AtomicLong();
	private JsonTest tester = new JsonTest();
	private Student myStudent;

	@GetMapping("/macademia")
	public String macademia(@RequestParam(value = "firstName", defaultValue = "NULL1") String firstName,
			@RequestParam(value = "lastName", defaultValue = "NULL2") String lastName) {
		return "Welcome! " + firstName + " " + lastName;
	}

	@GetMapping("/course")
	public Course course() {
		return tester.testCourseA;
	}

	@GetMapping("/section")
	public Section section() {
		return tester.testSectionA01;
	}

	@GetMapping("/department")
	public Department department() {
		return tester.testDepartmentA;
	}

	@GetMapping("/departmentSections")
	public List<Section> departmentSections() {
		return tester.testDepartmentA.getSections();
	}

	@GetMapping("/myMatriculas")
	public List<Matricula> matricula() {
		return this.getMatriculas();
	}

	@GetMapping("/myList")
	public List<Section> myList() {
		return tester.testList;
	}

	@GetMapping("/addSection")

	public void addSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "courseIndex") int courseIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
		Section temp = listSwitch(sourceListIndex, matriculaIndex).get(courseIndex);
		if (targetListIndex < 2)
			listSwitch(targetListIndex, matriculaIndex).add(temp);
		//else
			//this.getMatriculas().get(matriculaIndex).addSection(temp);
	}

	@GetMapping("/removeSection")
	public void removeSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "courseIndex") int courseIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
		if (sourceListIndex < 2)
			listSwitch(sourceListIndex, matriculaIndex).remove(courseIndex);
		else
			this.getMatriculas().get(matriculaIndex)
					.removeSection(this.getMatriculas().get(matriculaIndex).getSections().get(matriculaIndex));
	}

	public List<Course> testingDatabase(@RequestParam(value = "user") String user,
			@RequestParam(value = "password") String password) {
		try {
			if (tester.db.getUser(user).checkPassword(password)) {
				myStudent = tester.db.getStudent(tester.db.getUser(user));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myStudent.getPriority();
	}

	private List<Section> listSwitch(int targetListIndex, int matriculaIndex) {
		switch (targetListIndex) {
			case 0:
				return tester.testList;
			case 1:
				return tester.testDepartmentA.getSections();
			case 2:
				return this.getMatriculas().get(matriculaIndex).getSections();
			default:
				return null;
		}
	}

	private List<Matricula> getMatriculas() {
		List<Matricula> result = new ArrayList<Matricula>();
		result.add(0, tester.testMatriculaB);
		result.add(0, tester.testMatriculaC);
		return result;
	}

}