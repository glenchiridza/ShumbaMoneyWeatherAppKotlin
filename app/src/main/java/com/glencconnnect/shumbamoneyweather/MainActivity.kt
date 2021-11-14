package com.glencconnnect.shumbamoneyweather

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.glencconnnect.shumbamoneyweather.adapters.WeatherRecyclerAdapter
import com.glencconnnect.shumbamoneyweather.ui.AboutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter:WeatherRecyclerAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup recycler view
        adapter = WeatherRecyclerAdapter(this)

        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
        recycler_view.setHasFixedSize(true)
    }

    private fun shareIntent() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        startActivity(Intent.createChooser(shareIntent, "Share App"))
    }

    private fun retrieveCredits() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}