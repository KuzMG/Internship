package com.example.internship2025.di

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.internship2025.di.module.ViewModelModule
import com.example.internship2025.viewmodel.MultiViewModelFactory
import com.example.core.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    val multiViewModelFactory: MultiViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): AppComponent
    }
}