package com.hand.entity;

import java.util.Date;

public class Result  {
    private Integer filmid;
    private String filmname;
    private Date rentalDate;

    public Result(Integer filmid, String filmname, Date rentalDate) {
        this.filmid = filmid;
        this.filmname = filmname;
        this.rentalDate = rentalDate;
    }

    public Integer getFilmid() {
        return filmid;
    }

    public void setFilmid(Integer filmid) {
        this.filmid = filmid;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Override
    public String toString() {
        return "Result{" +
                "filmid=" + filmid +
                ", filmname='" + filmname + '\'' +
                ", rentalDate=" + rentalDate +
                '}';
    }
}
