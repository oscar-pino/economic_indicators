package com.oscarpino.common.base

enum class BaseResult{
    SUCCESSFUL,
    ERROR
}

class BaseResponse<T>(val payload:T?, val result: BaseResult) {
}