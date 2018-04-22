package jsonHandler.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alexa on 22.04.2018.
 */

public class CurrentCondition {
    public String getDescription() {
        return description;
    }

    public String getIconWeather() {
        return iconWeather;
    }

    private String description;
    @SerializedName("icon")
    private String iconWeather;
}
