package com.tutsplus.code.androidarchitecturecomponents

import android.app.Activity
import android.app.Application
import com.tutsplus.code.androidarchitecturecomponents.dagger.ApplicationModule
import com.tutsplus.code.androidarchitecturecomponents.dagger.DaggerApplicationComponent
import com.tutsplus.code.androidarchitecturecomponents.dagger.DataModule
import com.tutsplus.code.androidarchitecturecomponents.dagger.WebModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .webModule(WebModule(this))
                .dataModule(DataModule(this))
                .build()
                .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}