package database;

/**
 * Created by skender on 05.05.18.
 */

public class BuilderDB {
    public String get_nameCity() {
        return _nameCity;
    }

    public void set_nameCity(String _nameCity) {
        this._nameCity = _nameCity;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    private int _id;
    /* Location */
    private String _nameCity;
}
