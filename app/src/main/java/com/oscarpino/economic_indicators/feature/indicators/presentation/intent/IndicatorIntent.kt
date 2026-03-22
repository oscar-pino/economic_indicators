package com.oscarpino.economic_indicators.feature.indicators.presentation.intent

sealed interface IndicatorIntent {

    data object GetIndicatorsIntent: IndicatorIntent
    data class GetIndicatorByName(val name:String): IndicatorIntent
    data class GetIndicatorByNameAndDate(val indicatorName:String, val indicatorDate:String): IndicatorIntent
    data class GetIndicatorByNameAndYear(val indicatorName:String, val indicatorYear:String): IndicatorIntent

}