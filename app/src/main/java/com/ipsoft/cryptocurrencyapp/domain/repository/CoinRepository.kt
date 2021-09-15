package com.ipsoft.cryptocurrencyapp.domain.repository

import com.ipsoft.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.ipsoft.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto

}