# Macademia Back-End

This is the Macademia Back-End. It is comprised of the following objects under the following packages under src/main/java:

## com.macademia.main
Macademia Main holds the main classes used for Macademia

### Course
Course is an object to hold course information, and holds all sections offered for this course. It includes the following properties and methods:

|Property|Description|
|-|-|
|Name|Name of this course (IE: Acting I)|
|Dept|ShortName of the department this course belongs to (IE: DRAM)|
|Code|Code of this course (IE: 4101)|
|CourseCode|Course code of this course (IE: DRAM4101)|
|Credits|Credits of this course|
|PreReq|List of other courses that are Prerequesites for this course|
|CoReq|List of other courses that are corequesites for this course|
|Color|Color of this course (Used by the front-end to render a course card). This property is handed down from the department|

|Method|Description|
|-|-|
|AddPrereq()|Adds a course to this course's prerequesites list|
|AddCoreq()|Adds a course to this course's corequesites list|
|AddSection()|Adds a section to this course.|
|Equals()|Compares a course to another object. Returns true if and only if the object is not null, if the object is an instance of Course, and if the Course Code is the same.|
|ToString()|Generates a displayable string for this course (IE: Acting 1(DRAM3001) 3 Credit(s))|

### Department
Department is an object to hold University Department information, and holds all courses offered by this department. It includes the following properties and methods:

|Property|Description|
|-|-|
|Name|Name of this department (IE: Drama Department)|
|ShortName|Short Name of this department used for course codes (IE: DRAM)|
|Color|Color of this department (Used by the front-end to render a course card)|
|Catalog|A <Stirng,String> Map of all courses offered by this department. The key for this map is a course's code number (IE 3011).|
|

|Method|Description|
|-|-|
|AddCourse()|Adds a course to this department's course catalog|
|GetSections()|Gets all sections from all courses in this department|
|Equals()|Compares a department to another object. Returns True if and only if the object is not null, is an instance of Department, and has the same Short Name.|
|ToString()|Generates a displayable string for this department (IE: Drama Department (3 Course(s)))

### Matricula
A Matricula is a list of sections and courses that will be enrolled on the day and time a student's turn is on. It includes the following properties and methods:

|Property|Description|
|-|-|
|Sections|List of sections in this Matricula|
|Courses|List of courses in this Matricula|
|TotalCredits|Total credits in this matricula|
|Period|Matricula Period for this matricula|
|ReadOnly|Flag to indicate whether or not this Matricula is read only|
|ID|ID of this matricula (Assigned by DBHandler)|

|Method|Description|
|-|-|
|AddSection()|Adds a section-course pair to this matricula|
|RemoveSection()|Removes a section (or Section-Course pair) from this matricula. RemoveSection wasn't renamed to RemoveSectionCoursePair() for compatibility reasons.|
|RemoveCourse()|Removes a Section-Course pair by finding the section tied to this course, and then using RemoveSection()'s Section-Course pair override|
|GetSectionsByDay()|Produces a list of 6 lists, where each list is one day of the week (minus Sunday). Each list only contains sections that occur on that day.|
|ToString()|Generates a displayable string for this matricula (2 Course(s) totalling 6 Credit(s) during FALL: 2020)|

### Matricula Period
Matricula Period ties a semester and year. It includes the following properties and methods:

|Property|Description|
|-|-|
|MatYear|Year of this matricula period|
|Semester|Semester of this matricula period (See Semester)|

|Static Method|Description|
|-|-|
|StringToSemester|Turns a string to a Semester|
|SemesterToString|Turns a Semester to a string|

|Method|Description|
|-|-|
|GetSemesterAsString()|Since semesters are stord as Semester, not String, this function executes SemesterToString on the Semester object stored to turn it into a string.|
|ToString()|Generates a displayable string for this Matricula Period (IE: FALL: 2020)|
|Equals()|Compares a Matricula Period to an object. Returns true if and only if the given object is a Matricula Period object, and if the semester and year are the same|

