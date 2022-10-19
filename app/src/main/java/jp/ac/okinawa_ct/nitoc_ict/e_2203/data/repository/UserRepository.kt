package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Result

/**
 * ユーザーのデータを操作するリポジトリ
 */
interface UserRepository {
    /**
     * UserのIDを取得するメソッド
     */
    suspend fun getUserId(): Result<String>

    /**
     * UserのIDをストレージに上書きするメソッド
     */
    suspend fun updateUserId(id: String): Result<String>
}