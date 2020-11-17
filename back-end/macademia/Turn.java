package macademia;

import java.util.Date;

public class Turn {
    private Date dayturn;
    private Period period;
    public Turn(int day, int month, int year, int begin, int end){
        this.dayturn=new Date(year-1900,month,day);
        this.period=new Period(begin,end);
    }
}
