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
import com.glencconnnect.shumbamoneyweather.models.OuterContainer
import com.glencconnnect.shumbamoneyweather.ui.DetailView

class WeatherRecyclerAdapter(private val context: Context, private var weatherList: List<OuterContainer>): RecyclerView.Adapter<WeatherRecyclerAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(
                R.layout.detail_item,
                parent,
                false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

       /* //bind the view elements , use holder to access the views and set their representational data from the data received from api
        holder.wCity.text = "Harare"
        holder.wDate.text = "Tuesday 11/11/21"
        holder.wWeather.text = "Partly Cloudy"
        holder.wDegrees.text = "24 Degrees"
*/
        //bind the view elements , use holder to access the views and set their representational data from the data received from api

        val city: String = weatherList[position].city?.name ?: "Harare"

        val date: String = weatherList[position].list?.get(position)?.dt_txt ?: ""

        val weatherDescription: String = weatherList[position].list?.get(position)?.weather?.get(position)?.description
                ?: "clear"
        val degrees: String = java.lang.String.valueOf(weatherList[position].list?.get(position)?.getMain()?.temp)


        holder.wCity.text = city
        holder.wDate.text = date
        holder.wWeather.text = weatherDescription
        holder.wDegrees.text = degrees

        holder.itemView.setOnClickListener { view: View? ->
            context.startActivity(
                    Intent(
                            context,
                            DetailView::class.java
                    )
            )
        }
    }

    fun setDataListing(weatherList: List<OuterContainer?>?) {
        this.weatherList = weatherList as List<OuterContainer>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = weatherList.size


    inner class MyViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView){
        var wDate:TextView = itemView.findViewById(R.id.txt_date)
        var wCity:TextView = itemView.findViewById(R.id.txt_city)
        var wDegrees:TextView = itemView.findViewById(R.id.txt_degrees)
        var wWeather:TextView = itemView.findViewById(R.id.txt_weather)
    }
}