package asha.binar.latihandatastore_challenge

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreLogin(context : Context) {

    private val dataStore: DataStore<Preferences> = context.createDataStore(name = "user_pref")

    companion object{
        val USERNAME = preferencesKey<String>("USER_USERNAME")
        val PASSWORD = preferencesKey<String>("USER_PASSWORD")
    }

    //menambahkan data ke shared preferences
    suspend fun saveData(username : String, password : String) {
        dataStore.edit {
            it[USERNAME] = username
            it[PASSWORD] = password
        }
    }

    //untuk clear data yang ada di data store preferences
    suspend fun clearData(){
        dataStore.edit {
            it.clear()
        }
    }

    val userUsernameFlow : Flow<String> = dataStore.data.map {
        it[USERNAME] ?: ""
    }

}