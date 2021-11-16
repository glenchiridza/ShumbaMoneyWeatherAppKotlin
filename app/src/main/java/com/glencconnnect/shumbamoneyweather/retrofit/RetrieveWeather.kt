/**
 * Created by glenc on Nov 2021
 */
package com.glencconnnect.shumbamoneyweather.retrofit

import com.glencconnnect.shumbamoneyweather.constants.ApiConstants.API_KEY
import com.glencconnnect.shumbamoneyweather.models.OuterContainer
import retrofit2.Call
import retrofit2.http.GET

interface RetrieveWeather {
    //get request, to grab the data from the specified url and gson will match the retained data with the OuterContainer properties
    @get:GET("/data/2.5/forecast?q=Harare&&units=metric&cnt=16&appid=$API_KEY")
    val data: Call<OuterContainer?>?
}