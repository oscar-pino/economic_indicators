package com.oscarpino.economic_indicators.feature.indicators.presentation.intent

sealed interface IndicatorIntent {

    data object GetIndicatorsIntent: IndicatorIntent
    data class GetIndicatorByIndicatorName(val indicatorName:String): IndicatorIntent

}