package com.example.skender.weatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

import helpers.HTTPClient;
import helpers.TabWeather;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import jsonHandler.model.*;

public class MainActivity extends AppCompatActivity /*implements OnSpinerItemClick, View.OnClickListener*/ {

    private String[] listDefaultCities = {
            "Penza",
            "Moscow",
            "Nizhniy Novgorod"
    };
    private static final String dialogTitle = "Выберите город...";
    TextView currentTemp;
    TextView skyState;
    ImageView imageView;
    SpinnerDialog spinnerDialog;
    ArrayList<String> arrayList;
    Button showListCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_action_bar_main);
        initMainActivity();*/
    }
/*
    private void initMainActivity() {
        currentTemp = findViewById(R.id.currentTemperature);
        skyState = findViewById(R.id.stateSkyData);
        showListCities = findViewById(R.id.spinnerCities);
        imageView = findViewById(R.id.iconWeather);
        arrayList = new ArrayList<>(Arrays.asList(listDefaultCities));
        spinnerDialog = new SpinnerDialog(MainActivity.this,
                arrayList,
                dialogTitle);

        spinnerDialog.bindOnSpinerListener(this);
        showListCities.setOnClickListener(this);

        new TabWeather().setup(findViewById(R.id.taHost));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.spinnerCities:
                spinnerDialog.showSpinerDialog();
                break;
        }
    }

    @Override
    public void onClick(String s, int i) {
        showListCities.setText(s);
        WeatherAsyncTask weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute(new String[]{s});
    }


    private class WeatherAsyncTask extends AsyncTask<String, Void, Weather>{

        @Override
        protected Weather doInBackground(String... strings) {
            Weather weather = new Weather();
            String data = (new HTTPClient().getWeatherData(strings[0]));
            try{
                weather = JsonWeatherHandler.getWeather(data);
                weather.setIconData(new HTTPClient().getImage(weather.getCurrentCondition().getIconWeather()));
            }catch (JSONException e){

            }
            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather){
            /*Скрываем прогрессБар*/
            /*if(weather.getIconData() != null && weather.getIconData().length > 0){
                Bitmap img = BitmapFactory.decodeByteArray(
                        weather.getIconData(),
                        0 ,
                        weather.getIconData().length);

                imageView.setImageBitmap(img);
            }


        }
            */
        /*@Override
        protected void onPreExecute(){*/
            /*Отображаем прогресс бар*/

        /*}
    }*/
}
