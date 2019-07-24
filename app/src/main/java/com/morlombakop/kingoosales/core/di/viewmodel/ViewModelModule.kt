/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 2:03 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 2:03 PM
 */

package com.morlombakop.kingoosales.core.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//  @Binds
//  @IntoMap
//  @ViewModelKey(MoviesViewModel::class)
//  abstract fun bindsMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel
//
//  @Binds
//  @IntoMap
//  @ViewModelKey(MovieDetailsViewModel::class)
//  abstract fun bindsMovieDetailsViewModel(movieDetailsViewModel: MovieDetailsViewModel): ViewModel
}