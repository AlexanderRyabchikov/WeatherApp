package database;

import android.app.Application;
import android.arch.persistence.room.Room;

/**
 * Created by skender on 05.05.18.
 */

public class DataBaseSingleton extends Application{

    public static DataBaseSingleton instance;
    private WeatherDataBase dataBase;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        dataBase = Room
                .databaseBuilder(this, WeatherDataBase.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public WeatherDataBase getDataBase() {
        return dataBase;
    }
    public static DataBaseSingleton getInstance() {
        return instance;
    }
}
