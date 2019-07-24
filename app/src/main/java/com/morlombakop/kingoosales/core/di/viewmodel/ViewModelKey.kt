/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 2:00 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 2:00 PM
 */

package com.morlombakop.kingoosales.core.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)