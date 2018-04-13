package com.example.skender.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;

import jsonHandler.model.JsonWeatherHandler;
import jsonHandler.model.Weather;

public class MainActivity extends AppCompatActivity {

    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonResponse = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39},\n" +
                "\"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\",\"sunrise\":1427723751,\"sunset\":1427768967},\n" +
                "\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}],\n" +
                "\"base\":\"stations\",\n" +
                "\"main\":{\"temp\":285.68,\"humidity\":74,\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48},\n" +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001},\n" +
                "\"clouds\":{\"all\":0},\n" +
                "\"dt\":1427700245,\n" +
                "\"id\":0,\n" +
                "\"name\":\"Mountain View\",\n" +
                "\"cod\":200}";
        try {
            weather = JsonWeatherHandler.getWeather(jsonResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        
    }
}
