package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote

import com.squareup.moshi.Json

data class UserIdResponse(
    @Json(name = "user_id")
    val userId: Int,
)