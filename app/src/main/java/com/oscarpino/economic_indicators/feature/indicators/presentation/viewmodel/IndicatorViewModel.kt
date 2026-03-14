package com.oscarpino.economic_indicators.feature.indicators.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.oscarpino.common.base.BaseResponse
import com.oscarpino.common.base.BaseResult
import com.oscarpino.common.base.BaseViewModel
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
    val getIndicatorsUseCase: GetIndicatorsUseCase,
    override val initialState: IndicatorState = IndicatorState()

) :
    BaseViewModel<IndicatorState, IndicatorIntent>() {



    override fun sendIntent(intent: IndicatorIntent) {
        handleIntent(intent)
    }

    override fun handleIntent(intent: IndicatorIntent) {

        when (intent) {

            is GetIndicatorsIntent -> {


            }

            is GetIndicatorByIndicatorName -> {


            }

        }
    }

    private fun getIndicators() {

        viewModelScope.coroutineContext.cancelChildren()

        viewModelScope.launch {

            _state.update {
                it.copy(indicatorList = emptyList())
            }

            val indicatorResponse = getIndicatorsUseCase.execute()

            when (indicatorResponse.result) {

                BaseResult.SUCCESSFUL -> {


                }

                BaseResult.ERROR -> {


                }


            }
        }
    }

}