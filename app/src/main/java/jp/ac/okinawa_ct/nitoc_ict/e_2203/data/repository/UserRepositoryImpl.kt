package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.ac.okinawa_ct.nitoc_ict.e_2203.data.remote.DishApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserRepositoryImpl(context: Context) : UserRepository {
    companion object {
        private val USER_ID = intPreferencesKey("user_id")
    }

    private val dataStore: DataStore<Preferences> = context.dataStore

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofitService: DishApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("http://10.0.2.2/")
            .build()
            .create(DishApiService::class.java)
    }

    override val userId: Flow<Int?>
        get() = dataStore.data.map {
                preferences -> preferences[USER_ID]
        }

    override suspend fun createUser() {
        val response = retrofitService.createUser()
        if (response.isSuccessful){
            dataStore.edit { preferences ->
                preferences[USER_ID] = response.body()!!.userId
            }
        }
    }
}