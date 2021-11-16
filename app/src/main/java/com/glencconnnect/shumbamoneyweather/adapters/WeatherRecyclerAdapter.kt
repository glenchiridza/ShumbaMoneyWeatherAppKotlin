/**
 * Created by glenc on Nov 2021
 **/
package com.glencconnnect.shumbamoneyweather.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.glencconnnect.shumbamoneyweather.R
import com.glencconnnect.shumbamoneyweather.constants.ApiConstants
import com.glencconnnect.shumbamoneyweather.models.OuterContainer
import com.glencconnnect.shumbamoneyweather.models.Weather
import com.glencconnnect.shumbamoneyweather.ui.DetailView
import java.util.*
import com.glencconnnect.shumbamoneyweather.models.List as List1

class WeatherRecyclerAdapter(private val context: Context, private var weatherList: List<List1>): RecyclerView.Adapter<WeatherRecyclerAdapter.MyViewHolder>() {

    companion object {
        const val WEATHER_DATA = "WEATHER_DATA"
    }


    fun setDataListing(weatherList: ArrayList<List1>) {
        this.weatherList = weatherList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(
                R.layout.detail_item,
                parent,
                false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //bind the view elements , use holder to access the views and set their representational data from the data received from api

//
//        bannerImage.setImageResource(R.drawable.top_learner);
//        Picasso.get().load(learnersList.get(position).getImage()).into(bannerImage);
//        full_name.setText(learnersList.get(position).getName());
//
        val city = "Harare"
        val deg_sb = StringBuilder()


        val date: String = weatherList[position].dt_txt
        //    String weatherDescription = weatherList.get(0).getWeather().get(position).getDescription();
        //    String weatherDescription = weatherList.get(0).getWeather().get(position).getDescription();
        val degrees: String = java.lang.String.valueOf(weatherList[position].getMain().temp)
        deg_sb.append(degrees).append('\u00B0').append(" C")

        //get the weather list

        //get the weather list
        val weather: ArrayList<Weather?>? = weatherList[position].weather
        val weatherDescription: String = weather?.get(0)!!.description
        //get icon, add url string first then the image name retrieved from json response
        //get icon, add url string first then the image name retrieved from json response
        val icon: String = ApiConstants.ICON_URL + weather?.get(0)!!.icon.toString() + ".png"

        val humidity: String = java.lang.String.valueOf(weatherList[position].getMain().humidity)
        val pressure: String = java.lang.String.valueOf(weatherList[position].getMain().pressure)

        holder.wCity.text = city
        holder.wDate.text = date
        holder.wWeather.text = weatherDescription
        holder.wDegrees.text = deg_sb


        //pass the content to the intent being started


        //pass the content to the intent being started
        val weatherData = ArrayList<String>()
        weatherData.add(0, date)
        weatherData.add(1, degrees)
        weatherData.add(2, weatherDescription)
        weatherData.add(3, humidity)
        weatherData.add(4, pressure)
        weatherData.add(5, icon)

        holder.itemView.setOnClickListener { view: View? ->
            val detailIntent = Intent(context, DetailView::class.java)
            detailIntent.putExtra(WeatherRecyclerAdapter.WEATHER_DATA, weatherData)
            context.startActivity(detailIntent)
        }
    }



    override fun getItemCount(): Int  = weatherList.size


    inner class MyViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView){
        var wDate:TextView = itemView.findViewById(R.id.txt_date)
        var wCity:TextView = itemView.findViewById(R.id.txt_city)
        var wDegrees:TextView = itemView.findViewById(R.id.txt_degrees)
        var wWeather:TextView = itemView.findViewById(R.id.txt_weather)
    }
}