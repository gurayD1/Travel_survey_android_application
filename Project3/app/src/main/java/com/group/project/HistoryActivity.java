package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        String sharedSaveName = "saveUserName";
        SharedPreferences mPreferences = getSharedPreferences(sharedSaveName, MODE_PRIVATE);
        String user_name = mPreferences.getString("user_name", "");

        TableLayout prices = (TableLayout) findViewById(R.id.testTable);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        for (ResultModel result1 : ResultsDB.getAllResults()) {

            if (user_name.equals(result1.getUserName())) {
                TableRow tr = new TableRow(this);

                TextView userName = new TextView(this);
                userName.setText(result1.getUserName());
                userName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                userName.setPadding(10, 10, 10, 10);

                TextView id = new TextView(this);
                id.setText(String.valueOf(result1.getId()));
                id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                id.setPadding(10, 10, 10, 10);

                TextView budget = new TextView(this);
                budget.setText(String.valueOf(result1.getBudget()));
                budget.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                budget.setPadding(10, 10, 10, 10);

                TextView climate = new TextView(this);
                climate.setText(result1.getClimate());
                climate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                climate.setPadding(10, 10, 10, 10);

                TextView landScape = new TextView(this);
                landScape.setText(String.valueOf(result1.getLandscape()));
                landScape.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                landScape.setPadding(10, 10, 10, 10);

                TextView phobia = new TextView(this);
                phobia.setText(String.valueOf(result1.getPhobia()));
                phobia.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                phobia.setPadding(10, 10, 10, 10);

                TextView cityName = new TextView(this);
                cityName.setText(String.valueOf(result1.getCityName()));
                cityName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                cityName.setPadding(10, 10, 10, 10);

                TextView countryName = new TextView(this);
                countryName.setText(String.valueOf(result1.getCountryName()));
                countryName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                countryName.setPadding(10, 10, 10, 10);


                tr.addView(userName);
                tr.addView(id);
                tr.addView(budget);

                tr.addView(climate);
                tr.addView(landScape);
                tr.addView(phobia);

                tr.addView(cityName);
                tr.addView(countryName);


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
        String sharedSaveName = "saveUserName";
        SharedPreferences mPreferences = getSharedPreferences(sharedSaveName, MODE_PRIVATE);
        String user_name = mPreferences.getString("user_name", "");

        ResultModel result = new ResultModel();
        result.setUserName(user_name);
        intent.putExtra("Result", result);
        startActivity(intent);

    }


}