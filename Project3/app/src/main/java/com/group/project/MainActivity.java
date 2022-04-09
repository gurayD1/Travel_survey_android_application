package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    saveData saveDataInstance = new saveData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFilePath();
    }

    public void createFilePath(){

        UsersDB.setFilePath(this.getFilesDir());

        Log.d("file name", this.getFilesDir().toString());
    }

    // Start button clicked
    public void startButtonClicked(View view) {

        Intent intent = new Intent(this, LogInPageActivity.class);

     //   Gson gson = new Gson();

        saveData saveDataInstance = new saveData();
        UsersDB usersDB =  UsersDB.getInstance();
        ResultsDB resultsDB = ResultsDB.getInstance();

//        //**
//        usersDB =  gson.fromJson(saveDataInstance.loadUsersFromFile(), UsersDB.class);
//        resultsDB =  gson.fromJson(saveDataInstance.loadResultsFromFile(), ResultsDB.class);
//        //--

        usersDB = saveDataInstance.loadUsersFromFile_new();
        resultsDB =saveDataInstance.loadResultsFromFile_new();


        UsersDB.setInstance(usersDB);
        ResultsDB.setInstance(resultsDB);



        ResultModel result = new ResultModel();
       intent.putExtra("Result", result);
        startActivity(intent);
    }





}