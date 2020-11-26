package com.kingmesking.myapplication;

public class member {
    private String Email,password, Points;
    Long take;
    public member(){

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public Long getTake() {
        return take;
    }

    public void setTake(Long take) {
        this.take = take;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }
}
