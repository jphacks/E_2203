package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

sealed class Result<out R> {

    data class OK<out T>(val response: T): Result<T>()

    data class Error(
        val exception: java.lang.Exception,
    ): Result<Nothing>()
}