package com.oscarpino.economic_indicators.di

import com.oscarpino.data.data.IndicatorApi
import com.oscarpino.repository.IndicatorRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import repository.IndicatorRepository


@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun provideIndicatorRepository(api: IndicatorApi): IndicatorRepository{
        return IndicatorRepositoryImp(api)
    }

}