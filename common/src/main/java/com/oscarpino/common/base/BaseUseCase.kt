package com.oscarpino.common.base

abstract class BaseUseCase<R> {
    abstract suspend fun execute(): R
}

abstract class BaseUseCaseWithParam<P,R> {
    abstract suspend fun execute(params:P): R
}

abstract class BaseUseCaseWithParams<P, Q, R> {
    abstract suspend fun execute(param1:P, param2:Q): R

}