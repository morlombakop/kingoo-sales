/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 1:00 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 1:00 PM
 */

package com.morlombakop.kingoosales.core.di

import android.content.Context
import com.morlombakop.kingoosales.AndroidApplication
import com.morlombakop.kingoosales.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {

  @Provides
  @Singleton
  fun provideApplicationContext(): Context = application

  @Provides
  @Singleton
  fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        // ToDo set your own base url here
      .baseUrl("https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture-Kotlin/")
      .client(createClient())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  private fun createClient(): OkHttpClient {
    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
      val loggingInterceptor = HttpLoggingInterceptor()
      okHttpClientBuilder.addInterceptor(loggingInterceptor)
    }
    return okHttpClientBuilder.build()
  }

//  @Provides
//  @Singleton
//  fun provideMoviesRepository(dataSource: MoviesRepository.Network): MoviesRepository = dataSource

}