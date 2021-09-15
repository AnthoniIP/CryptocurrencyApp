package com.ipsoft.cryptocurrencyapp.data.remote

import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoin()


}