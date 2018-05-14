package jsonHandler.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alexa on 22.04.2018.
 */

public class MainWeather {

    private final static String CELSI =  "\u2103";
    private final static String PERCENT = " %";

    public String getTemperature() {
        return String.valueOf(temperature) + CELSI;
    }

    public String getHumidity() {
        return String.valueOf(humidity) + PERCENT;
    }

    public String getMin_temperature() {
        return String.valueOf(min_temperature) + CELSI;
    }

    public String getMax_temperature() {
        return String.valueOf(max_temperature) + CELSI;
    }

    @SerializedName("temp")
    private double temperature;
    private double humidity;
    @SerializedName("temp_min")
    private double min_temperature;
    @SerializedName("temp_max")
    private double max_temperature;


}
