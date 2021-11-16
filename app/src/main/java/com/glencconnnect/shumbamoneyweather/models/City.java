/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneyweather.models;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


