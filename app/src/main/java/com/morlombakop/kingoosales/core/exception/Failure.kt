/*
 * Created by Mbakop Ngongang Morlo on 7/23/19 4:14 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/23/19 4:14 PM
 */

package com.morlombakop.kingoosales.core.exception

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
  object NetworkConnection : Failure()
  object ServerError : Failure()

  /** * Extend this class for feature specific failures.*/
  abstract class FeatureFailure : Failure()
}
