package jp.ac.okinawa_ct.nitoc_ict.e_2203.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserRepositoryImpl(context: Context) : UserRepository {
    companion object {
        private val USER_ID = stringPreferencesKey("user_id")
    }

    private val dataStore: DataStore<Preferences> = context.dataStore

    override val userId: Flow<String?>
        get() = dataStore.data.map {
                preferences -> preferences[USER_ID]
        }

    override suspend fun saveUserId(id: String) {
        dataStore.edit { preferences ->
            preferences[USER_ID] = id
        }
    }
}