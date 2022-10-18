package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

interface UserRepository {
    suspend fun getUserId(): Result<String>

    suspend fun updateUserId(id: String): Result<String>
}