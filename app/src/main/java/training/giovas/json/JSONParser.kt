package training.giovas.json

import android.content.Context
import org.json.JSONObject
import training.giovas.models.WeatherObject

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */
class JSONParser {
    companion object {
        fun getWeatherObjects(response: String) : ArrayList<WeatherObject>{
            var objects = ArrayList<WeatherObject>()
            val obj = JSONObject(response)
            val arrayObj = obj.getJSONArray("list")
            for(index in 0..(arrayObj.length() - 1)){
                val currentObj = arrayObj.getJSONObject(index)
                val tempObject = currentObj.getJSONObject("temp")
                val minTemperature = tempObject.optDouble("min",0.0)
                val maxTemperature = tempObject.optDouble("max",0.0)
                val descObject = currentObj.getJSONArray("weather")
                val description = descObject.getJSONObject(0).optString("main","")
                objects.add(WeatherObject(minTemperature,maxTemperature,description))
            }
            return objects
        }
    }
}