package com.tutsplus.code.androidarchitecturecomponents.dagger

import android.arch.persistence.room.Room
import android.content.Context
import com.tutsplus.code.androidarchitecturecomponents.R
import com.tutsplus.code.androidarchitecturecomponents.data.Database
import com.tutsplus.code.androidarchitecturecomponents.data.PrefsDAO
import com.tutsplus.code.androidarchitecturecomponents.data.WeatherDAO
import com.tutsplus.code.androidarchitecturecomponents.web.ErrorUtils
import com.tutsplus.code.androidarchitecturecomponents.web.LiveDataCallAdapterFactory
import com.tutsplus.code.androidarchitecturecomponents.web.OpenWeatherApi
import com.tutsplus.code.androidarchitecturecomponents.web.OpenWeatherService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module class WebModule( appContext: Context ) {

    var openWeatherID: String = appContext.getString(R.string.openWeather)

    @Provides
    @Singleton
    fun providerOpenWeatherID(): String {
        return openWeatherID
    }

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    fun providesErrorUtil( retrofit: Retrofit ) : ErrorUtils {
        return ErrorUtils( retrofit )
    }

    @Provides
    @Singleton
    fun providesOpenWeatherApi( retrofit: Retrofit ) : OpenWeatherApi {
        return retrofit.create( OpenWeatherApi::class.java )
    }

    @Provides
    @Singleton
    fun providesOpenWeatherService(
            api: OpenWeatherApi,
            errorUtils: ErrorUtils,
            openWeatherId: String,
            prefsDAO: PrefsDAO
    ) : OpenWeatherService {
        return OpenWeatherService( api, errorUtils, openWeatherId, prefsDAO )
    }

}