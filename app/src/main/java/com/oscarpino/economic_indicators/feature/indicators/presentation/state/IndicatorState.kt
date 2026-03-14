package com.oscarpino.economic_indicators.feature.indicators.presentation.state

import com.oscarpino.domain.model.Indicator
import javax.inject.Inject


data class IndicatorState(
        val loading: Boolean = false,
        val error: Boolean = false,
        val date:String = "",
        val indicatorList:List<Indicator> = emptyList()
    )
