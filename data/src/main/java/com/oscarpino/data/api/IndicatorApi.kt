package com.oscarpino.data.data

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.common.Constants
import com.oscarpino.model.IndicatorResponse
import retrofit2.Response
import retrofit2.http.GET

interface IndicatorApi {

    @GET(Constants.ALL_INDICATORS)
    suspend fun getAllIndicators(): Response<IndicatorResponse>
}