/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneyweather.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glencconnnect.shumbamoneweather.R;
import com.glencconnnect.shumbamoneweather.ui.DetailView;

public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.MyViewHolder> {

    private Context context;
    public WeatherRecyclerAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the list_item layout for display using viewholder, attach to root is false coz when oncreateview is called,
        // the layout is attached to view automatically then, so no need to attach again
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //bind the view elements , use holder to access the views and set their representational data from the data received from api

        holder.wCity.setText("Harare");
        holder.wDate.setText("Tuesday 11/11/21");
        holder.wWeather.setText("Partly Cloudy");
        holder.wDegrees.setText("24 Degrees");

        holder.itemView.setOnClickListener(view->{
            context.startActivity(new Intent(context, DetailView.class));
        });
    }


    @Override
    public int getItemCount() {

        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView wDate;
        private TextView wCity;
        private TextView wDegrees;
        private TextView wWeather;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            wDate = itemView.findViewById(R.id.txt_date);
            wCity = itemView.findViewById(R.id.txt_city);
            wDegrees = itemView.findViewById(R.id.txt_degrees);
            wWeather = itemView.findViewById(R.id.txt_weather);
        }
    }
}


