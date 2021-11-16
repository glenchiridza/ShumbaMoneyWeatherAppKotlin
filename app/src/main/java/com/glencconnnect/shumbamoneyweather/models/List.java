/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneyweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class List {

    @SerializedName("dt")
    private Long dt;

    @SerializedName("sunrise")
    private Long sunrise;

    @SerializedName("sunset")
    private Long sunset;

    //the temperature is an object inside the List, so it will appear in here, which in itself contains a list of items
    @SerializedName("main")
    private com.glencconnnect.shumbamoneweather.models.Main main;

    //the Weather is an object inside the List, so it will appear in here, which in itself contains a list of items
    @SerializedName("weather")
    private ArrayList<com.glencconnnect.shumbamoneweather.models.Weather> weather;

    @SerializedName("dt_txt")
    private String dt_txt;

    public List(Long dt, Long sunrise, Long sunset, com.glencconnnect.shumbamoneweather.models.Main main, ArrayList<com.glencconnnect.shumbamoneweather.models.Weather> weather, String dt_txt) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.main = main;
        this.weather = weather;
        this.dt_txt = dt_txt;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public com.glencconnnect.shumbamoneweather.models.Main getMain() {
        return main;
    }

    public void setMain(com.glencconnnect.shumbamoneweather.models.Main main) {
        this.main = main;
    }

    public ArrayList<com.glencconnnect.shumbamoneweather.models.Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<com.glencconnnect.shumbamoneweather.models.Weather> weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "List{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", main=" + main +
                ", weather=" + weather +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}


