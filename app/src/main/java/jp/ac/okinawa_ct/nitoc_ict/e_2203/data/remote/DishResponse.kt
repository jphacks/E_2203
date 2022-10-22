package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote

import com.squareup.moshi.Json

data class DishResponse(
    @Json(name = "dish_id")
    val dishId: Int,
    @Json(name = "dish_name")
    val name: String,
)