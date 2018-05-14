package DataBase;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import Interfaces.IRoomInterface;

/**
 * Created by skender on 04.05.18.
 */

@Database(entities = WeatherTable.class, version = 1, exportSchema = false)
public abstract class WeatherDataBase extends RoomDatabase{
    public abstract IRoomInterface getIRoomInterface();
}
