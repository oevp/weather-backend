package com.adesso.backend.weather

import com.adesso.backend.weather.controller.WeatherBackendApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(WeatherBackendApplication::class.java)
    }
}
