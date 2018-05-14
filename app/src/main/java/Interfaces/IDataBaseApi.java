package Interfaces;
import java.util.List;
import DataBase.BuilderDB;
import DataBase.WeatherTable;

/**
 * Created by skender on 04.05.18.
 */

public interface IDataBaseApi {

    void open_connection();
    void close_connection();
    void addEntry(BuilderDB builderDB);
    void updateEntry(BuilderDB builderDB);
    void deleteEntry(int id);
    List<String>getAllCities();
    WeatherTable getEntry(String nameCity);
}
