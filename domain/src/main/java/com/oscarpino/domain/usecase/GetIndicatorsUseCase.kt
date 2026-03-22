package com.oscarpino.domain.usecase

import com.oscarpino.common.base.BaseResponse
import com.oscarpino.common.base.BaseUseCase
import com.oscarpino.domain.model.Indicators
import com.oscarpino.domain.repository.IndicatorRepository
import javax.inject.Inject

class GetIndicatorsUseCase @Inject constructor(
    private val repository: IndicatorRepository
) : BaseUseCase<BaseResponse<Indicators>>() {

    override suspend fun execute(): BaseResponse<Indicators> {
        return repository.getIndicators()
    }
}