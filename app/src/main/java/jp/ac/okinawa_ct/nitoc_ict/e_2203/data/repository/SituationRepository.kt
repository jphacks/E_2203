package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation

/**
 * [Situation] の操作をするリポジトリ
 */
interface SituationRepository {
    /**
     * 現在の状況を取得するメソッド
     */
    suspend fun getSituation(): Result<Situation>
}