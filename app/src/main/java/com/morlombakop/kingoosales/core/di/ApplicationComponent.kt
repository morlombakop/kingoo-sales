/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 12:46 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 12:46 PM
 */

package com.morlombakop.kingoosales.core.di

import com.morlombakop.kingoosales.AndroidApplication
import com.morlombakop.kingoosales.core.navigation.RouteActivity
//import com.fernandocejas.sample.core.di.usecase.UseCaseModule
//import com.fernandocejas.sample.core.di.viewmodel.ViewModelModule
//import com.fernandocejas.sample.features.movies.MovieDetailsFragment
//import com.fernandocejas.sample.features.movies.MoviesFragment
//import com.fernandocejas.sample.core.navigation.RouteActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
  fun inject(application: AndroidApplication)

  fun inject(routeActivity: RouteActivity)
//
//  fun inject(moviesFragment: MoviesFragment)
//  fun inject(movieDetailsFragment: MovieDetailsFragment)
}