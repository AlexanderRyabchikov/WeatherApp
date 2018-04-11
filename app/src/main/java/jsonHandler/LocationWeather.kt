package jsonHandler

import java.io.Serializable

class LocationWeather : Serializable{
    var longitude:Float? = 0.0f
    var latitude: Float? = 0.0f
    var sunset: Long? = 0
    var sunrise: Long? = 0
    var nameCounty: String? = ""
    var nameCity: String? = ""
}
