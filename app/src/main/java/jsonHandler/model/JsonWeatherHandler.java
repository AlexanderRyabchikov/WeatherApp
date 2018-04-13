package jsonHandler.model;

import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonWeatherHandler {

    private static JSONObject getObject(String tagName, @NonNull JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject(tagName);
    }

    private static String getString(String tagName, @NonNull JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }

    private static float getFloat(String tagName, @NonNull JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    private static int getInt(String tagName, @NonNull JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }

    public static Weather getWeather(@NonNull String data)throws JSONException{

        Weather weather = new Weather();
        JSONObject jsonObject = new JSONObject(data);

        JSONObject coordinateObject =getObject("coord", jsonObject);
        weather.getLocationWeather().setLongitude(getFloat("lon", coordinateObject));
        weather.getLocationWeather().setLatitude(getFloat("lat", coordinateObject));

        JSONObject sysObject = getObject("sys", jsonObject);
        weather.getLocationWeather().setNameCountry(getString("country", sysObject));
        weather.getLocationWeather().setNameCity(getString("name", jsonObject));
        weather.getLocationWeather().setSunrise(getInt("sunrise", sysObject));
        weather.getLocationWeather().setSunset(getInt("sunset", sysObject));

        JSONObject jsonWeather = jsonObject.getJSONArray("weather").getJSONObject(0);

        weather.getCurrentCondition().setWeatherId(getInt("id", jsonWeather));
        weather.getCurrentCondition().setDescripion(getString("description", jsonWeather));
        weather.getCurrentCondition().setCondition(getString("main", jsonWeather));
        weather.getCurrentCondition().setIconWeather(getString("icon", jsonWeather));

        JSONObject jsonMainObject = getObject("main", jsonObject);

        weather.getCurrentCondition().setHumidity(getInt("humidity", jsonMainObject));
        weather.getCurrentCondition().setPressure(getInt("pressure", jsonMainObject));
        weather.getTemperature().setMaxTemperature(getFloat("temp_max", jsonMainObject));
        weather.getTemperature().setMinTemperature(getFloat("temp_min", jsonMainObject));
        weather.getTemperature().setCurrentTemperature(getFloat("temp", jsonMainObject));

        JSONObject jsonWindObject = getObject("wind", jsonObject);

        weather.getWind().setSpeed(getFloat("speed", jsonWindObject));
        weather.getWind().setDeg(getFloat("deg", jsonWindObject));

        JSONObject jsonCloudsObject = getObject("clouds", jsonObject);
        weather.getClouds().setPercent(getInt("all", jsonCloudsObject));

        return weather;
    }
}
