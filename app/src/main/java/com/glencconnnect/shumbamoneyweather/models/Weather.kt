/**
 * Created by glenc on Nov 2021
 */
package com.glencconnnect.shumbamoneyweather.models

import com.google.gson.annotations.SerializedName

class Weather(@field:SerializedName("description") var description: String, @field:SerializedName("icon") var icon: String) {

    override fun toString(): String {
        return "Weather{" +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}'
    }
}