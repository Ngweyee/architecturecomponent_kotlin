package com.tutsplus.code.androidarchitecturecomponents.dagger.activities

import com.tutsplus.code.androidarchitecturecomponents.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module( subcomponents = arrayOf(
        MainActivitySubComponent::class
))
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun providesMainActivity(): MainActivity

}