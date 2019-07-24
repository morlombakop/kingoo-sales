/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 5:16 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 5:16 PM
 */

package com.morlombakop.kingoosales.features.login

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator
@Inject constructor(){
  //Learning purpose: We assume the user is always logged in
  //Here you should put your own logic to return whether the user
  //is authenticated or not
  fun userLoggedIn() = true
}
