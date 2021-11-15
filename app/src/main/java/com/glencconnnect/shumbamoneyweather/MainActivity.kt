package com.glencconnnect.shumbamoneyweather

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.glencconnnect.shumbamoneyweather.adapters.WeatherRecyclerAdapter
import com.glencconnnect.shumbamoneyweather.ui.AboutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter:WeatherRecyclerAdapter
    companion object {const val CHOICE_EXTRA = "CHOICE_EXTRA"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup recycler view
        adapter = WeatherRecyclerAdapter(this)

        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
        recycler_view.setHasFixedSize(true)

        fab.setOnClickListener {
            shareIntent()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_about) {
            retrieveInfo("action_about")
        } else if (id == R.id.action_credits) {
            retrieveInfo("action_credits")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareIntent() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.extra_share_app_text))
        startActivity(Intent.createChooser(shareIntent, "Share With"))
    }


    //retrieve information on about and credits, pass in the extras depending on the chosen option and dynamicaly populate that single activity with the right data
    //simply reusing the same AboutActiivty for two different options
    private fun retrieveInfo(choice_extra: String) {
        val intent = Intent(this, AboutActivity::class.java)
        intent.putExtra(CHOICE_EXTRA, choice_extra)
        startActivity(intent)
    }
}