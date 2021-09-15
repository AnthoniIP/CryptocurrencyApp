package com.ipsoft.cryptocurrencyapp.di

import com.ipsoft.cryptocurrencyapp.common.Constants
import com.ipsoft.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.ipsoft.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.ipsoft.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository = CoinRepositoryImpl(api)


}