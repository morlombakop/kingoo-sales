/*
 * Created by Mbakop Ngongang Morlo on 7/23/19 4:16 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/23/19 4:16 PM
 */

package com.morlombakop.kingoosales.core.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

// ToDo remove depreciated class.
val Context.networkInfo: NetworkInfo?
  get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
