package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") api_token: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ja"
        ): Response<WeatherResponse>

}

