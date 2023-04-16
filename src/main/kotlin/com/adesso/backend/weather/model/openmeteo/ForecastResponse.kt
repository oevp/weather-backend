package com.adesso.backend.weather.model.openmeteo

import java.math.BigDecimal

// Model for Open Meteo's Forecast response

data class ForecastResponse(
        val latitude: BigDecimal,
        val longitude: BigDecimal,
        val generationtime_ms: BigDecimal,
        val utc_offset_seconds: Int,
        val timezone: String,
        val timezone_abbreviation: String,
        val elevation: BigDecimal,
        val current_weather: CurrentWeather
)

data class CurrentWeather (
        val temperature: BigDecimal,
        val windspeed: BigDecimal,
        val winddirection: BigDecimal,
        val weathercode: Int,
        val is_day: Int,
        val time: String
)