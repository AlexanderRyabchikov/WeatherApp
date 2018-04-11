package jsonHandler

class Weather {
    var location: LocationWeather? = null
    var currentCondidtion:CurrentCondition = CurrentCondition()
    var temperature:Temperature = Temperature()
    var wind:Wind = Wind()
    var rain:Rain = Rain()
    var snow:Snow = Snow()
    var clouds:Clouds = Clouds()

    class CurrentCondition{
        var weatherId:Int? = 0
        var condition: String? = ""
        var descripion: String? = ""
        var iconWeather: String? = ""

        var pressure: Float? = 0.0f
        var humidity: Float? = 0.0f
    }

    class Temperature{
        var temperature:Float? = 0.0f
        var minTemperature:Float? = 0.0f
        var maxTemperature: Float? = 0.0f
    }

    class Wind{
        var speed:Float? = 0.0f
        var deg:Float? = 0.0f

    }

    class Rain{
        var time:String? = ""
        var ammount:Float? = 0.0f
    }

    class Snow{
        var time:String? = ""
        var ammount:Float? = 0.0f
    }
    class Clouds{
        var percent:Int? = 0
    }
}