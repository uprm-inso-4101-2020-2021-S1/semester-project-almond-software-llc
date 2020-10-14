package macademia;

/**
 * Holds a Class Section in Macademia
 * @author Giovanni Garcia
 */
public class Section {
    enum Days {
        MTWJ, MWF, TJ, S, MTWJF, MWJF, MTWF;
    }
    //Variables
    private String secNum;
    private String time;
    private Course course;
    private int maxCapacity;
    private int population;
    private String professor;
    private String building;
    private String room;
    Days day ;

    //Constructor
    public Section(String secNum, Days day, String time, Course course, int maxCapacity, String professor, String building, String room){
        this.day = day;
        this.secNum = secNum;
        this.time = time;
        this.course = course;
        this.maxCapacity = maxCapacity;
        this.professor = professor;
        this.building = building;
        this.room = room;
        
        //Link this Section's Course to this section
        course.addSection(this);
        
    }



    /**
     * Sets the section Number of this object
     * @return N/A
     */
    public void setSecNum(String s) { this.secNum = s;}

    /**
     * Sets the time of this object
     * @return N/A
     */
    public void setTime(String t) {this.time = t;}

    public void setPopulation (int n) {this.population = n;}

    public void setMaxCapacity(int n) {this.maxCapacity = n;}

    public void setProfessor(String s) {this.professor = s;}

    public void setBuilding(String s) {this.building = s;}

    public void setRoom(String s) {this.room = s;}

    public void setDay(Days day) {this.day = day;}

    //Getters

    /**
     * Gets the section number of this object
     * @return secNum
     */
    public String getSecNum() {return this.secNum;}
    
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

   public int getPopulation() {return this.population;}

   public int getMaxCapacity() {return this.maxCapacity;}

   public String getProfessor() {return this.professor;}

   public String getBuilding() {return this.building;}

   public String getRoom() {return this.room;}

   public Days getDay() {return this.day;}

   

    //
    public boolean isFull() {
        if (this.population >= this.maxCapacity) {
            return true;
        }
        return false;
    }
   /**
	 * Returns a displayable string for this section
	 * @return DeptShortNameCourseCode-SectionNum on Days during Time (IE "DRAM3001-21 on Tuesday, Thursday during 5:30-7:00")
    */
   public String toString() {return getCourse().getDept().getShortName() + getCourse().getCode() + "-" + getSecNum() + " on " + getDay() + " during " + getTime();}
    

}