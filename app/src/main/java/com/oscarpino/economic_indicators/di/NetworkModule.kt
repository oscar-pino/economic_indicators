package com.oscarpino.economic_indicators.di

import com.oscarpino.data.data.IndicatorApi
import com.oscarpino.economic_indicators.data.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesClient(): OkHttpClient{
        val client = OkHttpClient.Builder()
        client.addInterceptor(OkHttpProfilerInterceptor())
        return client.build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): IndicatorApi {
        return retrofit.create(IndicatorApi::class.java)
    }
}