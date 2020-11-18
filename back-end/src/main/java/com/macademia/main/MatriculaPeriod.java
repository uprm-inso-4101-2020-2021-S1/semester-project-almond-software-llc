package com.macademia.main;

/**
 * 
 * @author Gio, Igtampe
 */
public class MatriculaPeriod {

    private int matriculaYear;
    private Semester p;

    public MatriculaPeriod(int matriculaYear, String period) {
        this.matriculaYear = matriculaYear;
        this.p = StringToSemester(period);
    }

    public void setMatYear(int n) {this.matriculaYear = n;}
    public void setSemester(Semester p) {this.p = p;}
    public int getMatyear() {return this.matriculaYear;}
    public Semester getSemester() {return this.p;}
    public String getSemesterAsString() {return SemesterToString(this.p);}
    
    /**
     * Turns a String into a Period
     * @param period
     * @return
     */
    public static Semester StringToSemester(String period) {
        switch (period) {
        case "SPRING":
            return Semester.SPRING;
        case "SUMMER1":
            return Semester.SUMMER1;
        case "SUMMER2":
            return Semester.SUMMER2;
        case "EXT_SUMMER":
            return Semester.EXT_SUMMER;
        case "FALL":
            return Semester.FALL;
        default:
            throw new IllegalArgumentException("Could not decipher Period '" + period + "'");
        }
    }
    
    /**
     * Turns a period into a string.
     * @param Period
     * @return
     */
    public static String SemesterToString(Semester Period) {
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
    public String toString() {return SemesterToString(p) + ": " + matriculaYear;}

    /**
     * @Return true if and only if the given object is a Matricula Period object, and if the semester and year are the same
     */
    @Override
    public boolean equals(Object obj) {
		if (obj == null) {return false;}
		if (obj instanceof MatriculaPeriod) {
			MatriculaPeriod OtherPeriod = (MatriculaPeriod) obj;
			return OtherPeriod.matriculaYear == matriculaYear && OtherPeriod.p==p;
		}
		return false;
    }
    

}
