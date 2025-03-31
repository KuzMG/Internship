package com.example.internship2025.di
import android.app.Application
import com.example.internship2025.di.module.ServiceModule
import com.example.internship2025.di.module.ViewModelModule
import com.example.internship2025.viewmodel.MultiViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, ServiceModule::class])
interface AppComponent {
    val multiViewModelFactory: MultiViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}