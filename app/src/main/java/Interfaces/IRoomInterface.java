package Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import database.WeatherTable;

/**
 * Created by skender on 04.05.18.
 */
@Dao
public interface IRoomInterface {

    @Insert
    void insert(WeatherTable weatherTable);

    @Delete
    void delete (WeatherTable weatherTable);

    @Query("SELECT _nameCity FROM weathertable")
    List<String> getListCities();

    @Query("SELECT * FROM weathertable WHERE _nameCity LIKE :nameCity")
    WeatherTable getWeather(String nameCity);

    @Update
    void update(WeatherTable weatherTable);
}
