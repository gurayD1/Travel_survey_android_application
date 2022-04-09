package com.group.project;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {
    @SerializedName("Email")
    private String Email;
    @SerializedName("password")
    private String password;
    @SerializedName("fullName")
    private String fullName;


    public String getEmail() {
        return Email;
    }

    public String getFullName(){return fullName;}

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setFullName(String fullName){this.fullName = fullName;}

    public void setPassword(String p) {
        this.password = p;
    }

}
