/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 3:50 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 3:50 PM
 */

package com.morlombakop.kingoosales.core.platform

import android.content.Context
import com.morlombakop.kingoosales.core.extension.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Injectable class which returns information about the network connection state.
 */
@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
  // Todo remove depreciated code.
  val isConnected get() = context.networkInfo?.isConnectedOrConnecting
}
