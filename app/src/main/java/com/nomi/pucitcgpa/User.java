package com.nomi.pucitcgpa;

import java.util.ArrayList;

public class User extends android.app.Application {
    private static User user = null;
    private String user_name , user_email , user_rollNo , user_degree , user_batch , shift , campus ;
    private int semester , noOfSubjects;
    public User(){};

    public static User getInstance(){
        if (user == null){
            user = new User();
        }
        return user;

    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getNoOfSubjects() {
        return noOfSubjects;
    }

    public void setNoOfSubjects(int noOfSubjects) {
        this.noOfSubjects = noOfSubjects;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_rollNo() {
        return user_rollNo;
    }

    public void setUser_rollNo(String user_rollNo) {
        this.user_rollNo = user_rollNo;
    }

    public String getUser_degree() {
        return user_degree;
    }

    public void setUser_degree(String user_degree) {
        switch (user_degree){
            case "BIT":
                this.user_degree = "BS(IT)";
                break;
            case "BSE":
                this.user_degree = "BS(SE)";
                break;
            case "BCS":
                this.user_degree = "BS(CS)";
                break;
            case "MCS":
                this.user_degree = "MS(CS)";
                break;
            default :
                    break;

        }

    }

    public String getUser_batch() {
        return user_batch;
    }

    public void setUser_batch(String user_batch) {
        this.user_batch = user_batch;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        switch(shift){
            case "A":
                this.shift = "Afternoon";
                break;
            case "M":
                this.shift = "Morning";
                break;
        }
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        switch(campus) {
            case "5":
                this.campus = "New";
                break;
            case "0":
                this.campus = "Old";
                break;
        }
    }
}
