package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DishApiService {
    @GET("recommend")
    suspend fun getRecommendedDishList(
        @Query("user_id")       userId: Int,
        @Query("month")         month: Int,
        @Query("time_hour")     hour: Int,
        @Query("temperature")   temperature: Double,
        @Query("latitude")      latitude: Double,
        @Query("longitude")     longitude: Double,
    ): Response<List<DishResponse>>

    @GET("dish_list")
    suspend fun getDishList(): Response<List<DishResponse>>

    @POST("ate_dish")
    suspend fun postAteDish(
        @Body body: AteDishRequest
    ): Response<Void>

    @GET("create_user")
    suspend fun createUser(): Response<UserIdResponse>
}