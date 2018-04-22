package Interfaces;

import jsonHandler.model.CurrentWeather;
import jsonHandler.model.WeatherForecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexa on 22.04.2018.
 */

public interface Api {

    @GET("weather")
    Call<CurrentWeather> getCurrentWeatherForNameCity(
            @Query("q") String cityName,
            @Query("appid") String apiKey,
            @Query("units") String units
    );

    @GET("forecast")
    Call<WeatherForecast> getWeatherForecastForNameCity(
            @Query("q") String cityName,
            @Query("appid") String apiKey,
            @Query("units") String units
    );

    @GET("weather")
    Call<CurrentWeather> getCurrentWeatherForCoordinate(

            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("appid") String apiKey,
            @Query("units") String units
    );

    @GET("forecast")
    Call<WeatherForecast> getWeatherForecastForCoordinate(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
}
