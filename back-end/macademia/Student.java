package macademia;

import macademia.auth.User;

/**
 * Class that holds a student, which contains:
 *  - Matricula Object
 *  - Name
 *  - Department
 *  - Student Number
 * @author igtampe
 */
public class Student extends User {

	//-[Variables]----------------------------------------------------------------------
	
	//Change to Matricula once its created
	Object matricula;
	
	//Change to Department once its created
	Department department;
	
	private String Name;
	private String StudentNumber;
	
	//-[Constructors]----------------------------------------------------------------------
	
	/**
	 * Turns a User into a Student by retrieving their student details from the database.
	 * @param user
	 */
	public Student(User user) {
		super(user);
		
		//Get details from this user from the database
		//GetDetailsFromDatabase(this.getUsername()); or something like this.
	}
	
	/**
	 * Creates a student object with the following details.
	 * @param user User object
	 * @param Name Name of the student
	 * @param StudentNumber Student number of the student
	 * @param Matricula Matricula of this student
	 * @param Department Department of this student
	 */
	public Student(User user, String Name, String StudentNumber, Object Matricula, Department Department) {
		super(user);
		
		this.Name=Name;
		this.StudentNumber=StudentNumber;
		
		//Uncomment this line once the Matricula/Department object is created
		this.department=Department;
		this.matricula=Matricula;
		
	}
	
	//-[Getters]----------------------------------------------------------------------
	
	/**
	 * Gets this student's Student Number (ID)
	 * @return
	 */
	public String getStudentNumber() {return StudentNumber;}
	
	/**
	 * Gets this student's Name (Not Username)
	 * @return
	 */
	public String getName() {return Name;}

	/**
	 * Gets this student's department.
	 * @return
	 */
	public Department getDepartment() {return department;}
	
	/**
	 * Gets this student's Matricula
	 * @return
	 */
	public Object getMatricula() {return matricula;}
	
	//-[Overrides]----------------------------------------------------------------------
	
	/**
	 * Returns this student as a displayable string
	 * @return NAME (STUDENT_NUMBER)
	 */
	public String toString() {return Name + "(" + StudentNumber + ")";		}
	
	/**
	 * Checks if an object is equal to this student
	 * @param obj
	 * @return True if and only if the object is not null, is an instance of student, and has the same student ID
	 */
	public boolean equals(Object obj) {
		if(obj==null) {return false;}
		if(obj instanceof Student) {
			Student OtherStudent = (Student)obj;
			return OtherStudent.StudentNumber==StudentNumber;
		}
		return false;
	}
	
}
