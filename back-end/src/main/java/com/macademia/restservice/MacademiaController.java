package com.macademia.restservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macademia.main.*;
import com.macademia.main.auth.User;
import com.macademia.main.test.JsonTest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MacademiaController {

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
			// if user exists, continue, else don't do s ;)
			if (tester.db.UserExists(user)) {
				if (tester.db.getUser(user).checkPassword(password)) {
					currentStudents.put(user, tester.db.getStudent(tester.db.getUser(user)));
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping("/logout")
	public boolean logout(@RequestParam(value = "user") String user) {
		if (currentStudents.containsKey(user)) {
			currentStudents.remove(user);
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/register")
	public void register(@RequestParam(value = "user") String user, @RequestParam(value = "password") String password,
			@RequestParam(value = "fullName") String fullName,
			@RequestParam(value = "studentNumber") String studentNumber,
			@RequestParam(value = "departmentCode") String departmentCode) {
		try {
			// initalize & save user
			User tempUser = new User(user, password);
			tester.db.SaveUser(tempUser);
			// initalize & save student
			Student tempStudent = new Student(tempUser, fullName, studentNumber,
					tester.db.getDepartment(departmentCode));
			MatriculaPeriod tempPeriod = new MatriculaPeriod(2022, "FALL"); // default value for now
			Matricula tempMatricula = new Matricula(new ArrayList<Section>(), tempPeriod);
			Turn tempTurn = new Turn("1/1/2023 12:00-1/1/2023 12:30");
			tempStudent.addMatricula(tempMatricula);
			tempStudent.SetTurn(tempTurn);
			tester.db.SaveStudent(tempStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/userExists")
	public boolean userExists(@RequestParam(value = "user") String user) {
		try {
			return tester.db.UserExists(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@GetMapping("/userActive")
	public boolean userActive(@RequestParam(value = "user") String user) {
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

	@PostMapping("/transferSection")
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
		Boolean conflict = checkConflicts(tempSection,
				currentStudents.get(user).getMatricula(tempPeriod).getSections());
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
			if (!currentStudents.get(user).getMatricula(tempPeriod).getCourses().contains(tempCourse) && !conflict) {

				currentStudents.get(user).getMatricula(tempPeriod).addSection(tempSection, tempCourse);
			}
		}
		// remove
		if (sourceListIndex == 0) {
			if (!conflict)
				currentStudents.get(user).getPriority().remove(priorityCourseIndex);
		} else {
			currentStudents.get(user).getMatricula(tempPeriod).getSections().remove(valueIndex);
			currentStudents.get(user).getMatricula(tempPeriod).getCourses().remove(tempCourse);
		}
		// save
		try {
			tester.db.SaveUser(currentStudents.get(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkConflicts(Section s, List<Section> l) {
		// if s start <= temp end && s end >= temp end, if temp start <= s end && temp
		// end >= s edn, false
		for (Section temp : l) {
			if ((s.getPeriod().getStartMinutes() <= temp.getPeriod().getEndMinutes()
					&& s.getPeriod().getEndMinutes() >= temp.getPeriod().getEndMinutes())
					|| (temp.getPeriod().getStartMinutes() <= s.getPeriod().getEndMinutes()
							&& temp.getPeriod().getEndMinutes() >= s.getPeriod().getEndMinutes())) {
				return true;
			}
		}
		return false;
	}

	@PostMapping("/transferCourse")
	public void transferCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex,
			@RequestParam(value = "matriculaIndex") int matriculaIndex, @RequestParam(value = "user") String user) {
		Course tempCourse = courseListSwitch(sourceListIndex, departmentIndex, user).get(valueIndex);
		// add
		if (targetListIndex == 0) {
			if ((!currentStudents.get(user).getPriority().contains(tempCourse)
					|| currentStudents.get(user).getPriority().isEmpty())
					&& !currentStudents.get(user).getMatriculas().get(0).getCourses().contains(tempCourse)) {
				currentStudents.get(user).getPriority().add(tempCourse);
			}
		}
		// remove
		if (sourceListIndex == 0) {
			currentStudents.get(user).getPriority().remove(priorityCourseIndex);
		}
		// save
		try {
			tester.db.SaveUser(currentStudents.get(user));
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