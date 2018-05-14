package DataBase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by skender on 04.05.18.
 */

@Entity
public class WeatherTable {
    public @PrimaryKey(autoGenerate = true)int _id;

    /* Location */
    public String _nameCity;
    public double _latitude;
    public double _lontitude;

    /* Current Weather */
    public String _date;
    public double _minTemp;
    public double _currentTemp;
    public double _maxTemp;
    public String _skyDescription;
    public String _iconId;
    public double _humidity;
    public double _wind;

    /* Five days' weather */

    public String _firstDayName;
    public String _firstDayIcon;
    public String _firstDayTemp;

    public String _secondDayName;
    public String _secondDayIcon;
    public String _secondDayTemp;

    public String _thirdDayName;
    public String _thirdDayIcon;
    public String _thirdDayTemp;

    public String _fourthDayName;
    public String _fourthDayIcon;
    public String _fourthDayTemp;

    public String _fivthDayName;
    public String _fivthDayIcon;
    public String _fivthDayTemp;
}
