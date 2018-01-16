package training.giovas.models

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */
class WeatherObject{
    var minTemperature: Double = 0.0
    var maxTemperature: Double = 0.0
    lateinit var description: String

    constructor(minTemperature: Double, maxTemperature: Double, description: String){
        this.minTemperature = minTemperature
        this.maxTemperature = maxTemperature
        this.description = description
    }
}