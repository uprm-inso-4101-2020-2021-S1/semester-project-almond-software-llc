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
        this.period=timetoPeriod(time);
        this.professor = professor;
        this.location = Location;
        this.population=Population;
        this.capacity = capacity;
        this.population = 0;
        
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
   
  public Period getPeriod() {return period;}

    /* I have no idea what any of this is and if it works so let's simplify the heck out of this.
  	String[] per= time.split("-");
      char temp = per[0].charAt(per[0].indexOf('M')-1);
      String[] re=per[0].split(":");
      per[0]=re[0]+re[1].substring(0,re[1].indexOf('M')-1);
      int start=Integer.parseInt(per[0]);
      if(temp=='P')start+=1200;
      temp = per[1].charAt(per[1].indexOf('M')-1);
      re=per[1].split(":");
      per[1]=re[0]+re[1].substring(0,re[1].indexOf('M')-1);
      int end=Integer.parseInt(per[1]);
      if(temp=='P')end+=1200;
      return new Period(start,end);
  */
    
    
    /**
     * Turns a time into a period
     * @param time
     * @return
     */
    public static Period timetoPeriod(String time) {
    	time=time.replace(" ", ""); //Remove any potential spaces
    	String[] TwoTimes = time.split("-"); //split
    	if(TwoTimes.length!=2) {throw new IllegalArgumentException("Time not formatted properly");} //Make sure there are two times.
    	return new Period(TimeToInt(TwoTimes[0]), TimeToInt(TwoTimes[1]));
    }
      
    private static int TimeToInt(String Time) {
    	boolean PM=false; //Flag to save if the time ended with PM
    	Time=Time.toUpperCase(); //Flag to handle lowercase AMs and PMs
    	if(Time.endsWith("AM")) {Time=Time.replace("AM","");} //Remove AM if it is present.
    	else if(Time.endsWith("PM")) {Time=Time.replace("PM", ""); PM=true;} //Remove PM if it is present, and mark the PM flag.
    	
    	//Now remove the :
    	Time=Time.replace(":", "");
    	
    	//Now we should have a number.
    	int TimeAsInt;
    	try {TimeAsInt=Integer.parseInt(Time);} 
    	catch (NumberFormatException e) {throw new IllegalArgumentException("Impropperly formatted time. Could not convert " + Time + "to an int");}
    	
    	//Lastly, if PM is true, add 1200
    	if(PM && TimeAsInt>=1300) {TimeAsInt+=1200;}
    	return TimeAsInt;
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
     * @param Time
     */
    public void setTime(String t) {
    	this.time = t;
    	this.period=timetoPeriod(t);
	}

    /**
     * Updates all course information in this section with the provided course.
     * @param course
     */
    public void UpdateCourseInfo(Course course) {
    	this.courseCode = course.getDept() + course.getCode();
        this.courseName=course.getName();
        this.Color=course.getColor();
        this.credits=course.getCredits();
	}
    
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public void increasePopulation() {this.population++;}
    public void decreasePopulation() {this.population--;}
    public void setPopulation(int Population) {this.population=Population;} //This is here for the Database handler

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
    public String getLocation() {return this.location;}

    /**
     * Returns the course code IE "ICOM4501"
     * @return
     */
    public String getCourseCode() {return this.courseCode;}

    public int getCredits() {return this.credits;}
    public int getCapacity() {return this.capacity;}
    public int getPopulation() {return this.population;}
    
    public String getColor() {return this.Color;}
    public String getCourseName() {return this.courseName;}
    
    /**
     * Returns a displayable string for this section
     * 
     * @return DeptShortNameCourseCode-SectionNum on Days during Time (IE
     *         "DRAM3001-21 on Tuesday, Thursday during 5:30-7:00")
     */

    public String toString() {
        return getCourseCode() + "-" + getSecNum() + " on " + getDay() + " during " + getTime();
    }

    /**
     *Check if there is conflict in the sections in the matricula
     *@author Josue
     *@param sec Section to check if conflicts
     *@return if this section and the given section conflict
     */
   public boolean Conflict(Section sec){
       for (int i = 0; i < sec.day.length(); i++)
           for(int j = 0; j < this.day.length(); j++)
               if(this.day.charAt(j)==sec.day.charAt(i))
                   return this.period.Conflict(sec.period);
       return false;
   }
    
}