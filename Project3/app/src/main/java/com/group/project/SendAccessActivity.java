package com.group.project;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SendAccessActivity extends AppCompatActivity {

    EditText userEmail;
    EditText userAccessCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_access_code);
        userEmail = findViewById(R.id.textViewEmail);
        userAccessCode = findViewById(R.id.textViewAccessCode);
    }

    public void submitAccessClicked(View view) {

        UserModel userModel = new UserModel();

        userModel.setEmail(userEmail.getText().toString());
        userModel.setAccessCode(userAccessCode.getText().toString());

        if(UsersDB.resetPassword(userModel)){

             Toast.makeText(this,
                    "information is correct",
                    Toast.LENGTH_SHORT).show();

        }else {
             Toast.makeText(this,
                    "information is not correct",
                    Toast.LENGTH_SHORT).show();
        }



    }
}
