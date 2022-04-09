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




    public static void setFilePath(File f){
        filePath = f;

    }

    public static File getFilePath(){
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

    public static Boolean checkUserExists(String username) {

        for (UserModel usr : UsersDB.getInstance().myUsers) {
            if (usr.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean validateUser(UserModel u) {
        saveData ss = new saveData();
       // for (UserModel usr : UsersDB.getAllUsers()) {
        for (UserModel usr : ss.loadUsersFromFile_new().getAllUsers()) {

            if (usr.getUserName().equals(u.getUserName())) {

                if (usr.getPassword().equals(u.getPassword())) {
                    return true;
                }
            }
        }

        return false;
    }

}
