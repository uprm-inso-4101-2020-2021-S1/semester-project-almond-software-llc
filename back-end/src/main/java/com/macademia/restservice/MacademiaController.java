package com.macademia.restservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();
	private JsonTest tester = new JsonTest();
	private Student currentStudent = null;

	@GetMapping("/macademia")
	public String macademia(@RequestParam(value = "firstName", defaultValue = "NULL1") String firstName,
			@RequestParam(value = "lastName", defaultValue = "NULL2") String lastName) {
		return "Welcome! " + firstName + " " + lastName;
	}

	@GetMapping("/login")
	public boolean login(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password) {
		try {
			if (tester.db.getUser(user).checkPassword(password)) {
				currentStudent = tester.db.getStudent(tester.db.getUser(user));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("/departments")
	public List<Department> department() throws SQLException {
		return tester.db.getDepartments();
	}

	@GetMapping("/priority")
	public List<Course> priority() throws SQLException {
		return currentStudent.getPriority();
	}

	@GetMapping("/matriculas")
	public Collection<Matricula> matriculas() throws SQLException {
		return currentStudent.getMatriculas();
	}

	@GetMapping("/addSection")
	public void addSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
		Section tempSection = sectionListSwitch(sourceListIndex, priorityCourseIndex, matriculaIndex).get(valueIndex);
		Course tempCourse = null;
		try {
			tempCourse = tester.db.getCourse(tempSection.getCourseCode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (targetListIndex == 0) {
			currentStudent.getPriority().get(priorityCourseIndex).addSection(tempSection);
		} else {
			((List<Matricula>) currentStudent.getMatriculas()).get(matriculaIndex).addSection(tempSection, tempCourse);
		}
	}

	@GetMapping("/removeSection")
	public void removeSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "courseIndex") int courseIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
	}

	@GetMapping("/addCourse")
	public void addCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
		Course tempCourse = courseListSwitch(sourceListIndex, departmentIndex).get(valueIndex);
		if (targetListIndex == 0) {
			currentStudent.getPriority().add(tempCourse);
		} else {
			try {
				tester.db.getDepartments().get(departmentIndex).AddCourse(tempCourse);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@GetMapping("/removeCourse")
	public void removeCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "courseIndex") int courseIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
	}

	private List<Section> sectionListSwitch(int sourceListIndex, int priorityCourseIndex, int matriculaIndex) {
		switch (sourceListIndex) {
			case 0:
				return currentStudent.getPriority().get(priorityCourseIndex).getSections();
			case 1:
				return ((List<Matricula>) currentStudent.getMatriculas()).get(matriculaIndex).getSections();
			default:
				return null;
		}
	}

	private List<Course> courseListSwitch(int sourceListIndex, int departmentIndex) {
		switch (sourceListIndex) {
			case 0:
				return currentStudent.getPriority();
			case 1:
				try {
					return (List<Course>) tester.db.getDepartments().get(departmentIndex).getCourses();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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