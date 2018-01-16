package training.giovas.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softwaremobility.network.Connection
import com.softwaremobility.simplehttp.NetworkConnection
import kotlinx.android.synthetic.main.fragment_main.view.*
import training.giovas.adapters.WeatherAdapter
import training.giovas.json.JSONParser
import training.giovas.models.WeatherObject
import training.giovas.sunshine.R

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */
class Main : Fragment() {

    var data = ArrayList<WeatherObject>()

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
        getWeatherData(context)
    }

    fun getWeatherData(context: Context){
        val endpoint = Uri.parse(context.getString(R.string.endpoint_weather_list))
        val params = HashMap<String,String>()
        params.put(context.getString(R.string.param_format),"json")
        params.put(context.getString(R.string.param_days),"14")
        params.put(context.getString(R.string.param_query),"45050")
        params.put(context.getString(R.string.param_units),"metric")
        params.put(context.getString(R.string.param_api_key), context.getString(R.string.api_key))
        val headers = HashMap<String,String>()
        headers.put("Content-Type","application/json")
        NetworkConnection.with(context).withListener(object: NetworkConnection.ResponseListener{
            override fun onSuccessfullyResponse(response: String?) {
                data = JSONParser.getWeatherObjects(response!!)
            }

            override fun onErrorResponse(error: String?, message: String?, code: Int) {

            }

        }).doRequest(Connection.REQUEST.GET,endpoint,params,headers,null)
    }
}