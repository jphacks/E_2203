package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote.DishResponse
import java.net.URLEncoder

/**
 * 料理を表現するクラス
 *
 * @property name       料理の名前
 * @property recipeUrl  この料理のレシピの検索結果のURL
 * @property mapUrl     この料理のGoogleMapの検索結果のURL
 */
data class Dish(
    val id: Int,
    val name: String,
    val recipeUrl: String,
    val mapUrl: String,
){
    constructor(dishResponse: DishResponse): this(
        dishResponse.dishId,
        dishResponse.name,
        "https://cookpad.com/search/${URLEncoder.encode(dishResponse.name, "utf-8")}",
        "https://www.google.co.jp/maps/search/${URLEncoder.encode(dishResponse.name, "utf-8")}",
    )
}