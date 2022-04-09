package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class LogInPageActivity extends AppCompatActivity {
    EditText loginUserName;
    EditText loginPassword;

    EditText sUserName;
    EditText sPassword;
    EditText sCPassword;

    saveData saveDataInstance = new saveData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        loginUserName = (EditText) findViewById(R.id.loginUserName);
        loginPassword = (EditText) findViewById(R.id.loginPassword);

        sUserName = (EditText) findViewById(R.id.sUserName);
        sPassword = (EditText) findViewById(R.id.sPassword);
        sCPassword = (EditText) findViewById(R.id.sCPassword);

        String sharedSaveName = "saveUserName";
        SharedPreferences mPreferences = getSharedPreferences(sharedSaveName, MODE_PRIVATE);

    }

    public void logInClicked(View view) {
        String uName = loginUserName.getText().toString();
        String password = loginPassword.getText().toString();
        UserModel u = new UserModel();
        u.setUserName(uName);
        u.setPassword(password);


        if (UsersDB.validateUser(u)) {
            //Create intent
            Intent intent = new Intent(this, HistoryAndNewTestActivity.class);
            ResultModel result = (ResultModel) getIntent().getSerializableExtra("Result");

            result.setUserName(uName);
            intent.putExtra("Result", result);
            intent.putExtra("user_name", uName);


            String sharedSaveName = "saveUserName";
            SharedPreferences mPreferences = getSharedPreferences(sharedSaveName, MODE_PRIVATE);
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            preferencesEditor.putString("user_name", uName);
            preferencesEditor.apply();

            // Start the first activity page
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Username or password is incorrect!",
                    Toast.LENGTH_SHORT);

            toast.show();
        }

    }

    public void signUpClicked(View view) {
        String uName = sUserName.getText().toString();
        String password = sPassword.getText().toString();
        String cPassword = sCPassword.getText().toString();
        UsersDB usersDB = UsersDB.getInstance();

        // Check if username is already registered and so error if that's the case
        if (usersDB.checkUserExists(uName)) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Username is already registered!",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
        // Otherwise check if the passwords match
        else if (password.equals(cPassword)) {
            UserModel user = new UserModel();
            user.setUserName(uName);
            user.setPassword(password);

            usersDB.addUser(user);

            UsersDB allUsers = UsersDB.getInstance();
            allUsers.addUser(user);

            Gson gson = new Gson();

            String myData = gson.toJson(allUsers);
            Log.d("my data", myData);
            saveDataInstance.saveUsersToFile(myData);

            //Create intent
            Intent intent = new Intent(this, ClimateActivity.class);
            ResultModel result = new ResultModel();
            result.setUserName(uName);
            intent.putExtra("Result", result);
            intent.putExtra("user_name", uName);

            String sharedSaveName = "saveUserName";
            SharedPreferences mPreferences = getSharedPreferences(sharedSaveName, MODE_PRIVATE);
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            preferencesEditor.putString("user_name", uName);
            preferencesEditor.apply();

            // Start the first activity page
            startActivity(intent);
        }
        // If the passwords don't match, show an error
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Passwords do not match!",
                    Toast.LENGTH_SHORT);

            toast.show();
        }


    }
}