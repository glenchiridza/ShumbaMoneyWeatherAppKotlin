package com.glencconnnect.shumbamoneyweather

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.glencconnnect.shumbamoneyweather.R
import com.glencconnnect.shumbamoneyweather.adapters.WeatherRecyclerAdapter
import com.glencconnnect.shumbamoneyweather.models.OuterContainer
import com.glencconnnect.shumbamoneyweather.retrofit.RetrieveWeather
import com.glencconnnect.shumbamoneyweather.retrofit.ServiceBuilder
import com.glencconnnect.shumbamoneyweather.ui.AboutActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var adapter: WeatherRecyclerAdapter? = null

    private var weatherList: ArrayList<com.glencconnnect.shumbamoneyweather.models.List>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        weatherList = ArrayList<com.glencconnnect.shumbamoneyweather.models.List>()
        adapter = WeatherRecyclerAdapter(this, weatherList!!)
        val manager = LinearLayoutManager(this)
        recycler_view.layoutManager = manager
        recycler_view.adapter = adapter
        recycler_view.setHasFixedSize(true)
        progressing.visibility = View.VISIBLE
        fab.setOnClickListener(View.OnClickListener { view: View? -> shareIntent() })


        //called on create
        retrieveWeatherData()

        //click fab to refresh, to try retrieve again if failed on oncreate first view
        fab_refresh.setOnClickListener(View.OnClickListener {
            progressing.visibility = View.VISIBLE
            textView.visibility = View.GONE
            retrieveWeatherData()
        })
    }

    private fun retrieveWeatherData() {
        val retrieveWeather: RetrieveWeather = ServiceBuilder.builderService(RetrieveWeather::class.java)

        retrieveWeather.data?.enqueue(object : Callback<OuterContainer?> {
            override fun onResponse(call: Call<OuterContainer?>, response: Response<OuterContainer?>) {
                progressing?.visibility = View.GONE
                fab_refresh?.visibility = View.GONE
                textView?.visibility = View.GONE
                shumba_img?.visibility = View.GONE
                if (response.isSuccessful) {
                    val listing: OuterContainer? = response.body()
                    val list: ArrayList<com.glencconnnect.shumbamoneyweather.models.List> = listing!!.getList()
                    weatherList = list
                    adapter?.setDataListing(weatherList!!)
                }
            }

            override fun onFailure(call: Call<OuterContainer?>, t: Throwable) {
                progressing?.visibility = View.GONE
                shumba_img?.visibility = View.VISIBLE
                fab_refresh?.visibility = View.VISIBLE
                //the default error value in textview will be retained here from layout string resource, if no response
                textView?.visibility = View.VISIBLE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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

    companion object {
        var CHOICE_EXTRA = "CHOICE_EXTRA"
    }
}