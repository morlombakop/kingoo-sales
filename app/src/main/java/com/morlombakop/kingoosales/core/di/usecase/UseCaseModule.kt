/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 1:55 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 1:55 PM
 */

package com.morlombakop.kingoosales.core.di.usecase

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Named
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class UseCaseModule {

  @Named("UseCaseScope")
  @Provides
  @Singleton
  fun provideCoroutineScope(): CoroutineScope = object : CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
      get() = job + Dispatchers.IO

  }

  @Named("UseCaseDispatcher")
  @Provides
  @Singleton
  fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main
}