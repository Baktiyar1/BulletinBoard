package com.baktiyar11.bulletinboard.presentation

import android.app.Application
import com.baktiyar11.bulletinboard.utils.APPLICATION_ID
import com.baktiyar11.bulletinboard.utils.CLIENT_KEY
import com.baktiyar11.bulletinboard.utils.SERVER_URL
import com.parse.Parse

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(SERVER_URL)
                .build())
    }
}