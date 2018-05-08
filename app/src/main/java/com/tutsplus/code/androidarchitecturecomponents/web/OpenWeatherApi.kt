package com.tutsplus.code.androidarchitecturecomponents.web

import android.arch.lifecycle.LiveData
import com.tutsplus.code.androidarchitecturecomponents.models.ApiResponse
import com.tutsplus.code.androidarchitecturecomponents.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface OpenWeatherApi {



    // Get Today's Weather by City
    @GET("weather")
    fun cityWeatherLive(
            @Query("APPID") appId: String,
            @Query("q") city: String,
            @Query("units") unit: String )
            : LiveData<ApiResponse<WeatherResponse>>

    // Get Today's Weather by Location
    @GET("weather")
    fun cityWeatherByLocationLive(
            @Query("APPID") appId: String,
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("units") unit: String ) : LiveData<ApiResponse<WeatherResponse>>


}