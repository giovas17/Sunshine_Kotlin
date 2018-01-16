package training.giovas.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import training.giovas.models.WeatherObject
import training.giovas.sunshine.R

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */

class WeatherAdapter(var context: Context, var data: ArrayList<WeatherObject>) : RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherHolder {
        var view : View = LayoutInflater.from(context).inflate(R.layout.item_weather_list,parent, false)
        var weatherHolder = WeatherHolder(view)
        view.setTag(weatherHolder)
        return weatherHolder
    }

    override fun onBindViewHolder(holder: WeatherHolder?, position: Int) {
        holder!!.txtDescription.setText(data.get(position).description + "   " + data.get(position).maxTemperature)
        Glide.with(context).load(data.get(position).imagePath).into(holder.iconWeather)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class WeatherHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtDescription : TextView = itemView.findViewById(R.id.descriptionWeather)
        var iconWeather : ImageView = itemView.findViewById(R.id.iconWeather)
    }
}