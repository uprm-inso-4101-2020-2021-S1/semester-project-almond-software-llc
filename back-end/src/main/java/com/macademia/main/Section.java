package com.macademia.main;

/**
 * Holds a Class Section in Macademia
 * 
 * @author Giovanni Garcia
 */
public class Section {
    // Variables
    private String secNum;
    private String day;
    private String time;
    private String courseCode;
    private int capacity;
    private int credits;

    // Constructor
    public Section(String secNum, String day, String time, Course course, int capacity) {
        this.secNum = secNum;
        this.day = day;
        this.time = time;
        courseCode = course.getDept() + course.getCode();
        this.credits = course.getCredits();
        this.capacity = capacity;

        // Link this Section's Course to this section
        course.addSection(this);
    }

    /**
     * Sets the section Number of this object
     * 
     * @return N/A
     */
    public void setSecNum(String s) {
        this.secNum = s;
    }

    /**
     * Sets the day of this object
     * 
     * @return N/A
     */
    public void setDay(String d) {
        this.day = d;
    }

    /**
     * Sets the time of this object
     * 
     * @return N/A
     */
    public void setTime(String t) {
        this.time = t;
    }

    public void setCourseCode(Course course) {
        this.courseCode = course.getDept() + course.getCode();
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getters

    /**
     * Gets the section number of this object
     * 
     * @return secNum
     */
    public String getSecNum() {
        return this.secNum;
    }

    /**
     * Gets the day of this object
     * 
     * @return day
     */
    public String getDay() {
        return this.day;
    }

    /**
     * Gets the time of this object
     * 
     * @return time
     */
    public String getTime() {
        return this.time;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public int getCredits() {
        return this.credits;
    }

    public int getCapacity() {
        return this.capacity;
    }

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