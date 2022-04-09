package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get result
        ResultModel result = (ResultModel) getIntent().getSerializableExtra("Result");

        // Set see history to false
        boolean seeHistory = getIntent().getBooleanExtra("seeHistory", false);

        // Get results database
        ResultsDB resultsDB = ResultsDB.getInstance();

        // Add the result to database if see history wasn't pressed
        if (!seeHistory) {
            resultsDB.addResult(result);
        }

        // Save data to results file
        saveData sv = new saveData();
      //  Gson gson = new Gson();
       // String myData = gson.toJson(resultsDB);
        //Log.d("my data", myData);
       // sv.saveResultsToFile(myData);

        sv.saveResultsToFile_new(resultsDB);

        // Get buttons, text and image
        TextView cityName = (TextView) findViewById(R.id.txtCityName);
        ImageView cityImg = (ImageView) findViewById(R.id.imgCity);
        TextView cityDesc = (TextView) findViewById(R.id.txtCityDescription);
        Button btnMoreInfo = (Button) findViewById(R.id.btnMoreInfo);
        Button btnMap = (Button) findViewById(R.id.btnMap);

        cityName.setText(result.getCityName());
        cityImg.setImageResource(result.getImage());
        cityDesc.setText(result.getDescription());
    }

    public void startOver(View view) {
        // Create intent
        Intent intent = new Intent(this, ClimateActivity.class);

        // Get result
        ResultModel result = (ResultModel) getIntent().getSerializableExtra("Result");

        // Pass result
        intent.putExtra("Result", result);

        // Start the initial activity page
        startActivity(intent);

    }

    public void seeHistory(View view) {

        // Create intent
        Intent intent = new Intent(this, HistoryActivity.class);

        /// Get result
        ResultModel result = (ResultModel) getIntent().getSerializableExtra("Result");

        // Pass result and history
        intent.putExtra("Result", result);
        intent.putExtra("seeHistory", true);

        // Start the history activity page
        startActivity(intent);

    }
}