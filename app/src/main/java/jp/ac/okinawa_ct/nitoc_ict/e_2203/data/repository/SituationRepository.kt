package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import android.location.Location
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Result

/**
 * [Situation] の操作をするリポジトリ
 */
interface SituationRepository {
    /**
     * 現在の状況を取得するメソッド
     */
    suspend fun getSituation(location: Location): Result<Situation>
}