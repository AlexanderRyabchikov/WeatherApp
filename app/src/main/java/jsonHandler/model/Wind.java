package jsonHandler.model;

/**
 * Created by alexa on 22.04.2018.
 */

public class Wind {

    private static final String METRICS = " м/с";
    public String getSpeed() {
        return String.valueOf(speed) + METRICS;
    }

    private double speed;
}
