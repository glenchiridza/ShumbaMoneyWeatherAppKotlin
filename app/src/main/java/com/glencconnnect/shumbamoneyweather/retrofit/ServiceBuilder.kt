/**
 * Created by glenc on Nov 2021
 */
package com.glencconnnect.shumbamoneyweather.retrofit
import com.glencconnnect.shumbamoneyweather.constants.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//using retrofit libray to grab api data serialize the model class that will be assigned the retrieved data
//gonna pass the Class type in (s) required to the buildService function, its a generic function

object ServiceBuilder {
    //create retrofit builder instance and call on it the static functions that allow the setting on of base url and
    // the convertor factor resposnible for transforming the json data into its java object equivalence
    private val retrofit: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    //call build on the retrofit instance when done with the preceding functionality
    private val retrofitBuild = retrofit.build()

    //static and generic method to retrieve data based on the passed model class
    fun <s> builderService(serviceType: Class<s>?): s {
        return retrofitBuild.create(serviceType)
    }
}