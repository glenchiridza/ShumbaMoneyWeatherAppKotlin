/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneyweather.models;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;


    public Weather(String description, String icon) {
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}


