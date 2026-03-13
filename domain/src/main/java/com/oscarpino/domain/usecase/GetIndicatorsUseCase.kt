package com.oscarpino.domain.usecase

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.domain.model.Indicators
import repository.IndicatorRepository
import javax.inject.Inject

class GetIndicatorsUseCase @Inject constructor( val repository: IndicatorRepository) {

        suspend fun execute(): BaseResponse<Indicators> {
            return repository.getIndicators()
        }
}