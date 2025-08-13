package com.example.gamification2.network

data class QueryRequest(
    val query: String,
    val variables: Map<String, Any>? = null
)

data class Weather(
//    val temperature: Int,
//    val icon: String // А может быть Uri или Url?

    val s: String
)

data class ResponseBody(
    val data: DataResponse
)

data class DataResponse(
    val weather: Weather?
)
