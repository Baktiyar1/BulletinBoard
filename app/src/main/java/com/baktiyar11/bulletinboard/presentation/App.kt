package com.baktiyar11.bulletinboard.presentation

import android.app.Application
import android.content.SharedPreferences
import androidx.room.Room
import com.baktiyar11.bulletinboard.data.database.AppDB
import com.baktiyar11.bulletinboard.utils.APPLICATION_ID
import com.baktiyar11.bulletinboard.utils.CLIENT_KEY
import com.baktiyar11.bulletinboard.utils.SERVER_URL
import com.parse.Parse

class App : Application() {
    companion object {
        var pref: SharedPreferences? = null
        var appDatabase: AppDB? = null
    }

    override fun onCreate() {
        super.onCreate()
        Room.databaseBuilder(this, AppDB::class.java, "category_database").build()
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(SERVER_URL)
                .build())
    }
}