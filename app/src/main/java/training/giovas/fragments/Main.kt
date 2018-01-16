package training.giovas.fragments

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.view.*
import training.giovas.adapters.WeatherAdapter
import training.giovas.network.NetworkUtilities
import training.giovas.sunshine.R

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */
class Main : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_main, container, false)

        var dummyData = arrayListOf<String>("dato1","dato2","dato3","dato4")
        var adapter = WeatherAdapter(context,dummyData)

        view.weatherList.layoutManager = LinearLayoutManager(context)
        view.weatherList.setHasFixedSize(true)
        view.weatherList.adapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NetworkUtilities.getWeatherData(context)
    }
}