### Period
Period holds two integers representing two times for sections using ints to store military time. It includes the following properties and methods:

|Property|Description|
|-|-|
|Start|Start of this period as an integer with military time. (IE 3:00PM is stored as 1500)|
|End|End of this period stored the same way start is|

|Static Method|Description|
|-|-|
|intToStandardTime()|Turns an int to standard time (IE: 1500 -> 3:00 PM)|
|intToMilitaryTime()|Turns an int to Military time (IE: 1500 -> 15:00)|
|TimeToPeriod()|Turns a Time when creating sections (IE "12:00 PM - 12:30 PM") to a period. Can handle both Military and Standard time inputs|

|Method|Description|
|-|-|
|Conflict|Checks if this period and another conflict. Returns true if the other period starts or ends between this period's start or end.|
|ToStandardTimeString()|Turns this Period into a standard time string (IE 3:00PM-3:30PM)|
|ToMilitaryTimeString()|Turns this Period into a Military time string (IE 15:00-15:30)|
|ToString()|Delegates the task of generating a displayable string ToStandardTimeString()|
|Equals()|Compares this Period with an object. Returns true if and only if the object is not null, is an instance of Period, and has the same start and end time.|

### Section
Section holds the information of a course section. It includes the following properties and methods:

|Property|Description|
|-|-|
|SecNum|Section number of this Section|
|Day|Days this section meets.  A string comprised of the following characters "LMWJVSD". Each character represents a day (IE: L for Lunes (Monday), W for Wednesday)|
|Time|Time range this section will meet on. Setting this property also sets the Period of this section|
|Period|Period this section will meet on. Setting this property also sets time (in MilitaryTime)|
|Professor|Professor that will teach this Section of the course|
|Location|Classroom this section will meet in|
|CourseCode|CourseCode of this section's course|
|Credits|Credits of this section's course|
|Color|Color of this section's course|
|CourseName|Name of this section's course|
|Capacity|Maximum number of students this section can have|
|Population|Current number of students this section has|

|Method|Description|
|-|-|
|isFull()|Returns whether or not the population is greater or equal to capacity.|
|UpdateCourseInfo()|Updates all fields that are tied to this section's head course|
|increasePopulation()|Increments the population by 1|
|decreasePopulation()|Decrements the population by 1|
|Conflict()|Determines whether this section and a provided one conflict.|
|Equals()|Compares this section to another object. Returns true if and only if the object isn't null, is an instance of section, and if the course code and section number matches with this section's.|
|ToString()|Generates a displayable string for this section (IE: "DRAM3001-21 on MJ during 17:30-19:00")

### Semester
Semester is an Enum which holds the following possible values:

|Value|Description|
|-|-|
|SPRING|Spring Semester (Usually January to May)|
|SUMEMR1|Summer semester 1 (Usually June)|
|SUMMER2|Summer semester 2 (Usually July)|
|EXT_SUMMER|Extended Sumemr Semester (Usually June-July)|
|FALL|Fall Semester (Usually August to December)|

Semester has no methods

### Student
It includes the following properties and methods:

|Property|Description|
|-|-|
|department|Department this student belongs to|
|Name|Name of this student|
|Matriculas|<MatriculaPeriod,Matricula> Map of matriculas this student has.|
|Priodities|List of Priority Courses to *attempt* to enroll in the case that a matricula has sections that are not coursable.|
|CoursesTaken|List of courses a student has already taken.|
|Turn|Turn for this student (See Turn)|

