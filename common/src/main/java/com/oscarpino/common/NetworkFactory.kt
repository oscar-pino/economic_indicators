package com.oscarpino.common

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkFactory {

    companion object {
        @JvmStatic
        fun makeRetrofit(baseUrl: String): Retrofit {

            return Retrofit.Builder().addConverterFactory(
                GsonConverterFactory
                    .create()
            ).baseUrl(baseUrl).build()

        }
    }
}