package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote

import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "coord")   val coord: Coord,
    @Json(name = "weather") val weather: Weather,
    @Json(name = "main")    val main: Main,
    @Json(name = "wind")    val wind: Wind,
) {

    data class Coord(
        @Json(name = "lon")
        val longitude: Double,
        @Json(name = "lat")
        val latitude: Double,
    )

    data class Weather(
        @Json(name = "id")
        val id: Int,
        @Json(name = "main")
        val main: String
    )

    data class Main(
        @Json(name = "temp")
        val temp: Double,
        @Json(name = "feels_like")
        val feelsLikeTemp: Double,
        @Json(name = "temp_min")
        val tempMin: Double,
        @Json(name = "temp_max")
        val tempMax: Double,
        @Json(name = "pressure")
        val pressure: Int,
        @Json(name = "humidity")
        val humidity: Int,
        @Json(name = "sea_level")
        val seaLevel: Int,
        @Json(name = "grnd_level")
        val grandLevel: Int,
    )

    data class Wind(
        @Json(name = "speed")
        val speed: Double,
        @Json(name = "deg")
        val deg: Double,
        @Json(name = "gust")
        val gust: Double,
    )
}