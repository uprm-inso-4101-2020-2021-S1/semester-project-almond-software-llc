package macademia;

public class Period {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.start = end;
    }

    public Period(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean Conflict(Period sec){
        return !(this.end <sec.start||this.start>sec.end);
    }
    public boolean inPeriod(int time){ return ((this.end >time)&&(this.start<time)); }
}
