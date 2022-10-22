package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import android.accounts.NetworkErrorException
import android.location.Location
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.ac.okinawa_ct.nitoc_ict.e_2203.BuildConfig
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Result
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.Situation
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SituationRepositoryImpl : SituationRepository {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofitService: WeatherApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.openweathermap.org/")
            .build()
            .create(WeatherApiService::class.java)
    }

    override suspend fun getSituation(location: Location): Result<Situation> {
        val currentWeather = retrofitService.getWeather(
            location.latitude,
            location.longitude,
            BuildConfig.WEATHER_API_KEY,
        )

        if (currentWeather.isSuccessful) {
            val situation = Situation(
                weatherResponse = currentWeather.body()!!
            )
            return Result.OK(situation)
        }

        return Result.Error(NetworkErrorException("リクエストが失敗しました"))
    }
}