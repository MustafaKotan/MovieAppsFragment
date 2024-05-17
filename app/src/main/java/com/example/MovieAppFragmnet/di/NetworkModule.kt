package com.example.MovieAppFragmnet.di

import com.example.MovieAppFragmnet.data.apiservice.TMDBApiService
import com.example.MovieAppFragmnet.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<TMDBApiService> {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.URL)
            .client(okHttpClient)
            .build()

        retrofit.create(TMDBApiService::class.java)
    }
}
