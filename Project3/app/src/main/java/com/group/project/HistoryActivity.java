package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;

public class HistoryActivity extends AppCompatActivity {
    String user_name = "";
    Button deleteRow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        
        ResultModel result = (ResultModel) getIntent().getSerializableExtra("Result");

        boolean seeHistory = getIntent().getBooleanExtra("seeHistory", false);

        String sharedSaveName = "saveUserName";
        SharedPreferences mPreferences = getSharedPreferences(sharedSaveName, MODE_PRIVATE);
        user_name = mPreferences.getString("user_name", "");


        ResultsDB resultsDB = ResultsDB.getInstance();


        if (!seeHistory) {
            resultsDB.addResult(result);
        }

        saveData sv = new saveData();

       // Gson gson = new Gson();

       // String myData = gson.toJson(resultsDB);
       // Log.d("my data", myData);
       // sv.saveResultsToFile(myData);

        TableLayout prices = (TableLayout) findViewById(R.id.testTable);
        //TableRow cityNames = (TableRow) findViewById(R.id.cityName);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        for (ResultModel result1 : ResultsDB.getAllResults()) {

            if (user_name.equals(result1.getUserName())) {
                TableRow tr = new TableRow(this);


                TextView cityName = new TextView(this);
                cityName.setText(String.valueOf(result1.getCityName()));
                cityName.setTextSize(20);
                //cityName.setPadding(1, 5, 1, 5);

                TextView countryName = new TextView(this);
                countryName.setText(String.valueOf(result1.getCountryName()));
                countryName.setTextSize(20);
                // countryName.setPadding(1, 5, 1, 5);

                Button deleteRow = new Button(this);

                //tr.setVisibility(View.GONE);

                deleteRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //cityName.setText(View.GONE);
                        //countryName.setText(View.GONE);


                        //cityName.setText(String.valueOf(result1.setCityName()));
                        cityName.setText(String.valueOf(result1.getCityName()));
                        countryName.setText(String.valueOf(result1.getCountryName()));
                        deleteRow.setText(String.valueOf(result1.getCityName()));
                    }
                });

                tr.addView(cityName);
                tr.addView(countryName);
                tr.addView(deleteRow);

                prices.addView(tr);
            }

        }

    }


    // Start button clicked
    public void logOutButtonClicked(View view) {

        Intent intent = new Intent(this, LogInPageActivity.class);
        ResultModel result = new ResultModel();
        intent.putExtra("Result", result);
        startActivity(intent);
    }

    public void startOverButtonClicked(View view) {
        Intent intent = new Intent(this, ClimateActivity.class);
        ResultModel result = new ResultModel();
        result.setUserName(user_name);
        intent.putExtra("Result", result);
        startActivity(intent);

    }


}
