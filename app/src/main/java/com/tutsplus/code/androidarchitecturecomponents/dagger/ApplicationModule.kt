package com.tutsplus.code.androidarchitecturecomponents.dagger

import android.content.Context
import android.content.SharedPreferences
import com.tutsplus.code.androidarchitecturecomponents.App

import com.tutsplus.code.androidarchitecturecomponents.dagger.ForApplication

import javax.inject.Singleton

import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(internal var app: App) {

    @Provides
    @Singleton
    fun application(): App {
        return app
    }

    @Provides
    @ForApplication
    @Singleton
    fun context(): Context {
        return app
    }
}
