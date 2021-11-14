package com.glencconnnect.shumbamoneyweather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glencconnnect.shumbamoneyweather.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    private fun switchThroughViewText(action: String) {
        when (action) {
            "action_about" -> {
                abt_title.text = getString(R.string.shumba_money_weather)
                abt_description.text = getString(R.string.about_text)
            }
            "action_credits" -> {
                abt_title.text = getString(R.string.andro_version)
                abt_description.text = getString(R.string.developer_info)
            }
            else -> {
                //do nothing, show the template view default set information
            }
        }
    }
}