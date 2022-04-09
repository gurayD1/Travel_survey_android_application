package com.group.project;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UsersDB {
    static private UsersDB usersDB = null;
    @SerializedName("users")
    private List<UserModel> myUsers = new ArrayList<>();


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

    public static Boolean checkUserExists(String email) {

        for (UserModel usr : UsersDB.getInstance().myUsers) {
            if (usr.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean validateUser(UserModel u) {

        for (UserModel usr : UsersDB.getInstance().myUsers) {
            if (usr.getEmail().equals(u.getEmail())) {

                if (usr.getPassword().equals(u.getPassword())) {
                    return true;
                }
            }
        }

        return false;
    }

}
