package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

/**
 * ネットワークの処理の結果を表現するクラス
 */
sealed class NetworkResponse<out R> {

    /**
     * 成功を表現するクラス
     * @property response   レスポンス
     */
    data class Success<out T>(val response: T): NetworkResponse<T>()

    /**
     * 失敗を表現するクラス
     * @property exception  例外
     */
    data class Failure(
        val exception: java.lang.Exception,
    ): NetworkResponse<Nothing>()
}