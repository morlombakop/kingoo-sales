/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 1:56 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 1:56 PM
 */

package com.morlombakop.kingoosales.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Suppress("UNCHECKED_CAST")
class ViewModelFactory
@Inject constructor(
  private val creators: Map<Class<out ViewModel>,
      @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val creator =
      creators[modelClass] ?: creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
      ?: throw IllegalArgumentException("Unknown ViewModel class $modelClass")

    return try {
      creator.get() as T
    } catch (e: Exception) {
      throw RuntimeException(e)
    }
  }
}