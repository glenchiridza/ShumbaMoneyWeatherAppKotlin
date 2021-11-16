package com.glencconnnect.shumbamoneyweather.models


import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import java.util.*


class OuterContainerTest {
    companion object {
        private var list: ArrayList<List>? = null
        private var container: OuterContainer? = null
        private var main: Main? = null
        private var weatherList: ArrayList<Weather?>? = null
        private var weather: Weather? = null
        private var listResult: String? = null
        private var weatherResult: String? = null

        @BeforeClass
        fun setupTest() {
            main = Main(25.24, 44, 43)
            weather = Weather("cloudy sky", "Ond")
            weatherList = ArrayList<Weather?>()
            weatherList!!.add(weather)
            val myList = List(100112L, 588366104L, 34303043L, main!!, weatherList, "11-23-21")
            list = ArrayList<List>()
            list!!.add(myList)
            container = OuterContainer(list!!)
        }
    }


    @Test
    fun checkResult() {
        //arrange
        setupTest()
        val retrievedWeather = weatherResult
        val retrievedList = listResult


        //assert
        Assert.assertNotNull(main)
        Assert.assertNotNull(Companion.weather)
        Assert.assertNotNull(container)

    }


}