package com.kingmesking.myapplication;

public class points {
    String eid;Integer points;
    public points(){

    }
    public points(String eid, Integer points){
        this.eid=eid;
        this.points=points;
    }

    public String getEid() {
        return eid;
    }

    public Integer getPoints() {
        return points;
    }
}
