package jp.ac.okinawa_ct.nitoc_ict.e_2203.data

sealed class NetworkResponse<out R> {

    data class Success<out T>(val response: T): NetworkResponse<T>()

    data class Failure(
        val exception: java.lang.Exception,
    ): NetworkResponse<Nothing>()
}