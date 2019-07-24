/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 2:07 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 2:07 PM
 */

package com.morlombakop.kingoosales.core.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.morlombakop.kingoosales.AndroidApplication
import com.morlombakop.kingoosales.core.di.ApplicationComponent
import javax.inject.Inject

class RouteActivity : AppCompatActivity() {

  private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
    (application as AndroidApplication).appComponent
  }

  @Inject
  internal lateinit var navigator: Navigator

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    appComponent.inject(this)
    navigator.showMain(this)
  }
}
