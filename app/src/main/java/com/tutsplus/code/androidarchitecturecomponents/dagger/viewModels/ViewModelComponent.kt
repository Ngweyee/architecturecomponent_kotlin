package com.tutsplus.code.androidarchitecturecomponents.dagger.viewModels

import com.tutsplus.code.androidarchitecturecomponents.MainViewModel
import com.tutsplus.code.androidarchitecturecomponents.dagger.viewModels.ViewModelsModule
import dagger.Component

@Component( modules = arrayOf(
        ViewModelsModule::class
))
interface ViewModelComponent {

    fun inject( mainViewModel: MainViewModel)

}