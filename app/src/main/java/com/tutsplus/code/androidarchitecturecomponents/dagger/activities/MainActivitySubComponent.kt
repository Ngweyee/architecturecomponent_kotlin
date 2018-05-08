package com.tutsplus.code.androidarchitecturecomponents.dagger.activities

import com.tutsplus.code.androidarchitecturecomponents.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class builder : AndroidInjector.Builder<MainActivity>()

}