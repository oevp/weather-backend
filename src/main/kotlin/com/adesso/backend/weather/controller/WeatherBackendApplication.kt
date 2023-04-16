package com.adesso.backend.weather.controller

import com.adesso.backend.weather.model.WeatherInfo
import com.adesso.backend.weather.services.OpenMeteoService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class WeatherBackendApplication

fun main(args: Array<String>) {
    runApplication<WeatherBackendApplication>(*args)
}

@RestController
@RequestMapping("/forecast")
class WeatherBackendController {

    var meteoService: OpenMeteoService = OpenMeteoService()

    @GetMapping("/get")
    fun index(@RequestParam(name = "lat") lat: String, @RequestParam(name = "long") long: String): WeatherInfo {
        return meteoService.getForecast(lat, long)
    }
}