package com.glencconnnect.shumbamoneyweather

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.glencconnnect.shumbamoneyweather.adapters.WeatherRecyclerAdapter
import com.glencconnnect.shumbamoneyweather.models.OuterContainer
import com.glencconnnect.shumbamoneyweather.retrofit.RetrieveWeather
import com.glencconnnect.shumbamoneyweather.retrofit.ServiceBuilder
import com.glencconnnect.shumbamoneyweather.ui.AboutActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter:WeatherRecyclerAdapter
    companion object {const val CHOICE_EXTRA = "CHOICE_EXTRA"}

    private var weatherList: List<OuterContainer>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        weatherList = ArrayList()
        //setup recycler view
        adapter = weatherList?.let { WeatherRecyclerAdapter(this, it) }!!

        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
        recycler_view.setHasFixedSize(true)

        fab.setOnClickListener {
            shareIntent()
        }


        var retrieveWeather: RetrieveWeather = ServiceBuilder.builderService(RetrieveWeather::class.java)



        retrieveWeather.data?.enqueue(
                object : Callback<OuterContainer?> {
                    override fun onResponse(call: Call<OuterContainer?>, response: Response<OuterContainer?>) {

                        //textView.setText(response.body().toString());
                        if (response.isSuccessful) {
                            weatherList = response.body() as List<OuterContainer>?
                            adapter.setDataListing(weatherList)
                        }
                    }

                    override fun onFailure(call: Call<OuterContainer?>, t: Throwable) {


                        Toast.makeText(this@MainActivity, t.message + "-----" + t.cause, Toast.LENGTH_SHORT).show()
                    }
                })

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