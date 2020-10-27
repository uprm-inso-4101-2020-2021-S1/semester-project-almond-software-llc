package com.macademia.main;

enum per {
    SPRING, SUMMER1, SUMMER2, EXT_SUMMER, FALL;
}

public class MatriculaPeriod {

    private int matriculaYear;
    private per p;

    public MatriculaPeriod(int matriculaYear, String period) {
        this.matriculaYear = matriculaYear;

        switch (period) {

            case "SPRING":
                this.p = per.SPRING;
                break;

            case "SUMMER1":
                this.p = per.SUMMER1;
                break;

            case "SUMMER2":
                this.p = per.SUMMER2;
                break;

            case "EXT_SUMMER":
                this.p = per.EXT_SUMMER;
                break;

            case "FALL":
                this.p = per.FALL;
                break;

            default:
                System.out.println("Period entered is not a valid category.");

        }

    }

    public void setMatYear(int n) {
        this.matriculaYear = n;
    }

    public void setSemester(per p) {
        this.p = p;
    }

    public int getMatyear() {
        return this.matriculaYear;
    }

    public per getSemester() {
        return this.p;
    }

}
