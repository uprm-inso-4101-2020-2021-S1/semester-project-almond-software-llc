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
}
