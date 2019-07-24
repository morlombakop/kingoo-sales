/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 5:21 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 5:21 PM
 */

package com.morlombakop.kingoosales.features.login

import android.content.Context
import android.content.Intent
import com.morlombakop.kingoosales.core.platform.BaseActivity

class LoginActivity : BaseActivity() {
  companion object {
    fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
  }

  override fun fragment() = LoginFragment()
}