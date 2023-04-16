package com.adesso.backend.weather.model

import java.math.BigDecimal

// Model for /forecast/get response

data class WeatherInfo(
        val latitude: BigDecimal,
        val longitude: BigDecimal,
        val timezone: String,
        val elevation: BigDecimal,
        val temperature: BigDecimal,
        val windspeed: BigDecimal,
        val winddirection: BigDecimal,
        val time: String
)