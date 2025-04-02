package com.example.core.di

import android.app.Application
import com.example.core.di.module.DBModule
import com.example.core.di.module.ServiceModule
import com.example.core.repository.InternshipRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, DBModule::class])
interface CoreComponent {


    val repository: InternshipRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}