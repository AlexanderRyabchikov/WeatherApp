package jsonHandler.model;


public class Weather {

    public class CurrentCondition{

        private int weatherId = 0;
        private String condition = "";
        private String descripion = "";
        private String iconWeather = "";

        private float pressure = 0.0f;
        private float humidity = 0.0f;

        public int getWeatherId() {
            return weatherId;
        }

        public void setWeatherId(int weatherId) {
            this.weatherId = weatherId;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getDescripion() {
            return descripion;
        }

        public void setDescripion(String descripion) {
            this.descripion = descripion;
        }

        public String getIconWeather() {
            return iconWeather;
        }

        public void setIconWeather(String iconWeather) {
            this.iconWeather = iconWeather;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public float getHumidity() {
            return humidity;
        }

        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

    }

    public class Temperature{

        public float getCurrentTemperature() {
            return temperature;
        }

        public void setCurrentTemperature(float temperature) {
            this.temperature = temperature;
        }

        public float getMinTemperature() {
            return minTemperature;
        }

        public void setMinTemperature(float minTemperature) {
            this.minTemperature = minTemperature;
        }

        public float getMaxTemperature() {
            return maxTemperature;
        }

        public void setMaxTemperature(float maxTemperature) {
            this.maxTemperature = maxTemperature;
        }

        private float temperature = 0.0f;
        private float minTemperature = 0.0f;
        private float maxTemperature = 0.0f;

    }

    public class Wind{

        public float getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }

        public float getDeg() {
            return deg;
        }

        public void setDeg(float deg) {
            this.deg = deg;
        }

        private float speed = 0.0f;
        private float deg = 0.0f;

    }

    class Rain{

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public float getAmmount() {
            return ammount;
        }

        public void setAmmount(float ammount) {
            this.ammount = ammount;
        }

        private String time = "";
        private float ammount = 0.0f;

    }

    class Snow{

        private String time = "";

        public void setTime(String time) {
            this.time = time;
        }

        public void setAmmount(float ammount) {
            this.ammount = ammount;
        }

        private float ammount = 0.0f;

    }

    public class Clouds{

        public int getPercent() {
            return percent;
        }

        public void setPercent(int percent) {
            this.percent = percent;
        }

        private int percent = 0;

    }


    public Weather(){
        locationWeather = new LocationWeather();
        currentCondition = new CurrentCondition();
        temperature = new Temperature();
        wind = new Wind();
        rain = new Rain();
        snow = new Snow();
        clouds = new Clouds();
    }

    public LocationWeather getLocationWeather() {
        return locationWeather;
    }

    public void setLocationWeather(LocationWeather locationWeather) {
        this.locationWeather = locationWeather;
    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public byte[] getIconData() {
        return iconData;
    }

    public void setIconData(byte[] iconData) {
        this.iconData = iconData;
    }

    private LocationWeather locationWeather;
    private CurrentCondition currentCondition;
    private Temperature temperature;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Clouds clouds;
    private byte[] iconData;


}
