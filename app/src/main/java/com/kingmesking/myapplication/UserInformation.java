package com.kingmesking.myapplication;

public class UserInformation {
    private String email;
    private String password;
    private String points;

    public UserInformation(){

    }

    public String getemail() {
        return email;
    }

    public void setemail(String name) {
        this.email = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String email) {
        this.password = email;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
