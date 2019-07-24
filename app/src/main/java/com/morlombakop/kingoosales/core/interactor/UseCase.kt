/*
 * Created by Mbakop Ngongang Morlo on 7/24/19 5:13 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 7/24/19 5:13 PM
 */

package com.morlombakop.kingoosales.core.interactor

import com.morlombakop.kingoosales.core.exception.Failure
import com.morlombakop.kingoosales.core.functional.Either
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out Type, in Params>(private val scope: CoroutineScope,
                                            private val dispatcher: CoroutineDispatcher
)
    where Type : Any {

  abstract suspend fun run(params: Params): Either<Failure, Type>

  operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
    scope.launch {
      val result = run(params)

      withContext(dispatcher) {
        onResult(result)
      }

    }
  }

  class None
}