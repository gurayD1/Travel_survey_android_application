package com.group.project;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class saveData extends AppCompatActivity {
    Gson gson = new Gson();
    String text = "";


    public String loadUsersFromFile() {
        Gson gson = new Gson();
        String text = "";

//Make sure to use a try-catch statement to catch any errors
        try {
            //Make your FilePath and File

            File yourFile = new File(Environment.getExternalStorageDirectory(), "users.txt");

            //Make an InputStream with your File in the constructor
            InputStream inputStream = new FileInputStream(yourFile);
            StringBuilder stringBuilder = new StringBuilder();
            //Check to see if your inputStream is null
            //If it isn't use the inputStream to make a InputStreamReader
            //Use that to make a BufferedReader
            //Also create an empty String
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                //Use a while loop to append the lines from the Buffered reader
                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                //Close your InputStream and save stringBuilder as a String
                inputStream.close();
                text = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            //Log your error with Log.e
        } catch (IOException e) {
            //Log your error with Log.e
        }
//Use Gson to recreate your Object from the text String
        return text;

    }

    public void saveUsersToFile(String data) {
        ObjectOutput out;
        try {
            File outFile = new File(Environment.getExternalStorageDirectory(), "users.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);

            fileOutputStream.write(data.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void saveResultsToFile(String data) {

        ObjectOutput out;
        try {
            File outFile = new File(Environment.getExternalStorageDirectory(), "results.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);

            fileOutputStream.write(data.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String loadResultsFromFile() {

        Gson gson = new Gson();
        String text = "";

//Make sure to use a try-catch statement to catch any errors
        try {
            //Make your FilePath and File

            File yourFile = new File(Environment.getExternalStorageDirectory(), "results.txt");

            //Make an InputStream with your File in the constructor
            InputStream inputStream = new FileInputStream(yourFile);
            StringBuilder stringBuilder = new StringBuilder();
            //Check to see if your inputStream is null
            //If it isn't use the inputStream to make a InputStreamReader
            //Use that to make a BufferedReader
            //Also create an empty String
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                //Use a while loop to append the lines from the Buffered reader
                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                //Close your InputStream and save stringBuilder as a String
                inputStream.close();
                text = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            //Log your error with Log.e
        } catch (IOException e) {
            //Log your error with Log.e
        }
//Use Gson to recreate your Object from the text String
        return text;

    }


}
