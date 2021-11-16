/**
 * Created by glenc on Nov 2021
 **/
package com.glencconnnect.shumbamoneyweather.models

import com.google.gson.annotations.SerializedName


class City(@field:SerializedName("name") var name: String, @field:SerializedName("country") var country: String) {

    override fun toString(): String {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}'
    }
}
