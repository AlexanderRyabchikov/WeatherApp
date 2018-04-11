package com.example.skender.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import jsonHandler.AsyncTaskJson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncTaskJson asyncTaskJson = new AsyncTaskJson();
        Log.d("Skender", asyncTaskJson.getJsonResponse("Penza").toString());

    }
}