|Method|Description|
|-|-|
|GetMatricula()|Accepts a Matricula Period to search the Matricula map and retrieve a specified matricula|
|AddSection()|Adds a Section E from Course F to the Matricula with Matricula Period M. Verifies the section can actually be added by checking Prereqs, Coreqs, Section Capacity, and that Section E is actually from Course F.<br><br>If a matricula does not exist for that period, it is created. If any of these conditions are not met, IllegalArguementException is thrown.|
|AddMatricula()|Adds the provided matricula to the map of matriculas for this student.|
|VerifyPrereqs()|Verifies that this student meets the prerequesites for a provided course|
|VerifyCoreqs()|Verifies that this student meets the corequesites for a provided course during the provided Matricula Period|
|AddCourseTaken()|Adds a course to the Coureses Taken list|
|AddPriority()|Adds a course to the list of priority courses|
|RemovePriority()|Removes course at specified index from the list of priority courses|
|SwapPriority()|Swaps the courses at specified indexes I and J in the list of Priority Courses|
|Turn()|Executes a Matricula Turn for the provided Period (And forces the turn to happen out of this students turn time if the optional arguement flag is set to true). It follows the following procedure:<br><br>    1. Starts a counter for sections removed.<br>    2. Removes sections that are full, counting them using the counter<br>    3. Removes sections that no longer meet prereqs, then coreqs, counting them using the counter<br>    4. While there are priority courses available, and the count is greater than 0, attempt to add any section from a priority course using AttemptEnrollCourse(). If attempt is successful, decrement count.<br>    5. Turn is done. Marks the matricula of the provided period as ReadOnly.|
|AttemptEnrollCourse()|Goes through each section of the course and attempt to enroll each of its sections using AttemptEnrollSection()|
|AttemptEnrollSection()|Attempts to enroll the section, and returns true if there was no IllegalArguementException when using AddSection().|
|Equals()|Compares this student to another object. True if and only if the object is not null, is an instance of student, and has the same student ID|
|ToString()|Generates a displayable string for this student (IE: Juan Del Pueblo (802-17-5555)|

### Turn
Turn pairs two LocalDateTime objects for a Matricula Turn. One constructor accepts a TurnText string from the Database, which is of the following format: <br>
`MM/DD/YYYY HH:mm-MM/DD/YYYY HH:mm` (IE `"12/25/2020 15:00-12/25/2020 15:30"`) <br><br>

Both this constructor, and the constructor that accepts to LocalDateTime objects check to make sure the Start is before the End. <br>
Turn includes the following properties and methods:

|Property|Description|
|-|-|
|Start|Start of the turn|
|End|End of the turn|

|Method|Description|
|-|-|
|isTime()|Returns true if the current time is between Start and End. As in, returns true if it is time.|
|ToString()|Generates a TurnText for this turn. Used to save it back to the database by DBHandler|
|Equals()|Compares this turn to another object. Returns true if and only if the object isn't null, the object is an instance of Turn, and if the generated TurnText of both this and the other turn ar the same.|

<hr>

## com.macademia.main.auth
Auth holds classes to handle authentication. In this case, there's only one.

### User
User pairs a username and password, and handles encryption of passwords. It includes the following properties and methods:

|Property|Description|
|-|-|
|Username|Username of this user|
|Password|Password of this user. Password is stored hashed.|

|Method|Description|
|-|-|
|CheckPassword()|Hashes the provided password, and checks if it matches with the stored hashed password|
|Equals()|Compares this User to another object. Returns true if and only if the object is not null, is an instance of User, and has the same Username.|
|ToString()|Returns the username|

<hr>

## com.macademia.main.db
DB holds classes related to Database Creation, and saving/loading objects to/from the database.

### Creator
Creator creates the Macademia Database. It includes the following methods:

|Static Method|Description|
|-|-|
|createNewMacademiaDatabase()|Creates a new Macademia Database at provided filename. If the file exists and provided overwrite flag is true, it deletes the file and creates a fresh Macademia Database straight from the Database Oven. Mmmmm... Tasty.|
|*DummyData()*|Deprecated function that used to directly input dummy data into the database. Its now very incomplete. Do not use it.|
|Main()|Overwrites and creates Macademia.db|

### DBHandler
This is the super big class that handles any and all connections to a Macademia Database. It also holds departments in memory, which in turn hold courses, which in turn hold sections. It includes the following methods:

|Method|Description|
|-|-|
|LoadEverything()|Loads every department, every course, and every section from the database|
|SaveEverything()|Saves every department to the database (and by extension every course and section)|
|GetUser()|Gets the user straight from the database. (Searches by Username)|
|GetStudents()|Prepares a list of all students in the database. Used for the Turn event|
|GetStudent()| Gets the student’s information from the database, along with:<br><br>Getting their department using GetDepartment()<br>Getting all of their matriculas using GetMatricula()<br>Getting all of their priority courses using GetCourse()<br>Getting all of their courses taken using GetCourse()<br><br>GetStudent() is usable either with a Student ID, or with a User object of the tied user.|
|GetMatricula()|Gets a Matricula’s information straight from the database, along with getting all of the sections held within it using GetSection()<br><br>**GetMatricula will automatically delete matriculas one semester or older.**|
|GetDepartments()|Gets a list of all departments, by first getting their information from the database, and then using GetDepartment().<br><br>This is a tad inefficient, because we access the database twice, however it allows the handler to kick in, rather than adding all the data manually|
|GetDepartment()|**DBHandler stores departments in memory once they’re loaded in a map of <String, Department>**, thus the first step is to check if the department isn’t already loaded.<br><br>If it isn’t its information is grabbed from the database. Its courses aren’t loaded until they are requested.|
|GetAllCourses()|Loads all courses in the database in a similar way to GetDepartments()|
|GetCourses()|Accepts a department as its parameter, and returns a list of all courses whose ID starts with the department’s short name by using GetCourse() <br>Similarly slightly inefficient as GetDepartments()|
|GetCourse()|Since DBHandler stores departments, it also stores courses. The first step is also to check if the course is already loaded, by checking its respective department.<br><br>If it isn’t the information is grabbed from the database, along with:<br><br>All of its prerequisites using GetCourse()<br>All of its corequisites again using GetCourse()|
|GetAllSections()|Loads all courses in the database in a similar way to GetAllCourses()|
|GetSections()|Loads all sections from a specified course in a similar way to GetCourses()|
|GetSection()|Since DBHandler stores courses, it also stores sections. If the section isn’t already loaded, its details are loaded from the database.|
|SaveUser()|Saves user info directly to the database|
|SaveStudent()|Saves a student’s info to the database, including:<br><br>Saving the tied user if it doesn’t exist<br>Saving all matriculas (Along with keeping track of their IDs as a comma separated list)<br>Saving all Priority Courses and Taken Courses by turning them into a comma separated list of Course IDs|
|SaveMatricula()|Saves a matricula to the database. If the matricula isn’t already saved, it should have an ID of -1 (the default value).<br><br>**DBHandler is in charge of assigning Matricula IDs**. It assigns a new random integer to any matricula with the default -1 value, and then inserts it. Otherwise, the matricula should already be in the database, and it just adds it.<br><br> **SaveMatricula throws IllegalArguementException if an attempt is made to save a matricula that is 1 semester or older**|
|SaveDepartment()|Saves department info directly to the database, and then saves all of the included courses by using SaveCourse()|
|SaveCourse()|Saves course info directly to the database, along with its prerequisites and corequisites as comma separated lists. Then saves all sections the course holds by using SaveSection()<br><br>**SaveCourse requires that the department the course belongs to is already saved in the database.** Otherwise it throws an Illegalargumentexception|
|SaveSection()|Saves section info directly to the database.<br><br>**SaveSection requires that the course the section belongs to is already saved in the database.** Otherwise it throws an Illegalargumentexception|
|DeleteUser()|Deletes a user from the database|
|DeleteStudent()|Deletes a student, their user, and their matriculas from the database|
|DeleteMatricula()|Deletes a matricula from the database if the ID is not -1|
|DeleteDepartment()|Removes a department from the department map, then deletes it from the database, along wiht every course in its catalog|
|DeleteCourse()|Removes a course from its respective department's course catalog, then deletes it from the database, along with every section in its list|
|DeleteSection()|Removes a section from its respective course's list, then deletes it from the database|
|UserExists()|Checks if the user exists by verifying that getUser() doesn't return null|
|StudentExists()|Checks if the Student exists by verifying that getStudent() doesn't return null|
|MatriculaExists()|Checks if the Matricula exists by verifying that getMatricula() doesn't return null|
|DepartmentExists()|Checks if the Department exists by verifying that getDepartment() doesn't return null|
|CourseExists()|Checks if the Course exists by verifying that getCourse() doesn't return null|
|SectionExists()|Checks if the Section exists by verifying that getSection() doesn't return null|

|Static Method|Description|
|-|-|
|ListOfCoursesToString()|Utility to turn a list of courses to a comma separated list of Course IDs|
|ListOfSectionsToString()|Utility to turn a list of sections toa comma separated list of section IDs|
|SemestersBetweenToday()|Utility that Calculates the semesters between what the current semester is, and the provided Matricula Period<br><br>Returns a positive number if there has been more than 0 semesters since the provided period.<br>Returns a negative nmber if the semester is in the future.<br>Returns 0 if the semester is the current one.|

<hr>

## com.macademia.main.test
The tests here are not JUnits. Rather, they are informal tests, or classes used to test.

### GeneralTest
General Test is the first test created to view how the original objects integrated with each other. It includes the following methods:

|Static Method|Description|
|-|-|
|Main()|Creates and links most types of objects, then prints the details of every Student using PrintStudentDetails()|
|PrintStudentDetails()|Prints a students Username, Department, and Matricula using respective PrintDetails functions|
|PrintMatriculaDetails()|Prints every section in the Matricula's list of sections.|
|PrintDepartmentDetails()|Prints Department ShortName, then prints out every course in its catalog using PrintCourseDetails()|
|PrintCourseDetails()|Prints the ToString output of a course, then prints all sections and prerequesites using respective PrintDetails Functions.|
|PrintSectionDetails()|Prints the ToString() output of a Section.|


### JsonTest
JSONTest includes a bunch of dummy data used to test the sending of JSON objects via SpringBoot. It's constructor was used to initialize and link all objects, and was used to save the dummy data to a database using DBHandler once it was completed.

<hr>
<hr>

**The following tests are also available under src.test.java**

## com.macademia.main.test
### DatabaseJUnit
The Database JUnit includes tests for all 6 datatypes stored in the database. After setting up and linking the objects on a @BeforeAll section, It follows a simple structure for each:
  1. Instantiate Object
  2. Save Object to Database
  3. Asser Object exists in Database.
  4. Load Object from Database
  5. Assert all properties were saved correctly.

### PeriodJUnit
PeriodJUnit is a JUnit to test the period class. It includes the following tests:

|Test|Description|
|-|-|
|CreatePeriodFromMilitaryTime()|Tests that a Period can be created from a Military Time String.|
|CreatePeriodFromStandardTime()|Tests that a Period can be created from a Standard Time String.|
|MilitaryToStandardTime()|Tests that a period can correctly convert stored Military Time back to a Standard Time String|
|ConflictYes|Tests that Period can correctly identify two periods that conflict|
|ConflictNo|Tests that Period can correctly identify two periods that don't conflict|

### TurnTest
TurnJUnit is a JUnit to test the Turn class. It includes the following Tests:

|Test|Description|
|-|-|
|TurnInstantiationTest()|Tests to make sure no exception occurs when creating a turn|
|TurnNowTest()|Tests to make sure Turn can correctly identify that it is time for a turn. (Will not work after Christmas 2030)|
|TurnNotNowTest()|Tests to make sure Turn can correctly identify that it is not time for a turn. (Doesn't work if you get a time machine and travel to January 2019)|
|TurnRetroalimentationTest()|Tests to make sure ToString() function of turn is correctly reparsable as TurnText.|

<hr>

Thank you to my wonderful current and former teammates that worked on this side of Macademia: Francis, Kevin, Giovani, Berm, and Josue

Without you guys none of this would've been possible. I wonder what we shall create next!<br>
-IGT

