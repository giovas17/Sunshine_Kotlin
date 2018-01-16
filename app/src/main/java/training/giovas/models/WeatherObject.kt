package training.giovas.models

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */
class WeatherObject{
    var minTemperature: Double = 0.0
    var maxTemperature: Double = 0.0
    lateinit var description: String
    lateinit var imagePath: String
    var dateTime: Long = 0

    constructor(minTemperature: Double, maxTemperature: Double, description: String, imagePath: String, dateTime: Long){
        this.minTemperature = minTemperature
        this.maxTemperature = maxTemperature
        this.description = description
        this.imagePath = imagePath
        this.dateTime = dateTime
    }
}