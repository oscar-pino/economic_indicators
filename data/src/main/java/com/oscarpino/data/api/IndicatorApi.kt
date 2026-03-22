package com.oscarpino.data.data

import com.oscarpino.common.Constants
import com.oscarpino.model.IndicatorRemote
import com.oscarpino.model.IndicatorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IndicatorApi {

    @GET(Constants.ALL_INDICATORS)
    suspend fun getAllIndicators(): Response<IndicatorResponse>

    @GET(Constants.INDICATOR_BY_NAME)
    suspend fun getIndicatorByName(@Path("tipo_indicador") indicatorName:String): Response<IndicatorRemote>

    @GET(Constants.INDICATOR_BY_NAME_AND_DATE)
    suspend fun getIndicatorByNameAndDate(@Path("name") indicatorName:String, @Path("date") indicatorDate:String): Response<IndicatorRemote>

    @GET(Constants.INDICATOR_BY_NAME_AND_YEAR)
    suspend fun getIndicatorByNameAndYear(@Path("name") indicatorName:String, @Path("year") indicatorYear:String): Response<IndicatorRemote>

}


