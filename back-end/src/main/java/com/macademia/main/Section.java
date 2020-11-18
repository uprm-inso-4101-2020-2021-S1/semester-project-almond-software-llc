package com.macademia.main;

/**
 * Holds a Class Section in Macademia
 * 
 * @author Giovanni Garcia
 */

enum Days {
    MTWJ, MWF, TJ, S, MTWJF, MWJF, MTWF;
}

public class Section {
    // Variables
    private String secNum;
    private String day;
    private String time;
    private Period period;
    private String professor;
    private String location;
    private String courseCode;
    private String courseName;
    private String Color;
    private int capacity;
    private int population;
    private int credits;

    public Section(String secNum, String day, String time, String professor, String Location, Course course, int Population, int capacity) {
        this.secNum = secNum;
        this.day = day;
        this.time = time;
        this.period = Period.timetoPeriod(time);
        this.professor = professor;
        this.location = Location;
        this.population = Population;
        this.capacity = capacity;
        this.population = 0;
        this.courseName = course.getName();

        // Link this Section's Course to this section
        course.addSection(this);

        //Grab the color and course name from the course
        UpdateCourseInfo(course);
    }

    public boolean isFull() {
        if (this.population == this.capacity) return true;
        return false;
    }
  
    public void setPeriod(Period period) {
    	this.period = period;
    	//also update time
    	this.time=period.toMilitaryTimeString();
	}
  
    /**
     * Gets the period of this matricula. 
     * @return
     */
    public Period getPeriod() {return period;}

  /**
     * Sets the section Number of this object
     */
    public void setSecNum(String s) {this.secNum = s;}

    /**
     * Sets the day of this object
     */
    public void setDay(String d) {this.day = d;}

    /**
     * Sets the time of this object
     * @param Time
     */
    public void setTime(String t) {
        this.time = t;
        this.period = Period.timetoPeriod(t);
    }

    /**
     * Updates all course information in this section with the provided course.
     * @param course
     */
    public void UpdateCourseInfo(Course course) {
        this.courseCode = course.getDept() + course.getCode();
        this.courseName = course.getName();
        this.Color = course.getColor();
        this.credits = course.getCredits();
    }

    /**
     * Gets the capacity of this section
     * @param capacity
     */
    public void setCapacity(int capacity) {this.capacity = capacity;}

    /**
     * Increments the population of this selection
     */
    public void increasePopulation() {this.population++;}

    /**
     * Decrements the population of this section
     */
    public void decreasePopulation() {this.population--;}

    /**
     * Sets the population of this section. Mostly here for the DBHandler
     * @param Population
     */
    public void setPopulation(int Population) {this.population = Population;}

    // Getters

    /**
     * Gets the section number of this object
     * @return secNum
     */
    public String getSecNum() {return this.secNum;}

    /**
     * Gets the day of this object
     * @return day
     */
    public String getDay() {return this.day;}

    /**
     * Gets the time of this object
     * @return time
     */
    public String getTime() {return this.time;}

    /**
     * Gets the professor of this section
     * @return Prof
     */
    public String getProfessor() {return this.professor;}

    /**
     * Gets the location of this section
     * @return
     */
    public String getLocation() {return this.location;}

    /**
     * Returns the course code IE "ICOM4501"
     * @return
     */
    public String getCourseCode() {return this.courseCode;}

    /**
     * Gets the credits for this section
     * @return
     */
    public int getCredits() {return this.credits;}

    /**
     * Gets the capacity of this section
     * @return
     */
    public int getCapacity() {return this.capacity;}

    /**
     * gets the population of this section
     * @return
     */
    public int getPopulation() {return this.population;}

    /**
     * Gets the color of this section. Used by the Front-End
     * @return
     */
    public String getColor() {return this.Color;}

    /**
     * Gets the coure name for this section
     * @return
     */
    public String getCourseName() {return this.courseName;}

    /**
     * Returns a displayable string for this section
     * @return DeptShortNameCourseCode-SectionNum on Days during Time (IE
     *         "DRAM3001-21 on Tuesday, Thursday during 5:30-7:00")
     */

    public String toString() {return getCourseCode() + "-" + getSecNum() + " on " + getDay() + " during " + getTime();}

    /**
     * Function to check if this section conflits with a given section.
     * 
     * @author Josue
     * @param sec Section to check if conflicts
     * @return if this section and the given section conflict
     */
    public boolean Conflict(Section sec) {
        for (int i = 0; i < sec.day.length(); i++)
            for (int j = 0; j < this.day.length(); j++)
                if (this.day.charAt(j) == sec.day.charAt(i))
                    return this.period.Conflict(sec.period);
        return false;
    }

}