/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 2:19 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 2:19 PM
 */

package com.morlombakop.kingoosales.core.navigation

import android.content.Context
import android.view.View
import com.morlombakop.kingoosales.MainActivity
import com.morlombakop.kingoosales.features.login.Authenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(private val authenticator: Authenticator)
{
  fun showMain(context: Context) {
    when (authenticator.userLoggedIn()) {
//      true -> showMovies(context)
//      false -> showLogin(context)
    }

//    context.startActivity(MainActivity.callingIntent(context))
  }

  class Extras(val transitionSharedElement: View)
}