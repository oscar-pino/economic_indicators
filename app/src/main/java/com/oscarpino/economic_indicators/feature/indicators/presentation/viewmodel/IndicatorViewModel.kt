package com.oscarpino.economic_indicators.feature.indicators.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.oscarpino.common.base.BaseResponse
import com.oscarpino.common.base.BaseResult
import com.oscarpino.common.base.BaseViewModel
import com.oscarpino.domain.model.Indicator
import com.oscarpino.domain.model.Indicators
import com.oscarpino.domain.usecase.GetIndicatorsUseCase
import com.oscarpino.economic_indicators.feature.indicators.presentation.intent.IndicatorIntent
import com.oscarpino.economic_indicators.feature.indicators.presentation.intent.IndicatorIntent.GetIndicatorByIndicatorName
import com.oscarpino.economic_indicators.feature.indicators.presentation.intent.IndicatorIntent.GetIndicatorsIntent
import com.oscarpino.economic_indicators.feature.indicators.presentation.state.IndicatorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IndicatorViewModel @Inject constructor(
    val getIndicatorsUseCase: GetIndicatorsUseCase
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

            is GetIndicatorByIndicatorName -> {


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

