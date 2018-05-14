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
        WeatherTable weatherTable = new WeatherTable();

        weatherTable._id = builderDB.get_id();
        weatherTable = this.fillData(weatherTable, builderDB);
        iRoomInterface.update(weatherTable);
    }

    @Override
    public void addEntry(BuilderDB builderDB) {
        WeatherTable weatherTable = this.fillData(new WeatherTable(), builderDB);
        iRoomInterface.insert(weatherTable);

    }

    private WeatherTable fillData(WeatherTable weatherTable, BuilderDB builderDB){
        weatherTable._nameCity = builderDB.get_nameCity();
        weatherTable._date = builderDB.get_date();
        weatherTable._minTemp = builderDB.get_minTemp();
        weatherTable._currentTemp = builderDB.get_currentTemp();
        weatherTable._maxTemp = builderDB.get_maxTemp();
        weatherTable._skyDescription = builderDB.get_skyDescription();
        weatherTable._iconId = builderDB.get_iconId();
        weatherTable._humidity = builderDB.get_humidity();
        weatherTable._wind = builderDB.get_wind();

        weatherTable._firstDayName = builderDB.get_firstDayName();
        weatherTable._firstDayTemp = builderDB.get_firstDayTemp();
        weatherTable._firstDayIcon = builderDB.get_firstDayIcon();

        weatherTable._secondDayName = builderDB.get_secondDayName();
        weatherTable._secondDayTemp = builderDB.get_secondDayTemp();
        weatherTable._secondDayIcon = builderDB.get_secondDayIcon();

        weatherTable._thirdDayName = builderDB.get_thirdDayName();
        weatherTable._thirdDayTemp = builderDB.get_thirdDayTemp();
        weatherTable._thirdDayIcon = builderDB.get_thirdDayIcon();

        weatherTable._fourthDayName = builderDB.get_fourthDayName();
        weatherTable._fourthDayTemp = builderDB.get_fourthDayTemp();
        weatherTable._fourthDayIcon = builderDB.get_fourthDayIcon();

        weatherTable._fivthDayName = builderDB.get_fivthDayName();
        weatherTable._fivthDayTemp = builderDB.get_fivthDayTemp();
        weatherTable._fivthDayIcon = builderDB.get_fivthDayIcon();

        return weatherTable;

    }
}
