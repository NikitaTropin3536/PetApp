package com.example.gamification2.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository {
    suspend fun fetchWeather(
        latitude: Double,
        longitude: Double
    ): Weather? {
        val query = "query GetWeatherNow(\$latitude: Int, \$longitude: Int) { weatherByPoint( request: { lat: \$latitude, lon: \$longitude } ) { now { temperature icon(format: SVG) } } }"
        val variables = mapOf(
            "latitude" to latitude,
            "longitude" to longitude
        )

        val queryRequest = QueryRequest(query, variables)

        return withContext(Dispatchers.IO) {
            val response = ApiClient.apiService.geWeather(queryRequest)
            response.body()?.data?.weather
        }
    }
}
