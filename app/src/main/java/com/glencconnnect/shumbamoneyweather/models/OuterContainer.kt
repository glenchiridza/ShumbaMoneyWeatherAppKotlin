/**
 * Created by glenc on Nov 2021
 */
package com.glencconnnect.shumbamoneyweather.models

import com.google.gson.annotations.SerializedName
import java.util.*

class OuterContainer(list: ArrayList<List>) {

    @SerializedName("list")
    private var list: ArrayList<List>
    fun getList(): ArrayList<List> {
        return list
    }

    fun setList(list: ArrayList<List>) {
        this.list = list
    }

    init {
        this.list = list
    }
}