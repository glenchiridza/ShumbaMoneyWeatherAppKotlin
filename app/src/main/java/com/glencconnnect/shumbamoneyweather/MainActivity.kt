package com.glencconnnect.shumbamoneyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glencconnnect.shumbamoneyweather.adapters.WeatherRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter:WeatherRecyclerAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup recycler view
        adapter = WeatherRecyclerAdapter(this)

        recycler_view.
    }
}