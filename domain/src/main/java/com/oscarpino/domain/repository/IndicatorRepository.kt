package com.oscarpino.domain.repository

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.domain.model.Indicators
import com.oscarpino.domain.model.Indicator

interface IndicatorRepository {

    suspend fun getIndicators(): BaseResponse<Indicators>

    suspend fun getIndicatorByName(name:String): BaseResponse<Indicator>

    suspend fun getIndicatorByNameAndDate(name:String, date:String): BaseResponse<Indicator>

    suspend fun getIndicatorByNameAndYear(name:String, year:String): BaseResponse<Indicator>
}