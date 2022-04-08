package com.group.project;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {
    @SerializedName("userName")
    private String userName;
    @SerializedName("password")
    private String password;


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setPassword(String p) {
        this.password = p;
    }

}
