package com.macademia.main;

/**
 * Period of a given Matricula
 * @author Gio
 *
 */
enum per {SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL;}

/**
 * 
 * @author Gio, Igtampe
 *
 */
public class MatriculaPeriod {

    private int matriculaYear;
    private per p;

    public MatriculaPeriod(int matriculaYear, String period) {
        this.matriculaYear = matriculaYear;
        this.p = StringToPeriod(period);
    }

    public void setMatYear(int n) {this.matriculaYear = n;}
    public void setSemester(per p) {this.p = p;}
    public int getMatyear() {return this.matriculaYear;}
    public per getSemester() {return this.p;}
    public String getSemesterAsString() {return PeriodToString(this.p);}
    
    /**
     * Turns a String into a Period
     * @param period
     * @return
     */
    public static per StringToPeriod(String period) {
        switch (period) {
        case "SPRING":
            return per.SPRING;
        case "SUMMER1":
            return per.SUMMER1;
        case "SUMMER2":
            return per.SUMMER2;
        case "EXT_SUMMER":
            return per.EXT_SUMMER;
        case "FALL":
            return per.FALL;
        default:
            throw new IllegalArgumentException("Could not decipher Period '" + period + "'");
        }
    }
    
    /**
     * Turns a period into a string.
     * @param Period
     * @return
     */
    public static String PeriodToString(per Period) {
        switch (Period) {
        case SPRING:
            return "SPRING";
        case SUMMER1:
            return "SUMMER1";
        case SUMMER2:
            return "SUMMER2";
        case EXT_SUMMER:
            return "EXT_SUMMER";
        case FALL:
            return "FALL";
        default:
            throw new IllegalArgumentException("Could not decipher Period '" + Period + "'");
        }
    	
    }
    
    /**
     * Returns a displayable Matricula Period String
     * @return (PERIOD): (YEAR)
     */    
    @Override
    public String toString() {return PeriodToString(p) + ": " + matriculaYear;}
    

}
