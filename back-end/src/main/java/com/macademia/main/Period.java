package com.macademia.main;

/**
 * Holds two integers representing two times for sections using ints to store military time.
 * 
 * IE, if a period is from 3:15 PM - 3:30 PM, it's stored as START 1515, END 1530.
 * 
 * Comments and more human understandable conflict function by IGTAMPE
 * @author Josue, Igtampe
 *
 */
public class Period {
    private int start;
    private int end;

    public int getStart() {return start;}
    public int getEnd() {return end;}

    public void setStart(int start) {this.start = start;}
    public void setEnd(int end) {this.start = end;}

    public Period(int start, int end) {
        this.start = start;
        this.end = end;
    }

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
    public String toMilitaryTimeString() {return intToStandardTime(start) + "-" + intToStandardTime(end);}

    private String intToStandardTime(int Time) {
    	boolean PM=false;
    	if(Time>=1200) {PM=true;}
    	if(Time>=1300) {Time-=1200;}
    	
    	String TimeString = intToMilitaryTime(Time);
    	
    	if(PM) {return TimeString+" PM";}
    	else   {return TimeString+" AM";}
    	
    }
    
    private String intToMilitaryTime(int Time) {
    	String TimeString = Time + "";
    	if(Time<1000) {return TimeString.substring(0,1) + ":" + TimeString.substring(1);}
    	else          {return TimeString.substring(0,2) + ":" + TimeString.substring(2);}
    }
    
    /**
     * Returns toStandardTimeString()
     */
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
    
	/**
	 * Checks if an object is equal to this period
	 * 
	 * @param obj
	 * @return True if and only if the object is not null, is an instance of
	 *         Period, and has the same start and end time.
	 */

    public boolean equals(Object obj) {
    	if (obj == null) {return false;}
		if (obj instanceof Period) {
			Period OtherPeriod = (Period) obj;
			return (OtherPeriod.start==start) && (OtherPeriod.end==end);
		}
		return false;
    }
    
}
