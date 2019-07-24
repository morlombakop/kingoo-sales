/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 3:44 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 3:44 PM
 */

package com.morlombakop.kingoosales.core.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.morlombakop.kingoosales.core.exception.Failure

/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */
abstract class BaseViewModel : ViewModel() {

  var failure: MutableLiveData<Failure> = MutableLiveData()

  protected fun handleFailure(failure: Failure) {
    this.failure.value = failure
  }
}
