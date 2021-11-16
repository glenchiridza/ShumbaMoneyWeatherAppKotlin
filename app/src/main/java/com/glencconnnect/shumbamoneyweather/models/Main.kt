/**
 * Created by glenc on Nov 2021
 **/
package com.glencconnnect.shumbamoneyweather.models

class Main(var temp: Double, var pressure: Int, var humidity: Int) {

    override fun toString(): String {
        return "Main{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}'
    }
}


