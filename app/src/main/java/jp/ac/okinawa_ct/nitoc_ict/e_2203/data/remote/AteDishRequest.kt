package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote

import com.squareup.moshi.Json

data class AteDishRequest(
    @Json(name = "user_id")     val userId: Int,
    @Json(name = "dish_id")     val dishId: Int,
    @Json(name = "month")       val month: Int,
    @Json(name = "time_hour")   val hour: Int,
    @Json(name = "temperature") val temperature: Double,
    @Json(name = "latitude")    val latitude: Double,
    @Json(name = "longitude")   val longitude: Double,
)