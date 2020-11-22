package com.macademia.main;

/**
 * Holds two integers representing two times for sections using ints to store military time.<br><br>
 * IE, if a period is from 3:15 PM - 3:30 PM, it's stored as START 1515, END 1530.<br><br>
 * Comments and more human understandable conflict function by IGTAMPE
 * 
 * @author Josue, Igtampe
 *
 */
public class Period {
	
	//-[Fields]-------------------------------------------------------------------------
    private int start;
    private int end;
    private int startMinutes;
    private int endMinutes;

    //-[Raw Getters]------------------------------------------------------------------------
    public int getStart() {return start;}
    public int getEnd() {return end;}
    public int getStartMinutes() {return startMinutes;}
    public int getEndMinutes() {return endMinutes;}

    //-[Raw Setters]------------------------------------------------------------------------
    public void setStart(int start) {
    	this.start = start;
    	this.startMinutes=timeToMinutes(start);
    }
    
    public void setEnd(int end) {
    	this.end = end;
    	this.endMinutes=timeToMinutes(end);
    }

    //-[Constructor]------------------------------------------------------------------------
    public Period(int start, int end) {
        setStart(start);
        setEnd(end);
        if(end<start) {throw new IllegalArgumentException("Period cannot start after it ends, or end before it starts");} //Verify this makes sense
    }
    
    //-[Static Functions]------------------------------------------------------------------------
    
    /**
     * Turns a Period Stored Time to Standard Time
     * 
     * @param Time
     * @return
     */
    public static String intToStandardTime(int Time) {
    	boolean PM=false;
    	if(Time>=1200) {PM=true;} //If it's greater than 1200, we're in the PM
    	if(Time>=1300) {Time-=1200;} //If it's greater than 1300 (IE 1:00 PM), subtract 1200
    	
    	String TimeString = intToMilitaryTime(Time); //Use IntToMilitaryTime to convert it into a time
    	
    	if(PM) {return TimeString+" PM";} //Append AM or PM accordingly
    	else   {return TimeString+" AM";}
    	
    }

    /**
     * Turns a period stored time to Military Time
     * @param Time
     * @return
     */
    public static String intToMilitaryTime(int Time) {
    	String TimeString = Time + ""; //Use its size to determine the correct position of the :
    	if(Time<1000) {return TimeString.substring(0,1) + ":" + TimeString.substring(1);}
    	else          {return TimeString.substring(0,2) + ":" + TimeString.substring(2);}
    }
    
    /**
     * Turns a time into a period
     * @param time
     * @return
     */
    public static Period timetoPeriod(String time) {
        time = time.replace(" ", ""); // Remove any potential spaces
        String[] TwoTimes = time.split("-"); // split
        if (TwoTimes.length != 2) {
            throw new IllegalArgumentException("Time not formatted properly");
        } // Make sure there are two times.
        return new Period(TimeToInt(TwoTimes[0]), TimeToInt(TwoTimes[1]));
    }

    /**
     * Turns a time to a Period Int (IE 12:00 PM --> 1200)
     * @param Time
     * @return
     */
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
    	if(PM && TimeAsInt<1200) {TimeAsInt+=1200;}
    	return TimeAsInt;
    }

    /**
     * Turns a TimeInt to the minutes
     * @param Time
     * @return
     */
    public static int timeToMinutes(int Time) {
    	//Use intToMilitaryTime to split hours and minutes
    	String[] TimeasString=intToMilitaryTime(Time).split(":");
    	//Add Minutes to 60*Hours
    	int[] HoursAndMinutes = {Integer.parseInt(TimeasString[0]),Integer.parseInt(TimeasString[1])};
    	return (HoursAndMinutes[0]*60)+HoursAndMinutes[1];
    }
    
    
    //-[Functions]------------------------------------------------------------------------
    
    /**
     * Checks if this period, and another period conflict.
     * @param per Period to compare
     * @return TRUE if the other period starts or ends between this period's start or end.
     */
    public boolean Conflict(Period per){return (this.start<per.start && per.start<this.end)||(this.start<per.end && per.end<this.end);}
    
    /**
     * Turns this preiod into a standard time string
     * @return IE 3:00 PM - 3:30 PM
     */
    public String toStandardTimeString() {return intToStandardTime(start) + "-" + intToStandardTime(end);}
    
    /**
     * Turns this period into a Military Time String
     * @return IE 15:00 - 15:30
     */
    public String toMilitaryTimeString() {return intToMilitaryTime(start) + "-" + intToMilitaryTime(end);}
    
    /**
     * Returns toStandardTimeString()
     */
    public String toString() {
        return toStandardTimeString();
    }

    /**
     * Checks if an object is equal to this period
     * 
     * @param obj
     * @return True if and only if the object is not null, is an instance of Period,
     *         and has the same start and end time.
     */

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Period) {
            Period OtherPeriod = (Period) obj;
            return (OtherPeriod.start == start) && (OtherPeriod.end == end);
        }
        return false;
    }

}
