/**
 * Created by glenc on Nov 2021
 */
package com.glencconnnect.shumbamoneyweather.models

import com.google.gson.annotations.SerializedName
import java.util.*

class List(@field:SerializedName("dt") var dt: Long, @field:SerializedName("sunrise") var sunrise: Long, @field:SerializedName("sunset") var sunset: Long, main: Main, weather: ArrayList<Weather>, dt_txt: String) {

    //the temperature is an object inside the List, so it will appear in here, which in itself contains a list of items
    @SerializedName("main")
    private var main: Main

    //the Weather is an object inside the List, so it will appear in here, which in itself contains a list of items
    @SerializedName("weather")
    var weather: ArrayList<Weather>

    @SerializedName("dt_txt")
    var dt_txt: String

    fun getMain(): Main {
        return main
    }

    fun setMain(main: Main) {
        this.main = main
    }

    override fun toString(): String {
        return "List{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", main=" + main +
                ", weather=" + weather +
                ", dt_txt='" + dt_txt + '\'' +
                '}'
    }

    init {
        this.main = main
        this.weather = weather
        this.dt_txt = dt_txt
    }
}