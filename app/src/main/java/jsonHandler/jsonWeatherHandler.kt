package jsonHandler

import org.json.JSONException
import org.json.JSONObject

class jsonWeatherHandler {
    companion object{
        @Throws(JSONException::class)
        fun getWeather(data:String): Weather? {

            var weather = Weather()
            var jsonObject = JSONObject(data)
            val location = LocationWeather()
            val coordObject:JSONObject = getObject("coord", jsonObject)
            location.latitude = getFloat("lat", coordObject)
            location.longitude = getFloat("lon", coordObject)

            val sysObjects = getObject("sys", jsonObject)
            location.nameCounty = getString("country", sysObjects)
            location.sunrise = getInt("sunrise", sysObjects).toLong()
            location.sunset = getInt("sunset", sysObjects).toLong()
            location.nameCity = getString("name", sysObjects)

            weather.location = location

            val jsonArray = jsonObject.getJSONArray("weather")

            val jsonWeather = jsonArray.getJSONObject(0)

            weather.currentCondidtion.weatherId = getInt("id", jsonWeather)
            weather.currentCondidtion.descripion = getString("description", jsonWeather)
            weather.currentCondidtion.condition = getString("main", jsonWeather)
            weather.currentCondidtion.iconWeather = getString("icon", jsonWeather)

            val mainJson = getObject("main", jsonObject)

            weather.currentCondidtion.humidity = getInt("humidity", mainJson).toFloat()
            weather.currentCondidtion.pressure = getInt("pressure", mainJson).toFloat()
            weather.temperature.maxTemperature = getFloat("temp_max", mainJson)
            weather.temperature.minTemperature = getFloat("temp_min", mainJson)
            weather.temperature.temperature = getFloat("temp", mainJson)

            val windObj = getObject("wind", jsonObject)
            weather.wind.speed = getFloat("speed", windObj)
            weather.wind.deg = getFloat("deg", windObj)

            val cloudObj = getObject("clouds", jsonObject)
            weather.clouds.percent = getInt("all", cloudObj)



            return weather
        }

        private fun getObject(tagName:String, jsonObject: JSONObject): JSONObject {
            return jsonObject.getJSONObject(tagName)
        }

        private fun getString(tagName:String, jsonObject: JSONObject): String{
            return jsonObject.getString(tagName)
        }

        private fun getFloat(tagName: String, jsonObject: JSONObject):Float{
            return jsonObject.getDouble(tagName).toFloat()
        }

        private fun getInt(tagName: String, jsonObject: JSONObject): Int{
            return jsonObject.getInt(tagName)
        }
    }
}