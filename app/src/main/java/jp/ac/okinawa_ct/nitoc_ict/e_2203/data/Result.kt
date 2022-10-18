package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

/**
 * 失敗する可能性のある処理の結果を表現するクラス
 */
sealed class Result<out R> {

    /**
     * 処理が成功したことを表現するクラス
     *
     * @property data   取得できたデータ
     */
    data class OK<out T>(val data: T): Result<T>()

    /**
     * 処理が失敗したことを表現するクラス
     */
    data class Error(
        val exception: java.lang.Exception,
    ): Result<Nothing>()
}