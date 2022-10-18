package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation

interface SituationRepository {
    suspend fun getSituation(): Result<Situation>
}