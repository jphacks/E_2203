package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation

interface DishRepository {
    suspend fun getRecommendedDishList(situation: Situation): Result<List<Dish>>

    suspend fun getDishList(): Result<List<Dish>>

    suspend fun sendAteDish(dish: Dish, situation: Situation): Result<Nothing>
}