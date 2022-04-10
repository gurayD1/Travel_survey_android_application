package com.group.project;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsersDB implements Serializable {
    static private UsersDB usersDB = null;
    @SerializedName("users")
    private List<UserModel> myUsers = new ArrayList<>();

    static private File filePath = null;

    public static void setFilePath(File f) {
        filePath = f;

    }

    public static File getFilePath() {
        return filePath;

    }

    public void addUser(UserModel u) {
        myUsers.add(u);

    }

    public static List<UserModel> getAllUsers() {
        return UsersDB.getInstance().myUsers;

    }

    static public UsersDB getInstance() {
        if (usersDB == null) {
            usersDB = new UsersDB();
        }
        return usersDB;
    }

    public static void setInstance(UsersDB usr) {
        if (usr != null) {
            usersDB = usr;
        }
    }

    public static Boolean checkUserExists(String userEmail) {

        for (UserModel usr : UsersDB.getInstance().myUsers) {
            if (usr.getEmail().equals(userEmail)) {
                return true;
            }
        }
        return false;
    }


    public static UserModel sendExistUser(String userEmail) {
        UserModel userModel = null;
        for (UserModel usr : UsersDB.getInstance().myUsers) {
            if (usr.getEmail().equals(userEmail)) {
                return usr;
            }
        }
        return userModel;
    }

    public static UserModel resetPassword(UserModel u) {
        SaveData ss = new SaveData();
        for (UserModel usr : ss.loadUsersFromFile().getAllUsers()) {

            if (usr.getEmail().equals(u.getEmail())) {

                if (usr.getAccessCode().equals(u.getAccessCode())) {
                    return usr;
                }
            }
        }

        return null;
    }

    public static void resetUserPassword(UserModel u, String newpassword) {
        SaveData ss = new SaveData();
        for (UserModel usr : ss.loadUsersFromFile().getAllUsers()) {

            if (usr.getEmail().equals(u.getEmail())) {

                usr.setPassword(newpassword);

            }
        }
    }

    public static Boolean validateUser(UserModel u) {
        SaveData ss = new SaveData();
        for (UserModel usr : ss.loadUsersFromFile().getAllUsers()) {

            if (usr.getEmail().equals(u.getEmail())) {

                if (usr.getPassword().equals(u.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
