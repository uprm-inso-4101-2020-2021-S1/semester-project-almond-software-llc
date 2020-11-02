package macademia;

/**
 * Holds a Class Section in Macademia
 * @author Giovanni Garcia
 * Period additions
 * @author Josue Ramirez
 */
public class Section {
    //Variables
    private String secNum;
    private String day;
    private String time;
    private Course course;
    private Period period;

    //Constructor
    public Section(String secNum, String day, String time, Course course){
        this.secNum = secNum;
        this.day = day;
        this.time = time;
        this.course = course;
        
        //Link this Section's Course to this section
        course.addSection(this);

        this.period= timetoPeriod(time);
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    private Period timetoPeriod(String time) {
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

   /**
	 * Returns a displayable string for this section
	 * @return DeptShortNameCourseCode-SectionNum on Days during Time (IE "DRAM3001-21 on Tuesday, Thursday during 5:30-7:00")
    */
   public String toString() {return getCourse().getDept().getShortName() + getCourse().getCode() + "-" + getSecNum() + " on " + getDay() + " during " + getTime();}
    /*
    Check if there is conflict in the sections in the matricula
     */
   public boolean Conflict(Section sec){
       for (int i = 0; i < sec.day.length(); i++)
           for(int j = 0; j < this.day.length(); j++)
               if(this.day.charAt(j)==sec.day.charAt(i))
                   return this.period.Conflict(sec.period);
       return false;
   }

}