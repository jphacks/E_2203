package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote.WeatherResponse
import java.time.LocalDateTime

/**
 * 状況を表現するクラス
 *
 * @property date   日付
 */
data class Situation(
    val month: Int,
    val timeHour: Int,
    val latitude: Double,
    val longitude: Double,
    val weatherId: Int,
    val feelsLikeTemp: Double,
    val pressure: Int,
    val humidity: Int,
){
    constructor(
        dateTime: LocalDateTime = LocalDateTime.now(),
        weatherResponse: WeatherResponse,
    ): this(
        dateTime.monthValue,
        dateTime.hour,
        weatherResponse.coord.latitude,
        weatherResponse.coord.longitude,
        weatherResponse.weather.id,
        weatherResponse.main.feelsLikeTemp,
        weatherResponse.main.pressure,
        weatherResponse.main.humidity,
    )
}
