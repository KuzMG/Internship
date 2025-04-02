package com.example.internship2025.di.module

import androidx.lifecycle.ViewModel
import com.example.internship2025.ui.auth.AuthViewModel
import com.example.internship2025.ui.main_screen.favorites.FavoritesViewModel
import com.example.internship2025.ui.main_screen.home.HomeViewModel
import com.example.internship2025.ui.splash_screen.SplashScreenViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface ViewModelModule {
    @[Binds IntoMap ViewModelKey(SplashScreenViewModel::class)]
    fun provideSplashScreenViewModel(splashScreenViewModel: SplashScreenViewModel): ViewModel

    @[Binds IntoMap ViewModelKey(AuthViewModel::class)]
    fun provideAuthViewModel(authViewModel: AuthViewModel): ViewModel

    @[Binds IntoMap ViewModelKey(HomeViewModel::class)]
    fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @[Binds IntoMap ViewModelKey(FavoritesViewModel::class)]
    fun provideFavoritesViewModel(favoritesViewModel: FavoritesViewModel): ViewModel
}


@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)