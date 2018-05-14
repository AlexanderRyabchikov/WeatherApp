package com.example.skender.weatherapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import database.DataBase;
import Interfaces.Api;
import Interfaces.IDataBaseApi;
import helpers.DialogAddCity;
import helpers.WeatherApi;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import jsonHandler.model.CurrentWeather;
import jsonHandler.model.WeatherForecast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton addCityButton;
    Button selectCityButton;
    ImageButton refreshButton;
    ImageButton getMyLocationImageButton;
    TextView dateGetWeatherTextView;
    TextView minTemperatureTextView;
    TextView currentTemperatureTextView;
    TextView maxTemperatureTextView;
    TextView stateSkyTExtView;
    ImageView stateSkyImageView;
    TextView humidityTextView;
    TextView windSpeedTextView;
    TextView dayFisrtForecastTextView;
    TextView daySecondForecastTextView;
    TextView dayThirdForecastTextView;
    TextView dayFourthForecastTextView;
    TextView dayFivthForecastTextView;
    TextView temperatureFisrtForecastTextView;
    TextView temperatureSecondForecastTextView;
    TextView temperatureThirdForecastTextView;
    TextView temperatureFourthForecastTextView;
    TextView temperatureFivthForecastTextView;
    ImageView stateSkyFisrtForecastImageView;
    ImageView stateSkySecondForecastImageView;
    ImageView stateSkyThirdForecastImageView;
    ImageView stateSkyFourthForecastImageView;
    ImageView stateSkyFivthForecastImageView;
    IDataBaseApi dataBase;
    ArrayList<String> arrayList;
    SpinnerDialog spinnerDialog;
    Api weatherApi;
    public static final String TITLE_SPINNER = "Выберите город";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMainActivity();
        dataBase = new DataBase();
        dataBase.open_connection();
        arrayList = new ArrayList<>(dataBase.getAllCities());
        spinnerDialog = new SpinnerDialog(MainActivity.this, arrayList, TITLE_SPINNER);
        spinnerDialog.bindOnSpinerListener((s, i) -> {
            selectCityButton.setText(s);
            if(s.equals("Сочи")){
                s = "Sochi";
            }
            getCurrentWeather(s);
            getForecastWeather(s);
        });
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        dataBase.close_connection();
    }

    @Override
    protected void onStop(){
        super.onStop();
        dataBase.close_connection();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.AddCity:
                DialogAddCity dialog = new DialogAddCity(this,
                        DialogAddCity.ADD_CITY_TITLE,
                        DialogAddCity.NAME_POSITIVE_BUTTON,
                        DialogAddCity.NAME_NEGATIVE_BUTTON, dataBase, MainActivity.this);
                dialog.createDialog();
                break;
            case R.id.SelectCity:
                spinnerDialog.showSpinerDialog();
                break;
            case R.id.refresh:
                String nameCity = selectCityButton.getText().toString();
                if (nameCity.equals(TITLE_SPINNER)) {
                    if(nameCity.equals("Сочи")){
                        nameCity = "Sochi";
                    }
                    getCurrentWeather(nameCity);
                    getForecastWeather(nameCity);
                }
                break;
            case R.id.myLocation:
                
                break;
            default:
                break;
        }
    }

    private void initMainActivity() {
        addCityButton = findViewById(R.id.AddCity);
        addCityButton.setOnClickListener(this);
        refreshButton = findViewById(R.id.refresh);
        refreshButton.setOnClickListener(this);
        getMyLocationImageButton = findViewById(R.id.myLocation);
        getMyLocationImageButton.setOnClickListener(this);
        selectCityButton = findViewById(R.id.SelectCity);
        selectCityButton.setOnClickListener(this);

        dateGetWeatherTextView = findViewById(R.id.textDate);
        minTemperatureTextView = findViewById(R.id.min_temperature);
        currentTemperatureTextView = findViewById(R.id.main_temperature);
        maxTemperatureTextView = findViewById(R.id.max_temperature);
        stateSkyTExtView = findViewById(R.id.state_sky);

        humidityTextView = findViewById(R.id.textHumidity);
        windSpeedTextView = findViewById(R.id.textWind);
        dayFisrtForecastTextView = findViewById(R.id.dayWeek1);
        daySecondForecastTextView = findViewById(R.id.dayWeek2);
        dayThirdForecastTextView = findViewById(R.id.dayWeek3);
        dayFourthForecastTextView = findViewById(R.id.dayWeek4);
        dayFivthForecastTextView = findViewById(R.id.dayWeek5);
        temperatureFisrtForecastTextView = findViewById(R.id.temperatureDay1);
        temperatureSecondForecastTextView = findViewById(R.id.temperatureDay2);
        temperatureThirdForecastTextView = findViewById(R.id.temperatureDay3);
        temperatureFourthForecastTextView = findViewById(R.id.temperatureDay4);
        temperatureFivthForecastTextView = findViewById(R.id.temperatureDay5);
        stateSkyImageView = findViewById(R.id.viewIcon);
        stateSkyFisrtForecastImageView = findViewById(R.id.iconDay1);
        stateSkySecondForecastImageView = findViewById(R.id.iconDay2);
        stateSkyThirdForecastImageView = findViewById(R.id.iconDay3);
        stateSkyFourthForecastImageView = findViewById(R.id.iconDay4);
        stateSkyFivthForecastImageView = findViewById(R.id.iconDay5);

        weatherApi = WeatherApi.getClient().create(Api.class);


    }

    public void getCurrentWeather(String nameCity){
        Call call = weatherApi.getCurrentWeatherForNameCity(nameCity,
                WeatherApi.API_KEY,
                WeatherApi.UNITS);
        setCallBackCurrentWeather(call);
    }

    public void getCurrentWeather(double latitude, double lontitude){
        Double lat = 49.22;
        Double lng = 28.409;
        Call call = weatherApi.getCurrentWeatherForCoordinate(
                lat,
                lng,
                WeatherApi.API_KEY,
                WeatherApi.UNITS);
        setCallBackCurrentWeather(call);
    }

    public void getForecastWeather(String nameCity){
        Call call = weatherApi.getWeatherForecastForNameCity(nameCity,
                WeatherApi.API_KEY,
                WeatherApi.UNITS);
        setCallBackForecastWeather(call);
    }

    public void getForecastWeather(double latitude, double lontitude){
        Call call = weatherApi.getWeatherForecastForCoordinate(
                lontitude,
                latitude,
                WeatherApi.API_KEY,
                WeatherApi.UNITS);
        setCallBackForecastWeather(call);
    }

    public void setCallBackCurrentWeather(Call call){
        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call call, Response response) {
                CurrentWeather data = (CurrentWeather) response.body();

                if(response.isSuccessful()){
                    @SuppressLint("DefaultLocale")
                    String date = String.format("%d.%d.%d %d:%d",
                            data.getDate().get(Calendar.DAY_OF_MONTH),
                            data.getDate().get(Calendar.WEEK_OF_MONTH),
                            data.getDate().get(Calendar.YEAR),
                            data.getDate().get(Calendar.HOUR_OF_DAY),
                            data.getDate().get(Calendar.MINUTE));
                    dateGetWeatherTextView.setText(date);
                    minTemperatureTextView.setText(data.getMainWeather().getMin_temperature());
                    maxTemperatureTextView.setText(data.getMainWeather().getMax_temperature());
                    currentTemperatureTextView.setText(data.getMainWeather().getTemperature());
                    stateSkyTExtView.setText(data.getCurrentCondition().get(0).getDescription());
                    stateSkyImageView.setImageDrawable(
                            getIcon(data.getCurrentCondition().get(0).getIconWeather()));
                    humidityTextView.setText(data.getMainWeather().getHumidity());
                    windSpeedTextView.setText(data.getWind().getSpeed());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("Skender", "refresh_error");
            }
        });
    }

    @SuppressLint("ResourceType")
    private Drawable getIcon(String iconWeather) {

        Drawable icon_id = getResources().getDrawable(R.drawable.icon_44);
        if(iconWeather.contains("d")){
            switch (iconWeather){
                case "01d":
                        icon_id = getResources().getDrawable(R.drawable.icon_01d);
                    break;
                case "02d":
                        icon_id = getResources().getDrawable(R.drawable.icon_02d);
                    break;
                case "03d":
                        icon_id = getResources().getDrawable(R.drawable.icon_03d);
                    break;
                case "09d":
                        icon_id = getResources().getDrawable(R.drawable.icon_09d);
                    break;
                case "10d":
                        icon_id = getResources().getDrawable(R.drawable.icon_10d);
                    break;
                case "11d":
                        icon_id = getResources().getDrawable(R.drawable.icon_11d);
                    break;
                case "13d":
                        icon_id = getResources().getDrawable(R.drawable.icon_13d);
                    break;
            }

        }else if (iconWeather.contains("n")){
            switch (iconWeather){
                case "01n":
                    icon_id = getResources().getDrawable(R.drawable.icon_01n);
                    break;
                case "02n":
                    icon_id = getResources().getDrawable(R.drawable.icon_02n);
                    break;
                case "03n":
                    icon_id = getResources().getDrawable(R.drawable.icon_03n);
                    break;
                case "09n":
                    icon_id = getResources().getDrawable(R.drawable.icon_09n);
                    break;
                case "10n":
                    icon_id = getResources().getDrawable(R.drawable.icon_10n);
                    break;
                case "11n":
                    icon_id = getResources().getDrawable(R.drawable.icon_11n);
                    break;
                case "13n":
                    icon_id = getResources().getDrawable(R.drawable.icon_13n);
                    break;
            }

        }

        return icon_id;
    }

    public void setCallBackForecastWeather(Call call){
        call.enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call call, Response response) {
                WeatherForecast data = (WeatherForecast) response.body();
                if(response.isSuccessful()){
                    SimpleDateFormat formatDayOfWeek = new SimpleDateFormat("E");
                    String dateFirstDay = formatDayOfWeek.format(data.getItems().get(2).getDate().getTime());
                    dayFisrtForecastTextView.setText(dateFirstDay);
                    temperatureFisrtForecastTextView.setText(data.getItems().get(2).getMainWeather().getTemperature());
                    stateSkyFisrtForecastImageView.setImageDrawable(
                            getIcon(data
                                    .getItems()
                                    .get(2)
                                    .getCurrentCondition()
                                    .get(0)
                                    .getIconWeather()));


                    String dateSecondDay = formatDayOfWeek.format(data.getItems().get(10).getDate().getTime());
                    daySecondForecastTextView.setText(dateSecondDay);
                    temperatureSecondForecastTextView.setText(data.getItems().get(10).getMainWeather().getTemperature());
                    stateSkySecondForecastImageView.setImageDrawable(
                            getIcon(data
                                    .getItems()
                                    .get(10)
                                    .getCurrentCondition()
                                    .get(0)
                                    .getIconWeather()));


                    String dateThirdDay = formatDayOfWeek.format(data.getItems().get(18).getDate().getTime());
                    dayThirdForecastTextView.setText(dateThirdDay);
                    temperatureThirdForecastTextView.setText(data.getItems().get(18).getMainWeather().getTemperature());
                    stateSkyThirdForecastImageView.setImageDrawable(
                            getIcon(data
                                    .getItems()
                                    .get(18)
                                    .getCurrentCondition()
                                    .get(0)
                                    .getIconWeather()));


                    String dateFourthDay = formatDayOfWeek.format(data.getItems().get(26).getDate().getTime());
                    dayFourthForecastTextView.setText(dateFourthDay);
                    temperatureFourthForecastTextView.setText(data.getItems().get(26).getMainWeather().getTemperature());
                    stateSkyFourthForecastImageView.setImageDrawable(
                            getIcon(data
                                    .getItems()
                                    .get(26)
                                    .getCurrentCondition()
                                    .get(0)
                                    .getIconWeather()));


                    String dateFivthDay = formatDayOfWeek.format(data.getItems().get(34).getDate().getTime());
                    dayFivthForecastTextView.setText(dateFivthDay);
                    temperatureFivthForecastTextView.setText(data.getItems().get(34).getMainWeather().getTemperature());
                    stateSkyFivthForecastImageView.setImageDrawable(
                            getIcon(data
                                    .getItems()
                                    .get(34)
                                    .getCurrentCondition()
                                    .get(0)
                                    .getIconWeather()));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
