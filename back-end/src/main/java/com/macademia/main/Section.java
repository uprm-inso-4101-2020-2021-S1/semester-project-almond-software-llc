package com.macademia.main;

/**
 * Holds a Class Section in Macademia
 * 
 * @author Giovanni Garcia
 */

enum Days {MTWJ, MWF, TJ, S, MTWJF, MWJF, MTWF;}

public class Section {
    // Variables
    private String secNum;
    private String day;
    private String time;
    private String professor;
    private String building;
    private String room;
    private String courseCode;
    private int capacity;
    private int population;
    private int credits;

    // Constructor
    public Section(String secNum, String day, String time, String professor, String building, String room, Course course, int capacity) {
        this.secNum = secNum;
        this.day = day;
        this.time = time;
        this.professor = professor;
        this.building = building;
        this.room = room;
        courseCode = course.getDept() + course.getCode();
        this.credits = course.getCredits();
        this.capacity = capacity;
        this.population = 0;
        
        // Link this Section's Course to this section
        course.addSection(this);
    }

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
     */
    public void setTime(String t) {this.time = t;}

    public void setCourseCode(Course course) {this.courseCode = course.getDept() + course.getCode();}
    public void setCredits(int credits) {this.credits = credits;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public void increasePopulation() {this.population++;}
    public void decreasePopulation() {this.population--;}

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
    public String getProfessor() {return this.professor;}
    public String getBuilding() {return this.building;}
    public String getRoom() {return this.room;}

    /**
     * Returns the course code IE "ICOM4501"
     * @return
     */
    public String getCourseCode() {return this.courseCode;}

    public int getCredits() {return this.credits;}
    public int getCapacity() {return this.capacity;}
    public int getPopulation() {return this.population;}

    /**
     * Returns a displayable string for this section
     * 
     * @return DeptShortNameCourseCode-SectionNum on Days during Time (IE
     *         "DRAM3001-21 on Tuesday, Thursday during 5:30-7:00")
     */

    public String toString() {
        return getCourseCode() + "-" + getSecNum() + " on " + getDay() + " during " + getTime();
    }

}