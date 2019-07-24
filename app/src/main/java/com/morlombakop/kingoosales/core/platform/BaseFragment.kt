/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 2:30 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 2:30 PM
 */

package com.morlombakop.kingoosales.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.morlombakop.kingoosales.AndroidApplication
import com.morlombakop.kingoosales.R.color
import com.morlombakop.kingoosales.core.di.ApplicationComponent

import com.morlombakop.kingoosales.core.extension.appContext
import com.morlombakop.kingoosales.core.extension.viewContainer
import kotlinx.android.synthetic.main.toolbar.progress
import javax.inject.Inject

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */
abstract class BaseFragment : Fragment() {

  abstract fun layoutId(): Int

  val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
    (activity?.application as AndroidApplication).appComponent
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
    inflater.inflate(layoutId(), container, false)

  open fun onBackPressed() {}

  internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

  internal fun showProgress() = progressStatus(View.VISIBLE)

  internal fun hideProgress() = progressStatus(View.GONE)

  private fun progressStatus(viewStatus: Int) =
    with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }

  internal fun notify(@StringRes message: Int) =
    Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

  internal fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) {
    val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
    snackBar.setAction(actionText) { action.invoke() }
    snackBar.setActionTextColor(
      ContextCompat.getColor(appContext,
      color.colorPrimary))
    snackBar.show()
  }
}
