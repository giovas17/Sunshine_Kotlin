package training.giovas.network

import android.content.Context
import android.net.Uri
import com.softwaremobility.network.Connection
import com.softwaremobility.simplehttp.NetworkConnection
import training.giovas.sunshine.R

/**
 * @author Giovani Gonzalez
 * Created by giovani on 1/16/18.
 */
class NetworkUtilities {

    companion object {
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

                }

                override fun onErrorResponse(error: String?, message: String?, code: Int) {

                }

            }).doRequest(Connection.REQUEST.GET,endpoint,params,headers,null)
        }
    }

}