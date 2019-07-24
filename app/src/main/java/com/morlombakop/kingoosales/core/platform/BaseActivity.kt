/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 2:52 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 2:52 PM
 */

package com.morlombakop.kingoosales.core.platform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morlombakop.kingoosales.R.id
import com.morlombakop.kingoosales.R.layout
import com.morlombakop.kingoosales.core.extension.inTransaction
import kotlinx.android.synthetic.main.toolbar.toolbar

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.base_activity_layout)

    setSupportActionBar(toolbar)
    addFragment(savedInstanceState)
  }

  override fun onBackPressed() {
    (supportFragmentManager.findFragmentById(
      id.fragmentContainer) as BaseFragment).onBackPressed()
    super.onBackPressed()
  }

  private fun addFragment(savedInstanceState: Bundle?) =
    savedInstanceState ?: supportFragmentManager.inTransaction { add(
      id.fragmentContainer, fragment()) }

  abstract fun fragment(): BaseFragment
}
