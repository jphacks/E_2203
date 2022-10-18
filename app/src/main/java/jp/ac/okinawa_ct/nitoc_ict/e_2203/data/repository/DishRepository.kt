package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Dish
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation

/**
 * [Dish]の操作を行うリポジトリ
 */
interface DishRepository {
    /**
     * 状況を基に、ユーザーのおすすめする料理を取得するメソッド
     *
     * @param id        UserのID
     * @param situation 状況
     */
    suspend fun getRecommendedDishList(id: String, situation: Situation): Result<List<Dish>>

    /**
     * 料理のリストを取得するメソッド
     */
    suspend fun getDishList(): Result<List<Dish>>

    /**
     * 食べた料理を状況と一緒に送信するメソッド
     *
     * @param id        UserのID
     * @param situation 食べた時の[Situation]
     * @param dish      食べた[Dish]
     */
    suspend fun sendAteDish(id: String, situation: Situation, dish: Dish): Result<Nothing>
}