package database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by skender on 04.05.18.
 */

@Entity
public class WeatherTable {
    public @PrimaryKey(autoGenerate = true)int _id;

    /* Location */
    public String _nameCity;
}
