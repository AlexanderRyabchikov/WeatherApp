package DataBase;

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

    public double get_latitude() {
        return _latitude;
    }

    public void set_latitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double get_lontitude() {
        return _lontitude;
    }

    public void set_lontitude(double _lontitude) {
        this._lontitude = _lontitude;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public double get_minTemp() {
        return _minTemp;
    }

    public void set_minTemp(double _minTemp) {
        this._minTemp = _minTemp;
    }

    public double get_currentTemp() {
        return _currentTemp;
    }

    public void set_currentTemp(double _currentTemp) {
        this._currentTemp = _currentTemp;
    }

    public double get_maxTemp() {
        return _maxTemp;
    }

    public void set_maxTemp(double _maxTemp) {
        this._maxTemp = _maxTemp;
    }

    public String get_skyDescription() {
        return _skyDescription;
    }

    public void set_skyDescription(String _skyDescription) {
        this._skyDescription = _skyDescription;
    }

    public String get_iconId() {
        return _iconId;
    }

    public void set_iconId(String _iconId) {
        this._iconId = _iconId;
    }

    public double get_humidity() {
        return _humidity;
    }

    public void set_humidity(double _humidity) {
        this._humidity = _humidity;
    }

    public double get_wind() {
        return _wind;
    }

    public void set_wind(double _wind) {
        this._wind = _wind;
    }

    public String get_firstDayName() {
        return _firstDayName;
    }

    public void set_firstDayName(String _firstDayName) {
        this._firstDayName = _firstDayName;
    }

    public String get_firstDayIcon() {
        return _firstDayIcon;
    }

    public void set_firstDayIcon(String _firstDayIcon) {
        this._firstDayIcon = _firstDayIcon;
    }

    public String get_firstDayTemp() {
        return _firstDayTemp;
    }

    public void set_firstDayTemp(String _firstDayTemp) {
        this._firstDayTemp = _firstDayTemp;
    }

    public String get_secondDayName() {
        return _secondDayName;
    }

    public void set_secondDayName(String _secondDayName) {
        this._secondDayName = _secondDayName;
    }

    public String get_secondDayIcon() {
        return _secondDayIcon;
    }

    public void set_secondDayIcon(String _secondDayIcon) {
        this._secondDayIcon = _secondDayIcon;
    }

    public String get_secondDayTemp() {
        return _secondDayTemp;
    }

    public void set_secondDayTemp(String _secondDayTemp) {
        this._secondDayTemp = _secondDayTemp;
    }

    public String get_thirdDayName() {
        return _thirdDayName;
    }

    public void set_thirdDayName(String _thirdDayName) {
        this._thirdDayName = _thirdDayName;
    }

    public String get_thirdDayIcon() {
        return _thirdDayIcon;
    }

    public void set_thirdDayIcon(String _thirdDayIcon) {
        this._thirdDayIcon = _thirdDayIcon;
    }

    public String get_thirdDayTemp() {
        return _thirdDayTemp;
    }

    public void set_thirdDayTemp(String _thirdDayTemp) {
        this._thirdDayTemp = _thirdDayTemp;
    }

    public String get_fourthDayName() {
        return _fourthDayName;
    }

    public void set_fourthDayName(String _fourthDayName) {
        this._fourthDayName = _fourthDayName;
    }

    public String get_fourthDayIcon() {
        return _fourthDayIcon;
    }

    public void set_fourthDayIcon(String _fourthDayIcon) {
        this._fourthDayIcon = _fourthDayIcon;
    }

    public String get_fourthDayTemp() {
        return _fourthDayTemp;
    }

    public void set_fourthDayTemp(String _fourthDayTemp) {
        this._fourthDayTemp = _fourthDayTemp;
    }

    public String get_fivthDayName() {
        return _fivthDayName;
    }

    public void set_fivthDayName(String _fivthDayName) {
        this._fivthDayName = _fivthDayName;
    }

    public String get_fivthDayIcon() {
        return _fivthDayIcon;
    }

    public void set_fivthDayIcon(String _fivthDayIcon) {
        this._fivthDayIcon = _fivthDayIcon;
    }

    public String get_fivthDayTemp() {
        return _fivthDayTemp;
    }

    public void set_fivthDayTemp(String _fivthDayTemp) {
        this._fivthDayTemp = _fivthDayTemp;
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
    private double _latitude;
    private double _lontitude;

    /* Current Weather */
    private String _date;
    private double _minTemp;
    private double _currentTemp;
    private double _maxTemp;
    private String _skyDescription;
    private String _iconId;
    private double _humidity;
    private double _wind;

    /* Five days' weather */

    private String _firstDayName;
    private String _firstDayIcon;
    private String _firstDayTemp;

    private String _secondDayName;
    private String _secondDayIcon;
    private String _secondDayTemp;

    private String _thirdDayName;
    private String _thirdDayIcon;
    private String _thirdDayTemp;

    private String _fourthDayName;
    private String _fourthDayIcon;
    private String _fourthDayTemp;

    private String _fivthDayName;
    private String _fivthDayIcon;
    private String _fivthDayTemp;
}
