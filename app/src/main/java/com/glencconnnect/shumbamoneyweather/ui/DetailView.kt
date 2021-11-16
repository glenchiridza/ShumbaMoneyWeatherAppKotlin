package com.glencconnnect.shumbamoneyweather.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.glencconnnect.shumbamoneyweather.R
import com.glencconnnect.shumbamoneyweather.adapters.WeatherRecyclerAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_item.*

class DetailView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)

        //set the values retrieved from intent, in accordance to their position in passed on ArrayList
        val weatherData = intent.getStringArrayListExtra(WeatherRecyclerAdapter.WEATHER_DATA)
        if (weatherData != null) {
            //use substring to remove the time, and output date sequence only
            dv_date!!.text = weatherData[0].substring(0, 11)

            //use substring to remove the decimal on detail output only, for better ui rendering
            val deg = StringBuilder().append(weatherData[1].substring(0, 2)).append('\u00B0')
            dv_degrees!!.text = deg
            val detail = StringBuilder()
                    .append(getString(R.string.feels_like))
                    .append(deg).append(" ").append(weatherData[2])
            dv_weather_detail!!.text = detail
            dv_humidity!!.text = weatherData[3]
            dv_pressure!!.text = weatherData[4]
            Picasso.get().load(weatherData[5]).into(dv_icon)


            //calculate whether to output hot or cold based on degree condition given
            //if temp > 25deg hot and if temp <10 deg cold
            val degrees = weatherData[1].toDouble()
            when {
                degrees > 25 -> {
                    dv_description.setText(R.string.hot)
                }
                degrees < 10 -> {
                    dv_description.setText(R.string.cold)
                }
                else -> {
                    dv_description!!.text = ""
                }
            }

            //daytime,start from the index that outputs time only
            dv_day_time!!.text = weatherData[0].substring(12)
        }
    }


}