package com.adesso.backend.weather.services

import com.adesso.backend.weather.model.openmeteo.ForecastResponse
import com.adesso.backend.weather.model.WeatherInfo
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.rmi.ServerException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class OpenMeteoService {
    private val FORECAST_URL = "https://api.open-meteo.com/v1/forecast"

    @Throws(IOException::class)
    fun getForecast(latitude: String, longitude: String): WeatherInfo {
        // Create request
        val url = URL("$FORECAST_URL?latitude=$latitude&longitude=$longitude&current_weather=true")
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "GET"
        con.setRequestProperty("Accept-Encoding", "application/json")

        // Check status
        if (con.responseCode != HttpURLConnection.HTTP_OK) {
            throw ServerException("HTTP status code received from Open Meteo server: " + con.responseCode)
        }

        // Read response
        val response = con.inputStream.bufferedReader().readText()
        val mapper = jacksonObjectMapper()
        val meteoData = mapper.readValue<ForecastResponse>(response)
        con.disconnect()

        return WeatherInfo(
                meteoData.latitude,
                meteoData.longitude,
                meteoData.timezone,
                meteoData.elevation,
                meteoData.current_weather.temperature,
                meteoData.current_weather.windspeed,
                meteoData.current_weather.winddirection,
                meteoData.current_weather.time
        )
    }
}