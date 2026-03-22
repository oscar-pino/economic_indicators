package com.oscarpino.economic_indicators.feature.indicators.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.oscarpino.common.base.BaseResult
import com.oscarpino.common.base.BaseViewModel
import com.oscarpino.domain.model.Indicator
import com.oscarpino.domain.model.Indicators
import com.oscarpino.domain.usecase.GetIndicatorByName
import com.oscarpino.domain.usecase.GetIndicatorByNameAndDate
import com.oscarpino.domain.usecase.GetIndicatorByNameAndYear
import com.oscarpino.domain.usecase.GetIndicatorsUseCase
import com.oscarpino.economic_indicators.feature.indicators.presentation.intent.IndicatorIntent

import com.oscarpino.economic_indicators.feature.indicators.presentation.intent.IndicatorIntent.GetIndicatorsIntent
import com.oscarpino.economic_indicators.feature.indicators.presentation.state.IndicatorState
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IndicatorViewModel @Inject constructor(
    val getIndicatorsUseCase: GetIndicatorsUseCase,
    val getIndicatorByName: GetIndicatorByName,
    val getIndicatorByNameAndDate: GetIndicatorByNameAndDate,
    val getIndicatorByNameAndYear: GetIndicatorByNameAndYear
) :
    BaseViewModel<IndicatorState, IndicatorIntent>(IndicatorState()) {

    override fun sendIntent(intent: IndicatorIntent) {
        handleIntent(intent)
    }

    override fun handleIntent(intent: IndicatorIntent) {

        when (intent) {

            is GetIndicatorsIntent -> {
                getIndicators()
            }

            is IndicatorIntent.GetIndicatorByName -> {

                getIndicatorByName(intent.name)
            }

            is IndicatorIntent.GetIndicatorByNameAndDate -> {

                getIndicatorByNameAndDate(intent.indicatorName, intent.indicatorDate)
            }

            is IndicatorIntent.GetIndicatorByNameAndYear -> {

                getIndicatorByNameAndDate(intent.indicatorName, intent.indicatorYear)
            }


        }
    }

    private fun getIndicators() {

        viewModelScope.launch {

            val response = getIndicatorsUseCase.execute()

            when (response.result) {

                BaseResult.SUCCESSFUL -> {

                    response.payload?.let { indicators ->
                        _state.update {
                            it.copy(indicatorList = getIndicatorsList(indicators))
                        }
                    }
                }

                else -> {

                }
            }
        }
    }

    private fun getIndicatorByName(name:String){

        viewModelScope.launch {

            val response = getIndicatorByName.execute(name)

            when (response.result) {

                BaseResult.SUCCESSFUL -> {

                    response.payload?.let { indicator ->

                        _state.update {
                            it.copy(indicatorList = mutableListOf(indicator))
                        }
                    }
                }

                else -> {

                }
            }
        }
    }

    private fun getIndicatorByNameAndDate(name:String, date:String){

        viewModelScope.launch {

            val response = getIndicatorByNameAndDate.execute(name, date)

            when (response.result) {

                BaseResult.SUCCESSFUL -> {

                    response.payload?.let { indicator ->

                        _state.update {
                            it.copy(indicatorList = listOf<Indicator>(indicator))
                        }
                    }
                }

                else -> {

                }
            }
        }
    }

    private fun getIndicatorByNameAndYear(name:String, year:String){

        viewModelScope.launch {

            val response = getIndicatorByNameAndYear.execute(name, year)

            when (response.result) {

                BaseResult.SUCCESSFUL -> {

                    response.payload?.let { indicator ->

                        _state.update {
                            it.copy(indicatorList = listOf<Indicator>(indicator))
                        }
                    }
                }

                else -> {

                }
            }
        }
    }

    fun getIndicatorsList(indicators: Indicators):List<Indicator>{

        val _indicators = mutableListOf<Indicator>()

        with(_indicators){
            add(indicators.uf)
            add(indicators.ivp)
            add(indicators.dolar)
            add(indicators.dollarExchange)
            add(indicators.euro)
            add(indicators.ipc)
            add(indicators.utm)
            add(indicators.imacec)
            add(indicators.tpm)
            add(indicators.copperPound)
            add(indicators.unemploymentMug)
            add(indicators.bitcoin)

        }
        return _indicators
    }
}




