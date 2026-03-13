package com.oscarpino.economic_indicators.feature.indicators.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.oscarpino.domain.usecase.GetIndicatorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IndicatorViewModel @Inject constructor(val getIndicatorsUseCase: GetIndicatorsUseCase): ViewModel() {


}