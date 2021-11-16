///**
// * Created by glenc on Nov 2021
// **/
//
//package com.glencconnnect.shumbamoneyweather.retrofit;
//
////using retrofit libray to grab api data serialize the model class that will be assigned the retrieved data
////gonna pass the Class type in (s) required to the buildService function, its a generic function
//
//import android.content.ServiceConnection;
//
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ServiceBuilder {
//    //create retrofit builder instance and call on it the static functions that allow the setting on of base url and
//    // the convertor factor resposnible for transforming the json data into its java object equivalence
//
//    private static Retrofit.Builder retrofit = new Retrofit.Builder()
//            .baseUrl()
//            .addConverterFactory(GsonConverterFactory.create());
//
//    //call build on the retrofit instance when done with the preceding functionality
//    private static Retrofit retrofitBuild = retrofit.build();
//
//    //static and generic method to retrieve data based on the passed model class
//    public static <s> s builderService(Class<s> serviceType){
//        return retrofitBuild.create(serviceType);
//    }
//}
//
//
