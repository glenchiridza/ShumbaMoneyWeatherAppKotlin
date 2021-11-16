/**
 * Created by glenc on Nov 2021
 **/
package com.glencconnnect.shumbamoneyweather.models

import com.google.gson.annotations.SerializedName
import java.util.*


class OuterContainer {
    @SerializedName("cod")
    var cod: String? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("cnt")
    var cnt: String? = null

    //the city is an object inside the List, so it will appear in here
    @SerializedName("city")
    var city: City? = null

    @SerializedName("list")
    var list: ArrayList<List>? = null

    override fun toString(): String {
        return "OuterContainer{" +
                "cod='" + cod + '\'' +
                ", message='" + message + '\'' +
                ", cnt='" + cnt + '\'' +
                ", city=" + city +
                ", list=" + list +
                '}'
    }
}
