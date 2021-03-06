package com.tutsplus.code.androidarchitecturecomponents.dagger

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.tutsplus.code.androidarchitecturecomponents.data.Database
import com.tutsplus.code.androidarchitecturecomponents.data.LocationLiveData
import com.tutsplus.code.androidarchitecturecomponents.data.PrefsDAO
import com.tutsplus.code.androidarchitecturecomponents.data.WeatherDAO
import com.tutsplus.code.androidarchitecturecomponents.repository.MainRepository
import com.tutsplus.code.androidarchitecturecomponents.web.OpenWeatherService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule( val context: Context ) {

    @Provides
    @Singleton
    fun accountPrefs(): SharedPreferences {
        return context.getSharedPreferences( "accountSharedPrefs", Context.MODE_PRIVATE )
    }


    @Provides
    @Singleton
    fun providesPrefsDAO(
            sharedPreferences: SharedPreferences
    ) : PrefsDAO {
        return PrefsDAO( sharedPreferences )
    }

    @Provides
    @Singleton
    fun providesLocationData(
    ) : LocationLiveData {
        return LocationLiveData( context )
    }

    @Provides
    @Singleton
    fun providesMainRepository(
            openWeatherService: OpenWeatherService,
            prefsDAO: PrefsDAO,
            weatherDAO: WeatherDAO,
            locationLiveData: LocationLiveData
    ) : MainRepository {
        return MainRepository(
                openWeatherService,
                prefsDAO,
                weatherDAO,
                locationLiveData
        )
    }

    @Provides
    @Singleton
    fun providesAppDatabase() : Database {
        return Room.databaseBuilder(
                context, Database::class.java, "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }

    @Provides
    @Singleton
    fun providesWeatherDAO(database: Database) : WeatherDAO {
        return database.weatherDAO()
    }

}