package com.glencconnnect.shumbamoneyweather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glencconnnect.shumbamoneyweather.MainActivity
import com.glencconnnect.shumbamoneyweather.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        //get intent extra and customize activity output
        val action = intent.getStringExtra(MainActivity.CHOICE_EXTRA)
        action?.let { switchThroughViewText(it) }
    }

    private fun switchThroughViewText(action: String) {
        when (action) {
            //custom staff for the about section
            "action_about" -> {
                abt_title.text = getString(R.string.shumba_money_weather)
                abt_description.text = getString(R.string.about_text)
            }
            //custom staff for the credits section
            "action_credits" -> {
                abt_title.text = getString(R.string.andro_version)
                abt_description.text = getString(R.string.developer_info)
            }
        }
    }
}