package macademia;

/**
 * Holds a Class Section in Macademia
 * @author Giovanni Garcia
 */
public class Section {
    //Variables
    private String secNum;
    private String day;
    private String time;
    private Course course;

    //Constructor
    public Section(String secNum, String day, String time, Course course){
        this.secNum = secNum;
        this.day = day;
        this.time = time;
        this.course = course;
    }

    /**
     * Sets the section Number of this object
     * @return N/A
     */
    public void setSecNum(String s) { this.secNum = s;}

    /**
     * Sets the day of this object
     * @return N/A
     */
    public void setDay(String d) {this.day = d;}

    /**
     * Sets the time of this object
     * @return N/A
     */
    public void setTime(String t) {this.time = t;}

    //Getters

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
     * Gets the parent object of this object
     * @return class
     */
   public Course getCourse(){return this.course;} 

    

}