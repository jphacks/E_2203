package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

/**
 * 料理を表現するクラス
 *
 * @property name       料理の名前
 * @property recipeUrl  この料理のレシピの検索結果のURL
 * @property mapUrl     この料理のGoogleMapの検索結果のURL
 */
data class Dish(
    val name: String,
    val recipeUrl: String,
    val mapUrl: String,
)