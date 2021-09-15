package com.ipsoft.cryptocurrencyapp.data.remote

import com.ipsoft.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.ipsoft.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coindId}")
    suspend fun getCoin(@Path("coindId") coindId: String): CoinDetailDto


}