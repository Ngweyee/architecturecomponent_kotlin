package com.tutsplus.code.androidarchitecturecomponents.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.tutsplus.code.androidarchitecturecomponents.models.WeatherMain

@Database( entities = arrayOf(WeatherMain::class), version = 1,exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun weatherDAO(): WeatherDAO
}