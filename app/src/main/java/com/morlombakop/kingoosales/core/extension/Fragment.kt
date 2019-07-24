/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 3:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 3:36 PM
 */

package com.morlombakop.kingoosales.core.extension

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.ViewModelProviders
import com.morlombakop.kingoosales.core.platform.BaseActivity
import com.morlombakop.kingoosales.core.platform.BaseFragment
import kotlinx.android.synthetic.main.base_activity_layout.fragmentContainer

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
  beginTransaction().func().commit()

inline fun <reified T : ViewModel> Fragment.viewModel(factory: Factory, body: T.() -> Unit): T {
  val vm = ViewModelProviders.of(this, factory)[T::class.java]
  vm.body()
  return vm
}

fun BaseFragment.close() = fragmentManager?.popBackStack()

val BaseFragment.viewContainer: View get() = (activity as BaseActivity).fragmentContainer

val BaseFragment.appContext: Context get() = activity?.applicationContext!!