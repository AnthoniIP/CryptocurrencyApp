package com.ipsoft.cryptocurrencyapp.domain.use_case.get_coin

import com.ipsoft.cryptocurrencyapp.common.Resource
import com.ipsoft.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.ipsoft.cryptocurrencyapp.domain.model.CoinDetail
import com.ipsoft.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("couldn't reach server. Check your internet connection"))
        }
    }
}