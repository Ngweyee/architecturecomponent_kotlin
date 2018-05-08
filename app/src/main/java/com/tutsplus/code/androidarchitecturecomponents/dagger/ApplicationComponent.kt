package com.tutsplus.code.androidarchitecturecomponents.dagger

import com.tutsplus.code.androidarchitecturecomponents.App
import com.tutsplus.code.androidarchitecturecomponents.dagger.activities.ActivitiesModule
import com.tutsplus.code.androidarchitecturecomponents.dagger.viewModels.ViewModelsModule

import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class,
        WebModule::class,
        DataModule::class,
        ViewModelsModule::class,
        ActivitiesModule::class
))
interface ApplicationComponent {

    fun inject(app: App)

}
