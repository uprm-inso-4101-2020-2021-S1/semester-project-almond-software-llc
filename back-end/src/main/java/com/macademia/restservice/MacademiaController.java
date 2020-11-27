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

@CrossOrigin(origins = "https://almond-macademia-front-end.herokuapp.com")
@RestController
public class MacademiaController {

	class ToastMessage {
		String alertType;
		String alertTitle;
		String alertMessage;

		ToastMessage(String alertType, String alertTitle, String alertMessage) {
			this.alertType = alertType;
			this.alertTitle = alertTitle;
			this.alertMessage = alertMessage;
		}

		public String getAlertType() {
			return this.alertType;
		}

		public String getAlertTitle() {
			return this.alertTitle;
		}

		public String getAlertMessage() {
			return this.alertMessage;
		}

	}

	private JsonTest tester = new JsonTest();
	private Map<String, Student> currentStudents = new HashMap<String, Student>();

	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		try {
			return tester.db.getStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/macademia")
	public String macademia(@RequestParam(value = "firstName", defaultValue = "NULL1") String firstName,
			@RequestParam(value = "lastName", defaultValue = "NULL2") String lastName) {
		return "Welcome! " + firstName + " " + lastName;
	}

	@GetMapping("/deleteUser")
	public void deleteUser(@RequestParam(value = "user") String user) {
		try {			
			tester.db.deleteUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			try {
				tester.db.SaveStudent(currentStudents.get(user));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public List<Department> department() {
		try {
			return tester.db.getDepartments();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/priority")
	public List<Course> priority(@RequestParam(value = "user") String user) {
		return currentStudents.get(user).getPriority();
	}

	@GetMapping("/matriculas")
	public Collection<Matricula> matriculas(@RequestParam(value = "user") String user) {
		return currentStudents.get(user).getMatriculas();
	}

	@PostMapping("/transferSection")
	public ToastMessage transferSection(@RequestParam(value = "sourceListIndex") int sourceListIndex,
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
		ToastMessage tempToast = null;
		try {
			tempCourse = tester.db.getCourse(tempSection.getCourseCode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add
		if (targetListIndex == 0) {
			if (!currentStudents.get(user).getPriority().contains(tempCourse)) {
				currentStudents.get(user).getPriority().add(tempCourse);
				tempToast = new ToastMessage("success", "Success!",
						"Course has been successfully added to Priority Courses from Matricula");
			} else {
				tempToast = new ToastMessage("error", "Error!", "Course already exists in Priority Courses");
			}
		} else {
			if (!currentStudents.get(user).getMatricula(tempPeriod).getCourses().contains(tempCourse)) {
				if (conflict) {
					tempToast = new ToastMessage("error", "Error!", "Course will conflict with schedule");
				} else {
					currentStudents.get(user).getMatricula(tempPeriod).addSection(tempSection, tempCourse);
					tempToast = new ToastMessage("success", "Success!",
							"Course has been successfully added to Matricula from Priority Courses");
				}
			} else {
				tempToast = new ToastMessage("error", "Error!", "Course already exists in Matricula");
			}
		}
		// remove
		if (sourceListIndex == 0) {
			if (!conflict)
				currentStudents.get(user).removePriority(priorityCourseIndex);
		} else {
			currentStudents.get(user).getMatricula(tempPeriod).removeSection(tempSection, tempCourse);
			currentStudents.get(user).getMatricula(tempPeriod).removeCourse(tempCourse);
		}
		// save
		try {
			tester.db.SaveStudent(currentStudents.get(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempToast;
	}

	@PostMapping("/removeSection")
	public ToastMessage removeSection(@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "matriculaYear") int matriculaYear,
			@RequestParam(value = "matriculaPeriod") String matriculaPeriod,
			@RequestParam(value = "user") String user) {
		MatriculaPeriod tempPeriod = new MatriculaPeriod(matriculaYear, matriculaPeriod);
		Course tempCourse = currentStudents.get(user).getMatricula(tempPeriod).getCourses().get(valueIndex);
		Section tempSection = currentStudents.get(user).getMatricula(tempPeriod).getSections().get(valueIndex);
		ToastMessage tempToast = null;
		currentStudents.get(user).getMatricula(tempPeriod).removeSection(tempSection, tempCourse);
		tempToast = new ToastMessage("warning", "Section Removed!",
				"Section has been successfully removed from Matricula");
		// save
		try {
			tester.db.SaveStudent(currentStudents.get(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempToast;
	}

	public boolean checkConflicts(Section s, List<Section> l) {
		// if s start <= temp end && s end >= temp end, if temp start <= s end && temp
		// end >= s end, false
		for (Section temp : l) {
			if (checkConflictsDays(s, temp) && ((s.getPeriod().getStartMinutes() <= temp.getPeriod().getEndMinutes()
					&& s.getPeriod().getEndMinutes() >= temp.getPeriod().getEndMinutes())
					|| (temp.getPeriod().getStartMinutes() <= s.getPeriod().getEndMinutes()
							&& temp.getPeriod().getEndMinutes() >= s.getPeriod().getEndMinutes()))) {
				return true;
			}
		}
		return false;
	}

	public boolean checkConflictsDays(Section a, Section b) {
		for (Character c : a.getDay().toCharArray()) {
			if (b.getDay().contains(c.toString())) {
				return true;
			}
		}
		return false;
	}

	@PostMapping("/transferCourse")
	public ToastMessage transferCourse(@RequestParam(value = "sourceListIndex") int sourceListIndex,
			@RequestParam(value = "targetListIndex") int targetListIndex,
			@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "priorityCourseIndex") int priorityCourseIndex,
			@RequestParam(value = "departmentIndex") int departmentIndex,
			@RequestParam(value = "matriculaPeriod") String matriculaPeriod,
			@RequestParam(value = "user") String user) {
		Course tempCourse = courseListSwitch(sourceListIndex, departmentIndex, user).get(valueIndex);
		ToastMessage tempToast = null;
		// add
		if (targetListIndex == 0) {
			if (currentStudents.get(user).getPriority().contains(tempCourse)) {
				tempToast = new ToastMessage("error", "Error!", "Course already exists in Priority Courses");
			} else if (currentStudents.get(user).getMatriculas().get(0).getCourses().contains(tempCourse)) {
				tempToast = new ToastMessage("error", "Error!", "Course already exists in Matricula");
			} else if (!isAvailable(matriculaPeriod, tempCourse)) {
				tempToast = new ToastMessage("error", "Error!", "Course is not offered this semester");
			} else {
				currentStudents.get(user).getPriority().add(tempCourse);
				tempToast = new ToastMessage("success", "Success!",
						"Course has been successfully added from Department to Priority Courses");
			}
		}
		// remove
		if (sourceListIndex == 0) {
			currentStudents.get(user).removePriority(priorityCourseIndex);
		}
		// save
		try {
			tester.db.SaveStudent(currentStudents.get(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempToast;
	}

	@PostMapping("/removeCourse")
	public ToastMessage removeCourse(@RequestParam(value = "valueIndex") int valueIndex,
			@RequestParam(value = "user") String user) {
		// Course tempCourse = currentStudents.get(user).getPriority().get(valueIndex);
		ToastMessage tempToast = null;
		currentStudents.get(user).removePriority(valueIndex);
		tempToast = new ToastMessage("warning", "Course Removed!",
				"Course has been successfully removed from Priority Courses");
		// save
		try {
			tester.db.SaveStudent(currentStudents.get(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempToast;
	}

	private boolean isAvailable(String period, Course c) {
		switch (period) {
			case "FALL":
				return c.getAvailability().contains("FALL");
			case "SPRING":
				return c.getAvailability().contains("SPRING");
			case "SUMMER":
				return c.getAvailability().contains("SUMMER");
		}
		return false;
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