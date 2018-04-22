package jsonHandler.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alexa on 22.04.2018.
 */

public class WeatherForecast {
    public List<CurrentWeather> getItems() {
        return items;
    }

    public void setItems(List<CurrentWeather> items) {
        this.items = items;
    }

    @SerializedName("list")
    private List<CurrentWeather> items;

}
