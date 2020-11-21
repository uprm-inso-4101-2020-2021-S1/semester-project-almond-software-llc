package com.macademia.restservice;

import java.io.Console;
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

	@GetMapping("/currentMatricula")
	public Matricula currentMatricula() throws SQLException {
		return currentStudent.getCurrentMatricula();
	}

	@GetMapping("/addSection")
	public void addSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "matriculaYear") int matriculaYear,
			@RequestParam(value = "matriculaPeriod") String matriculaPeriod) {

		Section tempSection = sectionListSwitch(sourceListIndex, priorityCourseIndex, matriculaYear, matriculaPeriod).get(valueIndex);
		Course tempCourse = null;
		MatriculaPeriod tempPeriod = new MatriculaPeriod(matriculaYear, matriculaPeriod);

		try {
			tempCourse = tester.db.getCourse(tempSection.getCourseCode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add
		if (targetListIndex == 0) {
			if (!currentStudent.getPriority().contains(tempCourse))
				currentStudent.getPriority().add(tempCourse);
		} else {
			if (!currentStudent.getMatricula(tempPeriod).getCourses().contains(tempCourse)) {
				currentStudent.getMatricula(tempPeriod).addSection(tempSection, tempCourse);
			}
		}
		// remove
		if (sourceListIndex == 0) {
			currentStudent.getPriority().remove(priorityCourseIndex);
		} else {
			currentStudent.getMatricula(tempPeriod).getSections().remove(valueIndex);
			currentStudent.getMatricula(tempPeriod).getCourses().remove(tempCourse);
		}
	}

	// FIX
	// TRY ADDING THE REMOVE FUNCTIONALITY IN THE ADD FUNCTIONALITY SO THAT IT'S IN
	// SEQUENCE, AND NOT GLITCHED OUT
	@GetMapping("/removeSection")
	public void removeSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex,
			@RequestParam(value = "matriculaYear") int matriculaYear,
			@RequestParam(value = "matriculaPeriod") String matriculaPeriod) {
		if (sourceListIndex == 0) {
			courseListSwitch(sourceListIndex, departmentIndex).remove(valueIndex);
		} else {
			sectionListSwitch(sourceListIndex, priorityCourseIndex, matriculaYear, matriculaPeriod).remove(valueIndex);
		}
	}

	@GetMapping("/addCourse")
	public void addCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex) {
		Course tempCourse = courseListSwitch(sourceListIndex, departmentIndex).get(valueIndex);
		// add
		if (!currentStudent.getPriority().contains(tempCourse)) {
			currentStudent.getPriority().add(tempCourse);
		}
		// remove
		currentStudent.getPriority().remove(priorityCourseIndex);
	}

	@GetMapping("/removeCourse")
	public List<Course> removeCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex) {
		courseListSwitch(sourceListIndex, departmentIndex).remove(valueIndex);
		return courseListSwitch(sourceListIndex, departmentIndex);
	}

	private List<Section> sectionListSwitch(int sourceListIndex, int priorityCourseIndex, int matriculaYear,
			String matriculaPeriod) {
		switch (sourceListIndex) {
			case 0:
				return currentStudent.getPriority().get(priorityCourseIndex).getSections();
			case 2:
				return currentStudent.getMatricula(new MatriculaPeriod(matriculaYear, matriculaPeriod)).getSections();
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
					return tester.db.getDepartments().get(departmentIndex).getCourses();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			default:
				return null;
		}
	}

}