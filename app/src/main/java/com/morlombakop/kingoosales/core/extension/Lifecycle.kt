/*
 * Created by Mbakop Ngongang Morlo on 7/23/19 4:21 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/23/19 4:21 PM
 */

package com.morlombakop.kingoosales.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.morlombakop.kingoosales.core.exception.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
  liveData.observe(this, Observer(body))

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) =
  liveData.observe(this, Observer(body))