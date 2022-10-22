package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import kotlinx.coroutines.flow.Flow

/**
 * ユーザーのデータを操作するリポジトリ
 */
interface UserRepository {
    /**
     * UserのIDを取得するメソッド
     */
    val userId: Flow<Int?>

    /**
     * UserのIDをストレージに上書きするメソッド
     */
    suspend fun createUser()
}