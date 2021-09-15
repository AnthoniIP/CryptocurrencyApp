package com.ipsoft.cryptocurrencyapp.presentation.coin_detail

import com.ipsoft.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""

)
