package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import android.accounts.NetworkErrorException
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Result
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote.AteDishRequest
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote.DishApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DishRepositoryImpl : DishRepository{
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofitService: DishApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("http://10.0.2.2/")
            .build()
            .create(DishApiService::class.java)
    }

    override suspend fun getRecommendedDishList(
        id: Int,
        situation: Situation,
    ): Result<List<Dish>> {
        val dishResponseList = retrofitService.getRecommendedDishList(
            id,
            situation.month,
            situation.timeHour,
            situation.feelsLikeTemp,
            situation.longitude,
            situation.latitude,
        )
        if (dishResponseList.isSuccessful) {
            return Result.OK(
                dishResponseList.body()!!.map { dishResponse ->
                    Dish(dishResponse)
                }
            )
        }
        return Result.Error(NetworkErrorException("リクエストが失敗しました"))
    }

    override suspend fun getDishList(): Result<List<Dish>> {
        val dishResponseList = retrofitService.getDishList()
        if (dishResponseList.isSuccessful) {
            return Result.OK(
                dishResponseList.body()!!.map { dishResponse ->
                    Dish(dishResponse)
                }
            )
        }
        return Result.Error(NetworkErrorException("リクエストが失敗しました"))
    }

    override suspend fun sendAteDish(
        userID: Int,
        situation: Situation,
        dish: Dish
    ): Result<Nothing?> {
        val response = retrofitService.postAteDish(
            AteDishRequest(
                userID,
                dish.id,
                situation.month,
                situation.timeHour,
                situation.feelsLikeTemp,
                situation.latitude,
                situation.longitude
            )
        )
        if (response.isSuccessful) {
            return Result.OK(null)
        }
        return Result.Error(NetworkErrorException("リクエストが失敗しました"))

    }
}