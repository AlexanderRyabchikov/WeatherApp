package jsonHandler

import android.os.AsyncTask
import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class AsyncTaskJson{

    fun getJsonResponse(nameCity: String): JSONObject? {
        var dataWeather: JSONObject? = null
        object: AsyncTask<Void, Void, Void>(){

            override fun onPreExecute() {
                super.onPreExecute()
            }

            override fun doInBackground(vararg p0: Void?): Void? {
                try {

                    val url = URL("http://api.openweathermap.org/data/2.5/weather?q=$nameCity&APPID=100990e8db1238b2c6b21cc67034eabf")

                    val connection = url.openConnection() as HttpURLConnection


                    val reader = BufferedReader(InputStreamReader(connection.inputStream))

                    val json = StringBuffer(1024)
                    var tmp:String?

                    do{
                        tmp = reader.readLine()
                        if(tmp == null) {
                            break
                        }else {
                            json.append(tmp).append("\n")
                        }

                    }while(true)
                    reader.close()

                    dataWeather = JSONObject(json.toString())

                    if (dataWeather!!.getInt("cod") != 200) {
                        Log.d("weatherApp", "Error")
                        return null
                    }


                } catch (e: Exception) {

                    e.printStackTrace()
                    return null
                }

                return null
            }

            override fun onPostExecute(result: Void?) {

                super.onPostExecute(result)
            }
        }.execute().get()

        return dataWeather
    }
}