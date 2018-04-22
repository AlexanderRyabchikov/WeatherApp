package jsonHandler.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

/**
 * Created by alexa on 22.04.2018.
 */

public class CurrentWeather {

    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    public MainWeather getMainWeather() {
        return mainWeather;
    }

    public Wind getWind() {
        return wind;
    }

    public Calendar getDate() {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(timestamp * 1000);
        return date;
    }

    @SerializedName("main")
    private MainWeather mainWeather;
    private Wind wind;

    @SerializedName("weather")
    private List<CurrentCondition> currentCondition;
    @SerializedName("dt")
    private long timestamp;
}
