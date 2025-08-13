package com.example.gamification2.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

// ключ доступа
const val accessKey: String = "0c9aec4d-0b85-41c3-9c45-488485f4217d"

interface ApiService {
    @Headers("X-Yandex-Weather-Key: $accessKey")
    @POST("graphql")
    suspend fun geWeather(@Body queryRequest: QueryRequest): Response<ResponseBody>
}
