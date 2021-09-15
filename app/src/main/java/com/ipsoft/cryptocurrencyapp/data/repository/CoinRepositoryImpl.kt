package com.ipsoft.cryptocurrencyapp.data.repository

import com.ipsoft.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.ipsoft.cryptocurrencyapp.data.remote.dto.CoinDto
import com.ipsoft.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = api.getCoins()
    override suspend fun getCoinById(coinId: String) = api.getCoin(coinId)
}