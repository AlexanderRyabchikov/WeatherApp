package com.example.skender.weatherapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import jsonHandler.model.JsonWeatherHandler;
import jsonHandler.model.*;

public class MainActivity extends AppCompatActivity {

    private String[] listDefaultCities = {
            "Пенза",
            "Москва",
            "Нижний Новгород",
            "Санкт-Петербург"
    };
    ArrayList<String> arrayList;
    SpinnerDialog spinnerDialog;
    Button showListCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_action_bar_main);
        showListCities = findViewById(R.id.spinnerCities);
        arrayList = new ArrayList<>(Arrays.asList(listDefaultCities));
        spinnerDialog = new SpinnerDialog(MainActivity.this,
                arrayList,
                "Выберите город");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String s, int i) {
                showListCities.setText(s);
            }
        });

        showListCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerDialog.showSpinerDialog();
            }
        });
        Weather weather;

        TextView currentTemp = findViewById(R.id.currentTemperature);
        TextView skyState = findViewById(R.id.stateSkyData);
        TabHost tabHost = findViewById(R.id.taHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tagNow");
        tabSpec.setIndicator("Сегодня");
        tabSpec.setContent(R.id.tvTab1);
        tabHost.addTab(tabSpec);


        tabSpec = tabHost.newTabSpec("TheeDayTag");
        tabSpec.setIndicator("На 3 дня");
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("FiveDayTag");
        tabSpec.setIndicator("На 5 дней");
        tabSpec.setContent(R.id.tvTab3);
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTabByTag("tagNow");


        String jsonResponse = "{\"coord\":{\"lon\":-122.09,\"lat\":37.39},\n" +
                "\"sys\":{\"type\":3,\"id\":168940,\"message\":0.0297,\"country\":\"US\",\"sunrise\":1427723751,\"sunset\":1427768967},\n" +
                "\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01n\"}],\n" +
                "\"base\":\"stations\",\n" +
                "\"main\":{\"temp\":25.6,\"humidity\":74,\"pressure\":1016.8,\"temp_min\":284.82,\"temp_max\":286.48},\n" +
                "\"wind\":{\"speed\":0.96,\"deg\":285.001},\n" +
                "\"clouds\":{\"all\":0},\n" +
                "\"dt\":1427700245,\n" +
                "\"id\":0,\n" +
                "\"name\":\"Mountain View\",\n" +
                "\"cod\":200}";
        try {
            weather = JsonWeatherHandler.getWeather(jsonResponse);
            currentTemp.setText(String.valueOf(weather.getTemperature().getCurrentTemperature()) + "\u2103");
            skyState.setText(weather.getCurrentCondition().getDescripion());
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
