package com.example.dietplanner.models;

import java.io.Serializable;

public class UserInfoModel implements Serializable {
    private int id;
    private String name;
    private double weightInKg;
    private double heightInFt;
    private int age;
    private String activityLevel;
    private String gender;


    public UserInfoModel (String name, double weightInKg, double heightInFt, int age, String activityLevel, String gender) {
        this.name = name;
        this.weightInKg = weightInKg;
        this.heightInFt = heightInFt;
        this.age = age;
        this.activityLevel = activityLevel;
        this.gender = gender;
    }

    public UserInfoModel () {

    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public double getWeightInKg () {
        return weightInKg;
    }

    public void setWeightInKg (double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public double getHeightInFt () {
        return heightInFt;
    }

    public void setHeightInFt (double heightInFt) {
        this.heightInFt = heightInFt;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getActivityLevel () {
        return activityLevel;
    }

    public void setActivityLevel (String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }
}
