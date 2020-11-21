package com.macademia.restservice;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;

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
	private Map<String, Student> currentStudents = new HashMap<String, Student>();

	@GetMapping("/macademia")
	public String macademia(@RequestParam(value = "firstName", defaultValue = "NULL1") String firstName,
			@RequestParam(value = "lastName", defaultValue = "NULL2") String lastName) {
		return "Welcome! " + firstName + " " + lastName;
	}

	@GetMapping("/login")
	public boolean login(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password) {
		try {
			if (tester.db.getUser(user).checkPassword(password)) {
				currentStudents.put(user, tester.db.getStudent(tester.db.getUser(user)));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("/userActive")
	public boolean login(@RequestParam(value = "user") String user) {
		return currentStudents.containsKey(user);
	}

	@GetMapping("/departments")
	public List<Department> department() throws SQLException {
		return tester.db.getDepartments();
	}

	@GetMapping("/priority")
	public List<Course> priority(@RequestParam(value = "user") String user) throws SQLException {
		return currentStudents.get(user).getPriority();
	}

	@GetMapping("/matriculas")
	public Collection<Matricula> matriculas(@RequestParam(value = "user") String user) throws SQLException {
		return currentStudents.get(user).getMatriculas();
	}

	@GetMapping("/transferSection")
	public void transferSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "matriculaYear") int matriculaYear,
			@RequestParam(value = "matriculaPeriod") String matriculaPeriod,
			@RequestParam(value = "user") String user) {

		Section tempSection = sectionListSwitch(sourceListIndex, priorityCourseIndex, matriculaYear, matriculaPeriod,
				user).get(valueIndex);
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
			if (!currentStudents.get(user).getPriority().contains(tempCourse))
				currentStudents.get(user).getPriority().add(tempCourse);
		} else {
			if (!currentStudents.get(user).getMatricula(tempPeriod).getCourses().contains(tempCourse)) {
				currentStudents.get(user).getMatricula(tempPeriod).addSection(tempSection, tempCourse);
			}
		}
		// remove
		if (sourceListIndex == 0) {
			currentStudents.get(user).getPriority().remove(priorityCourseIndex);
		} else {
			currentStudents.get(user).getMatricula(tempPeriod).getSections().remove(valueIndex);
			currentStudents.get(user).getMatricula(tempPeriod).getCourses().remove(tempCourse);
		}
		// save
		try {
			tester.db.SaveEverything();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/transferCourse")
	public void transferCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex, @RequestParam(value = "user") String user) {

		Course tempCourse = courseListSwitch(sourceListIndex, departmentIndex, user).get(valueIndex);
		if (!currentStudents.get(user).getPriority().contains(tempCourse)) {
			currentStudents.get(user).getPriority().add(tempCourse);
		}
		currentStudents.get(user).getPriority().remove(priorityCourseIndex);
		// save
		try {
			tester.db.SaveEverything();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Section> sectionListSwitch(int sourceListIndex, int priorityCourseIndex, int matriculaYear,
			String matriculaPeriod, String user) {
		switch (sourceListIndex) {
			case 0:
				return currentStudents.get(user).getPriority().get(priorityCourseIndex).getSections();
			case 2:
				return currentStudents.get(user).getMatricula(new MatriculaPeriod(matriculaYear, matriculaPeriod))
						.getSections();
			default:
				return null;
		}
	}

	private List<Course> courseListSwitch(int sourceListIndex, int departmentIndex, String user) {
		switch (sourceListIndex) {
			case 0:
				return currentStudents.get(user).getPriority();
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