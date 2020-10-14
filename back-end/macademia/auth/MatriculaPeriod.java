package macademia.auth;
enum per {
    SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL;
}
public class MatriculaPeriod {
    private int matriculaYear;
    private per p;

    public MatriculaPeriod(int matriculaYear, per p) {
        this.matriculaYear = matriculaYear;
        this.p = p;
    }

    public void setMatYear(int n) {this.matriculaYear = n;}
    public void setSemester(per p) {this.p = p;}

    public int getMatyear() {return this.matriculaYear;}
    public per getSemester() {return this.p;}

 


    
}
