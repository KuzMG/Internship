package com.example.core.di.module

import com.example.core.service.api.InternshipApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ServiceModule {
    @Singleton
    @Provides
    fun provideInternshipApi() = Retrofit
        .Builder()
        .baseUrl(InternshipApi.URL)
        .client(OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(InternshipApi::class.java)
}