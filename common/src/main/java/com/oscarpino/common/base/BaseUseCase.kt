package com.oscarpino.common.base

abstract class BaseUseCase<R> {
    abstract suspend fun execute(): BaseResponse<R>
}

abstract class BaseUseCaseWithParam<P,R>(){
    abstract suspend fun execute(params:P):BaseResponse<R>

}