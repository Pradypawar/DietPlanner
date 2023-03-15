package com.example.dietplanner.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class UserInfoModel implements Serializable {
    private int id;
    private String name;
    private double weightInKg;
    private double heightInFt;
    private int age;
    private int activityLevel;
    private String gender;
    private int caloriesToMaintain;



    public UserInfoModel (String name, double weightInKg, double heightInFt, int age, int activityLevel, String gender) {
        this.name = name;
        this.weightInKg = weightInKg;
        this.heightInFt = heightInFt;
        this.age = age;
        this.activityLevel = activityLevel;
        this.gender = gender;
    }

    public UserInfoModel () {

    }

    public int getCaloriesToMaintain () {
        return caloriesToMaintain;
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

    public void setCaloriesToMaintain (int caloriesToMaintain) {
        this.caloriesToMaintain = caloriesToMaintain;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public int getActivityLevel () {
        return activityLevel;
    }

    public void setActivityLevel (int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }


}
