package com.hand.entity;

import java.io.Serializable;

public class City implements Serializable {
    private Integer cid;
    private String cityname;

    public City(int cid, String cityname) {
        this.cid = cid;
        this.cityname = cityname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cityname='" + cityname + '\'' +
                '}';
    }
}
