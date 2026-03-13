package repository

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.domain.model.Indicators

interface IndicatorRepository {

    suspend fun getIndicators(): BaseResponse<Indicators>
}