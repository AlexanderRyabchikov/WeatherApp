package DataBase;

import java.util.List;

import Interfaces.IDataBaseApi;
import Interfaces.IRoomInterface;

/**
 * Created by skender on 05.05.18.
 */

public class DataBase implements IDataBaseApi {


    private IRoomInterface iRoomInterface;
    private WeatherDataBase weatherDataBase;
    @Override
    public void open_connection() {
        weatherDataBase = DataBaseSingleton.getInstance().getDataBase();
        iRoomInterface = weatherDataBase.getIRoomInterface();

    }

    @Override
    public void close_connection() {
        iRoomInterface = null;
        weatherDataBase = null;
    }

    @Override
    public void deleteEntry(int id) {
        WeatherTable weatherTable = new WeatherTable();
        weatherTable._id = id;
        iRoomInterface.delete(weatherTable);
    }

    @Override
    public List<String> getAllCities() {
        return iRoomInterface.getListCities();
    }

    @Override
    public WeatherTable getEntry(String nameCity) {
        return iRoomInterface.getWeather(nameCity);
    }

    @Override
    public void updateEntry(BuilderDB builderDB) {

    }

    @Override
    public void addEntry(BuilderDB builderDB) {

    }
}
