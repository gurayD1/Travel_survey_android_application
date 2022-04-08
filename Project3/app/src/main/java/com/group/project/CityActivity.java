package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initializeCities();
    }

    private void initializeCities() {
        Quiz quiz = new Quiz();

        // Get result
        ResultModel result = (ResultModel) getIntent().getSerializableExtra("Result");

        // Get buttons
        Button button1 = (Button) findViewById(R.id.buttonCity1);
        Button button2 = (Button) findViewById(R.id.buttonCity2);
        Button button3 = (Button) findViewById(R.id.buttonCity3);

        Button[] buttons = new Button[] {button1, button2, button3};

        // Filter cities
        ArrayList<String> cityList = quiz.getFinalCities(result);

        // Hide buttons depending on how many results there are
        switch (cityList.size()) {
            case 1:
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                break;
            case 2:
                button3.setVisibility(View.GONE);
                break;
        }

        // Display the city names in the buttons
        for (int i = 0; i < cityList.size(); i++) {
            buttons[i].setText(cityList.get(i));
        }
    }

    public void firstCityButtonClicked(View view) {
        //Create intent
        Intent intent = new Intent(this, ResultActivity.class);

        ResultModel result = (ResultModel)getIntent().getSerializableExtra("Result");
        Button button = (Button)findViewById(R.id.buttonCity1);

        result.setCityName(button.getText().toString());
        intent.putExtra("Result", result);
        // Start the first activity page
        startActivity(intent);
    }

    public void secondCityButtonClicked(View view) {
        //Create intent
        Intent intent = new Intent(this, ResultActivity.class);

        ResultModel result = (ResultModel)getIntent().getSerializableExtra("Result");
        Button button = (Button)findViewById(R.id.buttonCity2);

        result.setCityName(button.getText().toString());
        intent.putExtra("Result", result);
        // Start the first activity page
        startActivity(intent);
    }

    public void thirdCityButtonClicked(View view) {
        //Create intent
        Intent intent = new Intent(this, ResultActivity.class);

        ResultModel result = (ResultModel)getIntent().getSerializableExtra("Result");
        Button button = (Button)findViewById(R.id.buttonCity3);

        result.setCityName(button.getText().toString());
        intent.putExtra("Result", result);
        // Start the first activity page
        startActivity(intent);
    }

    // Back button clicked
    public void backButtonClicked(View view) {
        finish();
    }

    // Start over button clicked
    public void startOverButtonClicked(View view) {
        //Create intent
        Intent intent = new Intent(this, MainActivity.class);

        // Start the first activity page
        startActivity(intent);
    }
}