/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 12:55 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 12:55 PM
 */

package com.morlombakop.kingoosales

import android.app.Application
import com.morlombakop.kingoosales.core.di.ApplicationComponent
import com.morlombakop.kingoosales.core.di.ApplicationModule
import com.morlombakop.kingoosales.core.di.DaggerApplicationComponent
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {

  val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
    DaggerApplicationComponent
      .builder()
      .applicationModule(ApplicationModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    this.injectMembers()
    this.initializeLeakDetection()
  }

  private fun injectMembers() = appComponent.inject(this)

  private fun initializeLeakDetection() {
    if (BuildConfig.DEBUG) LeakCanary.install(this)
  }
}
